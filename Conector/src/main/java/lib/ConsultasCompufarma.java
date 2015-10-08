package lib;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import server.LeituraDadosDBF;

/**
 * @author Renato Barbosa
 * 
 */

public class ConsultasCompufarma {
	LeituraDadosDBF lerDados = new LeituraDadosDBF();
	ObjetoRetorno objetoRetorno = new ObjetoRetorno();
	ConsultaSoft consultaSoft = new ConsultaSoft();
	int produtoIguais = 0;
	private int qtdCodigoBarrasAtivos = 0;
	private int qtdItemEstoque;
	
	/**
	 * Esse método tem a função de carregar a lista de produtos do sistema Compufarma para uma lista de objetos,
	 * na busca de melhorar o desempenho.
	 * @param selectedFile
	 * @return
	 */
	public List<ProdutosCompufarma> consultasProdutosCompufarma(File selectedFile){
		List<ProdutosCompufarma> buscarProdutos = lerDados.buscarProdutos(selectedFile);
		
		return buscarProdutos;
	}
	
	/**
	 * Esse método tem a função de carregar os produtos ativos do Softpharma para uma lista de objetos,
	 * na busca de melhorar o desempenho.
	 * @param modelo
	 * @return
	 */
	public List<ProdutosSoftpharma> consultaProdutosAtivosSoft(TelaModelo modelo){
		List<ProdutosSoftpharma> pesquisaProdutosAtivos = consultaSoft.pesquisaProdutosAtivos(modelo);
		
		return pesquisaProdutosAtivos;
	}

	public ObjetoRetorno comparacao(List<ProdutosCompufarma> listaCompufarma, List<ProdutosSoftpharma> listaSoft) {

		qtdItemEstoque = lerDados.getQtdItemEstoque();
		qtdCodigoBarrasAtivos = lerDados.getQtdCodigoBarrasAtivos();

		double porcent = ((qtdCodigoBarrasAtivos * 100) / qtdItemEstoque);

		for (ProdutosCompufarma cadProdutosOrigem : listaCompufarma) {
			for (ProdutosSoftpharma retornoTeste : listaSoft) {
				if (cadProdutosOrigem.getCodbarras().equals(retornoTeste.getCodigoBarras())) {
					produtoIguais++;
				}
			}
		}
		// Contas de Porcentagem
		double porcentComparacao = ((produtoIguais * 100) / qtdCodigoBarrasAtivos);
		int quantidadeInserir = qtdItemEstoque - produtoIguais;
		double porcentagemInserir = ((quantidadeInserir * 100) / qtdItemEstoque);

		objetoRetorno.setQtdInserir(quantidadeInserir);
		objetoRetorno.setPercentualInserir(porcentagemInserir);
		objetoRetorno.setPercentual(porcent);
		objetoRetorno.setPercentualComparacao(porcentComparacao);
		objetoRetorno.setQtdCodigoBarrasAtivos(qtdCodigoBarrasAtivos);
		objetoRetorno.setQtdItemEstoque(qtdItemEstoque);
		objetoRetorno.setProdutosIguais(produtoIguais);

		return objetoRetorno;
	}

	/**
	 * Esse método tem a função de buscar no sistema Compufarma os produtos com estoque maior que 0.
	 * @param listaCompufarma
	 * @param listaSoft
	 * @return
	 */
	public EstoqueMaior0 consultaEstoqueMaior0(List<ProdutosCompufarma> listaCompufarma, List<ProdutosSoftpharma> listaSoft) {
		EstoqueMaior0 estoqueMaior0 = new EstoqueMaior0();
		CodBarra codigosBarra;
		List<CodBarra> codBarra = new ArrayList<CodBarra>();
		qtdItemEstoque = 0;
		produtoIguais = 0;
		qtdCodigoBarrasAtivos =0;
		
		for (ProdutosCompufarma cadProdutos : listaCompufarma) {
			if (cadProdutos.getQuantidade() != null && cadProdutos.getQuantidade() > 0) {
				int tamanho = cadProdutos.getCodbarras().replaceAll(" ", "").length();
				codigosBarra = new CodBarra();
				if (tamanho == 8 || tamanho == 12 || tamanho == 13 || tamanho == 14) {
					codigosBarra.setCodBarra(cadProdutos.getCodbarras());
					codBarra.add(codigosBarra);
					qtdCodigoBarrasAtivos++;
				}
				qtdItemEstoque++;
				for (ProdutosSoftpharma retornoTeste : listaSoft) {
					if (codigosBarra.getCodBarra() != null && codigosBarra.getCodBarra().equals(retornoTeste.getCodigoBarras())) {
						produtoIguais++;
					}
				}
			}
		}

		double porcent = ((qtdCodigoBarrasAtivos * 100) / qtdItemEstoque);
		double porcentComparacao = ((produtoIguais * 100) / qtdCodigoBarrasAtivos);
		int qtdInserir = qtdItemEstoque - produtoIguais;
		double porcentagemInserir = ((qtdInserir * 100) / qtdItemEstoque);

		estoqueMaior0.setQtdComEstoque(qtdItemEstoque);
		estoqueMaior0.setQtdCodBarraValido(qtdCodigoBarrasAtivos);
		estoqueMaior0.setQtdCodBarraIguais(produtoIguais);
		estoqueMaior0.setQtdInserir(qtdInserir);
		estoqueMaior0.setPercentOrigem(porcent);
		estoqueMaior0.setPercentCompara(porcentComparacao);
		estoqueMaior0.setPercentInserir(porcentagemInserir);

		return estoqueMaior0;

	}

	public Boolean testeConexao(TelaModelo modelo) {
		if (consultaSoft.validarConexao(modelo)) {
			return true;
		} else {
			return false;
		}

	}

}
