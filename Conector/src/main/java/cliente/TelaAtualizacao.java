package cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import componentes.spTable;
import lib.ConsultaSoft;
import lib.ModelTAbelaTributacao;
import lib.ModeloTabelaTributacaoSoft;
import lib.ProdutosSoftpharma;
import lib.TableCheckBox;
import lib.Tributacao;
import lib.TributacaoSoftpharma;

public class TelaAtualizacao extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private spTable retornarTabela;
	private JTable retornoTabelaTributacao;
	private JTable retornoTabelaTributacaoSoft;
	Set<Tributacao> listaTributacao = new LinkedHashSet<Tributacao>();
	List<TributacaoSoftpharma> listaTributacaoSoft = new ArrayList<TributacaoSoftpharma>();
	List<ProdutosSoftpharma> listaProduto = new ArrayList<ProdutosSoftpharma>();
	private JTable table_1;
	private JTable table_2;
	private DefaultTableModel defaultTableModel;
	private ModelTAbelaTributacao modelo;
	private JButton btnAvanar;
	private JButton btnConfirmar;
	private JPanel jpTabbedAtualizacao;
	private JPanel jpDePara;
	private JPanel jpSoftpharma;
	private JPanel jpBox;

	public TelaAtualizacao(List<ProdutosSoftpharma> lista, Set<Tributacao> listaTributacao,
			List<TributacaoSoftpharma> listaTributacaoSoftpharma) {
		this.listaProduto = lista;
		this.listaTributacao = listaTributacao;
		this.listaTributacaoSoft = listaTributacaoSoftpharma;
		inicializarTela();
		verificaTabela(lista);

	}

	private void inicializarTela() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 302, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);

		jpBox = new JPanel();
		scrollPane.setViewportView(jpBox);

		
		TableCheckBox tes = new TableCheckBox();
		retornarTabela = tes.retornarTabela();
		
		jpBox.setLayout(new BorderLayout(0, 0));
		jpBox.add(retornarTabela, BorderLayout.CENTER);

		jpTabbedAtualizacao = new JPanel();
		GridBagConstraints gbc_jpTabbedAtualizacao = new GridBagConstraints();
		gbc_jpTabbedAtualizacao.insets = new Insets(0, 0, 5, 0);
		gbc_jpTabbedAtualizacao.fill = GridBagConstraints.BOTH;
		gbc_jpTabbedAtualizacao.gridx = 1;
		gbc_jpTabbedAtualizacao.gridy = 0;
		getContentPane().add(jpTabbedAtualizacao, gbc_jpTabbedAtualizacao);
		GridBagLayout gbl_jpTabbedAtualizacao = new GridBagLayout();
		gbl_jpTabbedAtualizacao.columnWidths = new int[] { 0, 0 };
		gbl_jpTabbedAtualizacao.rowHeights = new int[] { 0, 0 };
		gbl_jpTabbedAtualizacao.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_jpTabbedAtualizacao.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		jpTabbedAtualizacao.setLayout(gbl_jpTabbedAtualizacao);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		jpTabbedAtualizacao.add(tabbedPane, gbc_tabbedPane);

		JPanel jpAbaTributacao = new JPanel();
		tabbedPane.addTab("Tributação", null, jpAbaTributacao, null);
		GridBagLayout gbl_jpAbaTributacao = new GridBagLayout();
		gbl_jpAbaTributacao.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_jpAbaTributacao.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpAbaTributacao.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_jpAbaTributacao.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		jpAbaTributacao.setLayout(gbl_jpAbaTributacao);

		JTable table2 = new JTable();
		modelo = new ModelTAbelaTributacao();
		retornoTabelaTributacao = modelo.retornoTabelaTributacao(table2, listaTributacao);

		JPanel jpBancoConverter = new JPanel();
		jpBancoConverter.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Banco a Converter",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_jpBancoConverter = new GridBagConstraints();
		gbc_jpBancoConverter.insets = new Insets(0, 0, 5, 5);
		gbc_jpBancoConverter.fill = GridBagConstraints.BOTH;
		gbc_jpBancoConverter.gridx = 0;
		gbc_jpBancoConverter.gridy = 0;
		jpBancoConverter.setLayout(new BorderLayout(0, 0));
		jpBancoConverter.add(retornoTabelaTributacao, BorderLayout.CENTER);
		jpAbaTributacao.add(jpBancoConverter, gbc_jpBancoConverter);

		JPanel jpBotoes = new JPanel();
		GridBagConstraints gbc_jpBotoes = new GridBagConstraints();
		gbc_jpBotoes.insets = new Insets(0, 0, 5, 5);
		gbc_jpBotoes.gridx = 1;
		gbc_jpBotoes.gridy = 0;
		jpAbaTributacao.add(jpBotoes, gbc_jpBotoes);
		GridBagLayout gbl_jpBotoes = new GridBagLayout();
		gbl_jpBotoes.columnWidths = new int[] { 0, 0 };
		gbl_jpBotoes.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpBotoes.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_jpBotoes.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpBotoes.setLayout(gbl_jpBotoes);

		JButton btnNewButton = new JButton(">>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iteracaoEntreTabelas();
			}

		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		jpBotoes.add(btnNewButton, gbc_btnNewButton);

		JButton button = new JButton("<<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voltarParaTabela();
			}

		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		jpBotoes.add(button, gbc_button);

		jpSoftpharma = new JPanel();
		jpSoftpharma.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Softpharma",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_jpSoftpharma = new GridBagConstraints();
		gbc_jpSoftpharma.insets = new Insets(0, 0, 5, 5);
		gbc_jpSoftpharma.fill = GridBagConstraints.BOTH;
		gbc_jpSoftpharma.gridx = 2;
		gbc_jpSoftpharma.gridy = 0;
		jpAbaTributacao.add(jpSoftpharma, gbc_jpSoftpharma);
		jpSoftpharma.setLayout(new BorderLayout(0, 0));

		table_1 = new JTable();
		ModeloTabelaTributacaoSoft modeloSoft = new ModeloTabelaTributacaoSoft();
		retornoTabelaTributacaoSoft = modeloSoft.retornoTabelaTributacao(table_1, listaTributacaoSoft);
		jpSoftpharma.add(retornoTabelaTributacaoSoft, BorderLayout.CENTER);

		jpDePara = new JPanel();
		jpDePara.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "De > Para",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_jpDePara = new GridBagConstraints();
		gbc_jpDePara.insets = new Insets(0, 0, 5, 0);
		gbc_jpDePara.fill = GridBagConstraints.BOTH;
		gbc_jpDePara.gridx = 3;
		gbc_jpDePara.gridy = 0;
		jpAbaTributacao.add(jpDePara, gbc_jpDePara);
		jpDePara.setLayout(new BorderLayout(0, 0));

		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("");
		table_2 = new JTable(defaultTableModel);
		jpDePara.add(table_2, BorderLayout.CENTER);

		btnConfirmar = new JButton("Confirmar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 1;
		jpAbaTributacao.add(btnConfirmar, gbc_btnNewButton_1);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.YES_NO_OPTION;
				if (retornoTabelaTributacao.getModel().getRowCount() == 0) {
					resposta = JOptionPane.showConfirmDialog(null, "Tem certeza de deseja fazer a atualização",
							"Atenção", JOptionPane.WARNING_MESSAGE, resposta);

					if (resposta == JOptionPane.YES_OPTION) {
						btnAvanar.setEnabled(true);
						btnConfirmar.setEnabled(false);
						// jpTabbedAtualizacao.setVisible(false);
						enableComponents(jpTabbedAtualizacao, false);
						enableComponents(jpBox, false);
					} else {
						btnAvanar.setEnabled(false);
						btnConfirmar.setEnabled(true);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Necessário combinar todas as tributações", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		JPanel jpAvancar = new JPanel();
		GridBagConstraints gbc_jpAvancar = new GridBagConstraints();
		gbc_jpAvancar.anchor = GridBagConstraints.EAST;
		gbc_jpAvancar.fill = GridBagConstraints.VERTICAL;
		gbc_jpAvancar.gridx = 1;
		gbc_jpAvancar.gridy = 1;
		getContentPane().add(jpAvancar, gbc_jpAvancar);
		GridBagLayout gbl_jpAvancar = new GridBagLayout();
		gbl_jpAvancar.columnWidths = new int[] { 0, 0 };
		gbl_jpAvancar.rowHeights = new int[] { 0, 0 };
		gbl_jpAvancar.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_jpAvancar.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		jpAvancar.setLayout(gbl_jpAvancar);

		btnAvanar = new JButton("Avançar");
		btnAvanar.setEnabled(false);
		btnAvanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				autalizar(listaProduto);
			}
		});
		GridBagConstraints gbc_btnAvanar = new GridBagConstraints();
		gbc_btnAvanar.gridx = 0;
		gbc_btnAvanar.gridy = 0;
		jpAvancar.add(btnAvanar, gbc_btnAvanar);

		setSize(1016, 441);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private void verificaTabela(List<ProdutosSoftpharma> lista) {

		for (int i = 0; i < retornarTabela.getRowCount(); i++) {
			if (retornarTabela.getModel().getValueAt(i, 1) != null) {

				if (retornarTabela.getModel().getValueAt(i, 0) != null) {
					Boolean valueAt = (Boolean) retornarTabela.getModel().getValueAt(i, 0);
					if (valueAt == false) {
						String nomeColuna = (String) retornarTabela.getValueAt(i, 1);

						int aux = 0;
						int aux1 = 0;
						int aux2 = 0;
						int aux3 = 0;
						int aux4 = 0;
						int aux5 = 0;
						int aux6 = 0;
						int aux7 = 0;
						int aux8 = 0;
						int aux9 = 0;
						int aux10 = 0;
						int aux11 = 0;
						int aux12 = 0;
						int aux13 = 0;
						int aux14 = 0;
						int aux15 = 0;
						int aux16 = 0;
						int aux17 = 0;
						int aux18 = 0;

						switch (nomeColuna) {
						case "Registro MS":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getRegistroMs() != null && aux == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux++;
								} else {
									if (aux == 0) {
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
										aux++;
									}
								}
							}

							break;
						case "Descrição":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getDescricao() != null && aux3 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux3++;
								} else {
									if (aux3 == 0) {
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
										aux3++;
									}
								}
							}

							break;
						case "Demanda":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getDemanda() != null && aux1 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux1++;
								} else {
									if (aux1 == 0) {
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
										aux1++;
									}

								}
							}

							break;

						case "Preço de venda":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getPrecoVenda() != null && aux2 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux2++;
								} else {
									if (aux2 == 0) {
										aux2++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Lista(Positiva,Negativa,Neutra)":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getLista() != null && aux4 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux4++;
								} else {
									if (aux4 == 0) {
										aux4++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Data da Última Compra":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getDataUltimaCompra() != null && aux5 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux5++;
								} else {
									if (aux5 == 0) {
										aux5++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Data da Última Venda":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getDataUltimaVenda() != null && aux6 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux6++;
								} else {
									if (aux6 == 0) {
										aux6++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Tributação":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getTributacao() != null && aux7 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux7++;
								} else {
									if (aux7 == 0) {
										aux7++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Unidade de Medida":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getUnidadeMedida() != null && aux8 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux8++;
								} else {
									if (aux8 == 0) {
										aux8++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Preço de Custo":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getPrecoCusto() != null && aux9 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux9++;
								} else {
									if (aux9 == 0) {
										aux9++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Margem de Lucro":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getMargemLucro() != null && aux10 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux10++;
								} else {
									if (aux10 == 0) {
										aux10++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Preço de Fábrica":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getPrecoFabrica() != null && aux11 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux11++;
								} else {
									if (aux11 == 0) {
										aux11++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Custo Médio":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getCustoMedio() != null && aux12 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux12++;
								} else {
									if (aux12 == 0) {
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
										aux12++;
									}
								}
							}

							break;
						case "Fração":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getFracao() != null && aux13 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux13++;
								} else {
									if (aux13 == 0) {
										aux13++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Quantidade":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getQuantidade() != null && aux14 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux14++;
								} else {
									if (aux14 == 0) {
										aux14++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "DCB":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getDcb() != null && aux15 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux15++;
								} else {
									if (aux15 == 0) {
										aux15++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Nome Subistância":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getNomeSubistancia() != null && aux16 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux16++;
								} else {
									if (aux16 == 0) {
										aux16++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "NCM":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getNcm() != null && aux17 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux17++;
								} else {
									if (aux17 == 0) {
										aux17++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}

							break;
						case "Mínimo":
							for (ProdutosSoftpharma produtosSoftpharma : lista) {
								if (produtosSoftpharma.getMinimo() != null && aux18 == 0) {
									retornarTabela.getModel().setValueAt(true, i, 0);
									aux18++;
								} else {
									if (aux18 == 0) {
										aux18++;
										String descricao = (String) retornarTabela.getValueAt(i, 1);
										retornarTabela.getModel().setValueAt(descricao + ("(Não Encontrado)"), i, 1);
										retornarTabela.setRowColor(i, Color.LIGHT_GRAY);
									}
								}
							}
							break;

						default:
							
							break;
						}
						retornarTabela.repaint();
					}
				}
			}
		}
	}

	private void iteracaoEntreTabelas() {
		if (retornoTabelaTributacao.getSelectedRow() >= 0 && retornoTabelaTributacaoSoft.getSelectedRow() >= 0) {

			int[] selectedRows = retornoTabelaTributacao.getSelectedRows();
			for (int i : selectedRows) {

				String valueAt2 = (String) retornoTabelaTributacao.getValueAt(i, 0);
				String valueAt = (String) retornoTabelaTributacao.getValueAt(i, 1);

				String valueAt4 = (String) retornoTabelaTributacaoSoft
						.getValueAt(retornoTabelaTributacaoSoft.getSelectedRow(), 0);
				String valueAt3 = (String) retornoTabelaTributacaoSoft
						.getValueAt(retornoTabelaTributacaoSoft.getSelectedRow(), 1);
				defaultTableModel.addRow(new Object[] { valueAt2.trim() + " - " + valueAt.trim() + " ---> "
						+ valueAt4.trim() + " - " + valueAt3.trim() });
			}
			int[] selectedRows2 = retornoTabelaTributacao.getSelectedRows();
			for (int i = 0; i < selectedRows2.length; i++) {
				((DefaultTableModel) retornoTabelaTributacao.getModel()).removeRow(selectedRows2[0]);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tem que selecionar ao mesnos 1 de cada lista !", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}
		table_2.setModel(defaultTableModel);
		table_2.repaint();
		retornoTabelaTributacao.clearSelection();
		retornoTabelaTributacaoSoft.clearSelection();
	}

	private void voltarParaTabela() {

		if (table_2.getSelectedRow() >= 0) {

			String valueAt = (String) defaultTableModel.getValueAt(table_2.getSelectedRow(), 0);
			String[] split = valueAt.split("--->");
			String string = split[0];
			String[] split2 = string.split("-");
			((DefaultTableModel) retornoTabelaTributacao.getModel())
					.addRow(new Object[] { split2[0].trim(), split2[1].trim() });
			((DefaultTableModel) table_2.getModel()).removeRow(table_2.getSelectedRow());
			table_2.repaint();

		} else {
			JOptionPane.showMessageDialog(null, "Tem que selecionar ao mesnos 1 da lista para retornar", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void enableComponents(Container container, boolean enable) {
		Component[] components = container.getComponents();
		for (Component component : components) {
			component.setEnabled(enable);
			if (component instanceof Container) {
				enableComponents((Container) component, enable);
			}
		}
	}
	
	private void autalizar(List<ProdutosSoftpharma> listaProdutos) {
		
		Set<ProdutosSoftpharma> listaAtualizada = new  LinkedHashSet<ProdutosSoftpharma>();
		
		ConsultaSoft consultaSoft = new ConsultaSoft();
		
		for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
			
			String valueAt = (String)defaultTableModel.getValueAt(i, 0);
			
			String[] split = valueAt.split("-");
			
			int parseInt = Integer.parseInt(split[0].trim());
			
			String string = split[4];
			
			String[] split2 = string.split(" ");
			
			int parseInt2 = Integer.parseInt(split2[1].trim());
			
			for (ProdutosSoftpharma produtosSoftpharma : listaProdutos) {
				
				if(produtosSoftpharma.getTributacao().equals(parseInt)){
					
					produtosSoftpharma.setTributacao(parseInt2);
					listaAtualizada.add(produtosSoftpharma);
				}
				
			}
		}
		List<Boolean> listaBoolean = new ArrayList<Boolean>();
		for (int i = 0; i < 18; i++) {
			if(retornarTabela.getModel().getValueAt(i, 0) != null){
			Boolean valueAt = (Boolean)retornarTabela.getModel().getValueAt(i, 0);
			listaBoolean.add(valueAt);
			}
		}
		
		System.out.println(listaAtualizada.size());
		for (ProdutosSoftpharma produtosSoftpharma : listaProdutos) {
			listaAtualizada.add(produtosSoftpharma);
		}
		
		System.out.println(listaAtualizada.size());
		consultaSoft.dividirDescricaoEAtualizar(listaAtualizada, listaBoolean);
		
		
		JOptionPane.showMessageDialog(null, "Terminou o teste", "Alerta",
				JOptionPane.WARNING_MESSAGE);
		
		
	}
}
