package server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lib.ProdutosCompufarma;
import lib.Tributacao;
import nl.knaw.dans.common.dbflib.CorruptedTableException;
import nl.knaw.dans.common.dbflib.Field;
import nl.knaw.dans.common.dbflib.IfNonExistent;
import nl.knaw.dans.common.dbflib.Table;

/**
 * 
 * @author Renato Barbosa
 *
 */
public class LeituraDadosDBF {

	private Integer somaEstoque = 0;
	private int qtdItemEstoque = 0;
	private int qtdCodigoBarrasAtivos = 0;
	private File caminho;

	/**
	 * Esse metodos tem a função de buscar todos os produtos do Sistema
	 * Compufarma, onde a tabela de produtos é a "arqest.dbf"
	 * 
	 * @param selectedFile
	 * @return
	 */
	public List<ProdutosCompufarma> buscarProdutos(File selectedFile) {
		qtdCodigoBarrasAtivos = 0;
		caminho = selectedFile;
		List<ProdutosCompufarma> listaProdutos = new ArrayList<ProdutosCompufarma>();
		Table table = new Table(new File(selectedFile.getPath() + "\\arqest.dbf"));
		try {
			table.open(IfNonExistent.ERROR);

			List<Field> fields2 = table.getFields();
			qtdItemEstoque = table.getRecordCount();

			for (int i = 0; i < qtdItemEstoque; i++) {
				ProdutosCompufarma produto = new ProdutosCompufarma();
				for (Field field : fields2) {
					if (table.getRecordAt(i) != null) {

						if (field.getName().equals("CODPRO")) {
							String stringValue = table.getRecordAt(i).getStringValue(field.getName());
							int tamanho = stringValue.replaceAll(" ", "").length();

							// Codigo de barras Valido
							if (tamanho == 8 || tamanho == 12 || tamanho == 13 || tamanho == 14) {
								qtdCodigoBarrasAtivos++;
							}
							produto.setCodbarras(table.getRecordAt(i).getStringValue(field.getName()));
						} else if (field.getName().equals("TIPPRO")) {
							if (table.getRecordAt(i).getStringValue(field.getName()) != null) {
								produto.setTipoProduto(table.getRecordAt(i).getStringValue(field.getName()));
							}

						} else if (field.getName().equals("LABOR")) {
							if (table.getRecordAt(i).getStringValue(field.getName()) != null) {
								produto.setLab(table.getRecordAt(i).getStringValue(field.getName()));
							}
						} else if (field.getName().equals("DESPRO")) {
							if (table.getRecordAt(i).getStringValue(field.getName()) != null) {
								produto.setDescricao(table.getRecordAt(i).getStringValue(field.getName()));
							}

						} else if (field.getName().equals("PCOVEN1")) {
							if (table.getRecordAt(i).getNumberValue(field.getName()) != null) {
								produto.setPrecoVenda(
										table.getRecordAt(i).getNumberValue(field.getName()).doubleValue());
							}
						} else if (field.getName().equals("PCOCOM")) {
							if (table.getRecordAt(i).getNumberValue(field.getName()) != null) {
								produto.setPrecoCusto(
										table.getRecordAt(i).getNumberValue(field.getName()).doubleValue());
							}
						} else if (field.getName().equals("DTAALT")) {
							if (table.getRecordAt(i).getDateValue(field.getName()) != null) {
								produto.setDataUltimaVenda(table.getRecordAt(i).getDateValue(field.getName()));
							}
						} else if (field.getName().equals("MARGEM")) {
							if (table.getRecordAt(i).getNumberValue(field.getName()) != null) {
								produto.setMargemLucro(
										table.getRecordAt(i).getNumberValue(field.getName()).doubleValue());
							}
						} else if (field.getName().equals("DEMANDA")) {
							if (table.getRecordAt(i).getNumberValue(field.getName()) != null) {
								produto.setDemanda(table.getRecordAt(i).getNumberValue(field.getName()).intValue());
							}
						} else if (field.getName().equals("DCB")) {
							if (table.getRecordAt(i).getStringValue(field.getName()) != null) {
								produto.setDcb(table.getRecordAt(i).getStringValue(field.getName()));
							}
						} else if (field.getName().equals("FRACAO")) {
							if (table.getRecordAt(i).getNumberValue(field.getName()) != null) {
								produto.setFracao(table.getRecordAt(i).getNumberValue(field.getName()).doubleValue());
							}
						} else if (field.getName().equals("QTEEST")) {
							if (table.getRecordAt(i).getNumberValue(field.getName()) != null) {
								Number numberValue = table.getRecordAt(i).getNumberValue(field.getName());

								if (numberValue.intValue() > 0) {

									produto.setQuantidade(numberValue.intValue());
									somaEstoque = somaEstoque + numberValue.intValue();
								}
							}
						}
					}
				}
				listaProdutos.add(produto);
			}

			table.close();
		} catch (CorruptedTableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaProdutos;
	}

	public Set<Tributacao> pesquisaTibutacoes() {
		Table table = new Table(new File(caminho.getPath() + "\\icms.dbf"));

		Set<Tributacao> listaTributacoes = new LinkedHashSet<Tributacao>();

		try {
			table.open(IfNonExistent.ERROR);
			List<Field> fields2 = table.getFields();
			qtdItemEstoque = table.getRecordCount();

			for (int i = 0; i < qtdItemEstoque; i++) {
				Tributacao tributacaoComp = new Tributacao();
				for (Field field : fields2) {
					if (field.getName().equals("CODIGO")) {
						if (table.getRecordAt(i).getStringValue(field.getName()) != null) {
							tributacaoComp.setCodigo(table.getRecordAt(i).getStringValue(field.getName()));
						}
					} else if (field.getName().equals("ICMS")) {
						if (table.getRecordAt(i).getStringValue(field.getName()) != null) {
							tributacaoComp.setAlicota(table.getRecordAt(i).getStringValue(field.getName()));
						}
					}
				}
				listaTributacoes.add(tributacaoComp);
			}
		} catch (CorruptedTableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaTributacoes;
	}

	public Integer getSomaEstoque() {
		return somaEstoque;
	}

	public void setSomaEstoque(Integer somaEstoque) {
		this.somaEstoque = somaEstoque;
	}

	public int getQtdItemEstoque() {
		return qtdItemEstoque;
	}

	public void setQtdItemEstoque(int qtdItemEstoque) {
		this.qtdItemEstoque = qtdItemEstoque;
	}

	public int getQtdCodigoBarrasAtivos() {
		return qtdCodigoBarrasAtivos;
	}

	public void setQtdCodigoBarrasAtivos(int qtdCodigoBarrasAtivos) {
		this.qtdCodigoBarrasAtivos = qtdCodigoBarrasAtivos;
	}

}
