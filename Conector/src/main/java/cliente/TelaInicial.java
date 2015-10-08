package cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import lib.ConsultasCompufarma;
import lib.EstoqueMaior0;
import lib.ObjetoRetorno;
import lib.ProdutosCompufarma;
import lib.ProdutosSoftpharma;
import lib.TelaModelo;
import lib.Tributacao;
import lib.TributacaoSoftpharma;

/**
 * 
 * @author Renato Barbosa
 *
 */
public class TelaInicial extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static final String SELECIONAR_O_ARQUIVO_DBF = "Selecionar o arquivo .dbf";
	private Boolean conectadoSoft = false;
	ConsultasCompufarma consultas = new ConsultasCompufarma();
	TelaModelo modelo = new TelaModelo();

	private JTextField tfUsuarioSoft;
	private JTextField tfSenhaSoft;
	private JTextField tfUsuarioOrigem;
	private JTextField tfSenhaOrigem;
	private JLabel lblUsurio;
	private JLabel lblSenha;
	private JButton btnConectar;
	private JLabel lblSistemaOrigem;
	private JButton btnConectarOrigem;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lbMensagemSoft;
	private JPanel jpArquivosdbf;
	private JButton btnSelecionar;
	private JLabel lbSelecionar;
	private JComboBox<String> comboBox;
	private JPanel jpOrigem;
	private JPanel jpConexao;
	private JPanel jpTodosProdutos;
	private JPanel jpDadosOrigemProduto;
	private JTextField tfTotalProdOrigem;
	private JTextField tfCodBarraValido;
	private JLabel lblTotalLocalizadoNa;
	private JLabel lblTotalComCdigo;
	private JProgressBar progressBar;
	private JPanel jpProgresso;
	private JTextField tfporcentagem;
	private JPanel jpCompararProduto;
	private JLabel lblTotal;
	private JTextField tfTotalComparacao;
	private JLabel lblCdigoDeBarras;
	private JTextField tfCodigosIguais;
	private JTextField tfTotalPercentual;
	private JPanel jpSoft;

	// Paineis
	GridBagLayout gbl_jpSoft = new GridBagLayout();
	GridBagLayout gbl_jpOrigem = new GridBagLayout();
	GridBagLayout gbl_jpConexao = new GridBagLayout();
	GridBagConstraints gbc_jpAplicacao = new GridBagConstraints();
	GridBagConstraints gbc_jpArquivosdbf = new GridBagConstraints();
	GridBagConstraints gbc_jpConexao = new GridBagConstraints();

	File selectedFile = null;
	JFileChooser fileChooser = new JFileChooser();

	String bancoOrigem[] = { "< Selecione a base dados >", "FireBird", "CompuFarma" };
	String opcaoComparacao[] = { "Quantidade do estoque" };
	private JPanel jpInserirProduto;
	private JLabel lbTotalInseridos;
	private JTextField tfQuantidadeInserir;
	private JTextField tfPorcentagemInserido;
	private JPanel jpEstoqueMaior0;
	private JPanel jpOrigemEstoqueMaior0;
	private JLabel lbTotalEstoqueMaior0;
	private JTextField tfTotalEstoqueMaior0;
	private JLabel label_1;
	private JTextField tfCodigoValidoEstoqueMaior0;
	private JTextField tfPorcentagemEstoqueMaior0;
	private JPanel jpCompararEstoqueMaior0;
	private JLabel label_2;
	private JTextField tfTotalCoparadoEstoqueMaior0;
	private JLabel label_3;
	private JTextField tfCogidoIguaisEstoqueMaior0;
	private JTextField tfPorcentagemComparadoEstoqueMaior0;
	private JPanel jpInserirEstoqueMaior0;
	private JLabel lblQuantidadeParaInserir;
	private JTextField tfQuantidadeInserirEstorqueMaior0;
	private JTextField tfPorcentagemInserirEstoqueMaior0;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel label;
	private JTextField textField;
	private JLabel label_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel_3;
	private JLabel label_5;
	private JTextField textField_3;
	private JLabel label_6;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel panel_4;
	private JLabel label_7;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel label_8;
	private JTextField textField_8;
	private JLabel label_9;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPanel panel_7;
	private JLabel label_10;
	private JTextField textField_11;
	private JLabel label_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JPanel panel_8;
	private JLabel label_12;
	private JTextField textField_14;
	private JTextField textField_15;
	private JButton btnUtilizar;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JTextField tfIpServidor;
	private JTextField tfBanco;
	private JLabel lblNewLabel;
	private JLabel lblBanco;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaInicial() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 315, 284, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 28, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		jpSoft = new JPanel();
		jpSoft.setBorder(
				new TitledBorder(null, "Banco Softpharma", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jpSoft = new GridBagConstraints();
		gbc_jpSoft.insets = new Insets(0, 0, 5, 5);
		gbc_jpSoft.fill = GridBagConstraints.BOTH;
		gbc_jpSoft.gridx = 0;
		gbc_jpSoft.gridy = 0;
		getContentPane().add(jpSoft, gbc_jpSoft);

		gbl_jpSoft.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_jpSoft.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_jpSoft.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_jpSoft.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		jpSoft.setLayout(gbl_jpSoft);
		
		lblNewLabel = new JLabel("Ip Servidor");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		jpSoft.add(lblNewLabel, gbc_lblNewLabel);
		
		lblBanco = new JLabel("Banco");
		GridBagConstraints gbc_lblBanco = new GridBagConstraints();
		gbc_lblBanco.anchor = GridBagConstraints.WEST;
		gbc_lblBanco.insets = new Insets(0, 0, 5, 5);
		gbc_lblBanco.gridx = 1;
		gbc_lblBanco.gridy = 0;
		jpSoft.add(lblBanco, gbc_lblBanco);
		
		tfIpServidor = new JTextField();
		tfIpServidor.setText("localhost");
		tfIpServidor.selectAll();
		GridBagConstraints gbc_tfIpServidor = new GridBagConstraints();
		gbc_tfIpServidor.insets = new Insets(0, 0, 5, 5);
		gbc_tfIpServidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfIpServidor.gridx = 0;
		gbc_tfIpServidor.gridy = 1;
		jpSoft.add(tfIpServidor, gbc_tfIpServidor);
		tfIpServidor.setColumns(10);
		
		tfBanco = new JTextField();
		tfBanco.setText("softpharma");
		tfBanco.selectAll();
		GridBagConstraints gbc_tfBanco = new GridBagConstraints();
		gbc_tfBanco.insets = new Insets(0, 0, 5, 5);
		gbc_tfBanco.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBanco.gridx = 1;
		gbc_tfBanco.gridy = 1;
		jpSoft.add(tfBanco, gbc_tfBanco);
		tfBanco.setColumns(10);

		lblUsurio = new JLabel("Usuário");
		GridBagConstraints gbc_lblUsurio = new GridBagConstraints();
		gbc_lblUsurio.anchor = GridBagConstraints.WEST;
		gbc_lblUsurio.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsurio.gridx = 0;
		gbc_lblUsurio.gridy = 2;
		jpSoft.add(lblUsurio, gbc_lblUsurio);

		lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.WEST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 1;
		gbc_lblSenha.gridy = 2;
		jpSoft.add(lblSenha, gbc_lblSenha);

		tfUsuarioSoft = new JTextField();
		GridBagConstraints gbc_tfUsuarioSoft = new GridBagConstraints();
		gbc_tfUsuarioSoft.insets = new Insets(0, 0, 0, 5);
		gbc_tfUsuarioSoft.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsuarioSoft.gridx = 0;
		gbc_tfUsuarioSoft.gridy = 3;
		jpSoft.add(tfUsuarioSoft, gbc_tfUsuarioSoft);
		tfUsuarioSoft.setColumns(10);

		tfSenhaSoft = new JPasswordField();
		tfSenhaSoft.setColumns(10);
		GridBagConstraints gbc_tfSenhaSoft = new GridBagConstraints();
		gbc_tfSenhaSoft.insets = new Insets(0, 0, 0, 5);
		gbc_tfSenhaSoft.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSenhaSoft.gridx = 1;
		gbc_tfSenhaSoft.gridy = 3;
		jpSoft.add(tfSenhaSoft, gbc_tfSenhaSoft);

		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conectar();
			}

		});
		GridBagConstraints gbc_btnConectar = new GridBagConstraints();
		gbc_btnConectar.gridx = 2;
		gbc_btnConectar.gridy = 3;
		jpSoft.add(btnConectar, gbc_btnConectar);

		jpOrigem = new JPanel();
		jpOrigem.setBorder(new TitledBorder(null, "Banco Origem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jpOrigem = new GridBagConstraints();
		gbc_jpOrigem.insets = new Insets(0, 0, 5, 0);
		gbc_jpOrigem.fill = GridBagConstraints.BOTH;
		gbc_jpOrigem.gridx = 1;
		gbc_jpOrigem.gridy = 0;
		getContentPane().add(jpOrigem, gbc_jpOrigem);

		gbl_jpOrigem.columnWidths = new int[] { 200, 0 };
		gbl_jpOrigem.rowHeights = new int[] { 0, 0, 41, 0 };
		gbl_jpOrigem.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_jpOrigem.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		jpOrigem.setLayout(gbl_jpOrigem);

		lblSistemaOrigem = new JLabel("Sistema Origem");
		GridBagConstraints gbc_lblSistemaOrigem = new GridBagConstraints();
		gbc_lblSistemaOrigem.anchor = GridBagConstraints.WEST;
		gbc_lblSistemaOrigem.insets = new Insets(0, 0, 5, 0);
		gbc_lblSistemaOrigem.gridx = 0;
		gbc_lblSistemaOrigem.gridy = 0;
		jpOrigem.add(lblSistemaOrigem, gbc_lblSistemaOrigem);

		comboBox = new JComboBox(bancoOrigem);
		troca();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		jpOrigem.add(comboBox, gbc_comboBox);

		jpArquivosdbf = new JPanel();
		gbc_jpArquivosdbf.insets = new Insets(0, 0, 5, 0);
		gbc_jpArquivosdbf.gridx = 0;
		gbc_jpArquivosdbf.gridy = 2;
		GridBagLayout gbl_jpArquivosdbf = new GridBagLayout();
		gbl_jpArquivosdbf.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpArquivosdbf.rowHeights = new int[] { 0, 0 };
		gbl_jpArquivosdbf.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_jpArquivosdbf.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		jpArquivosdbf.setLayout(gbl_jpArquivosdbf);
		

		lbSelecionar = new JLabel(SELECIONAR_O_ARQUIVO_DBF);
		GridBagConstraints gbc_lbSelecionar = new GridBagConstraints();
		gbc_lbSelecionar.insets = new Insets(0, 0, 0, 5);
		gbc_lbSelecionar.gridx = 0;
		gbc_lbSelecionar.gridy = 0;
		jpArquivosdbf.add(lbSelecionar, gbc_lbSelecionar);

		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisa();
			}
		});
		GridBagConstraints gbc_btnSelecionar = new GridBagConstraints();
		gbc_btnSelecionar.gridx = 1;
		gbc_btnSelecionar.gridy = 0;
		jpArquivosdbf.add(btnSelecionar, gbc_btnSelecionar);

		jpConexao = new JPanel();

		gbc_jpConexao.fill = GridBagConstraints.BOTH;
		gbc_jpConexao.gridx = 0;
		gbc_jpConexao.gridy = 2;


		gbl_jpConexao.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_jpConexao.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpConexao.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_jpConexao.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpConexao.setLayout(gbl_jpConexao);

		JLabel lblUsurioOrigem = new JLabel("Usuário");
		GridBagConstraints gbc_lblUsurioOrigem = new GridBagConstraints();
		gbc_lblUsurioOrigem.anchor = GridBagConstraints.WEST;
		gbc_lblUsurioOrigem.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsurioOrigem.gridx = 0;
		gbc_lblUsurioOrigem.gridy = 0;
		jpConexao.add(lblUsurioOrigem, gbc_lblUsurioOrigem);

		JLabel lblSenhaOrigem = new JLabel("Senha");
		GridBagConstraints gbc_lblSenhaOrigem = new GridBagConstraints();
		gbc_lblSenhaOrigem.anchor = GridBagConstraints.WEST;
		gbc_lblSenhaOrigem.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenhaOrigem.gridx = 1;
		gbc_lblSenhaOrigem.gridy = 0;
		jpConexao.add(lblSenhaOrigem, gbc_lblSenhaOrigem);

		tfUsuarioOrigem = new JTextField();
		GridBagConstraints gbc_tfUsuarioOrigem = new GridBagConstraints();
		gbc_tfUsuarioOrigem.insets = new Insets(0, 0, 0, 5);
		gbc_tfUsuarioOrigem.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsuarioOrigem.gridx = 0;
		gbc_tfUsuarioOrigem.gridy = 1;
		jpConexao.add(tfUsuarioOrigem, gbc_tfUsuarioOrigem);
		tfUsuarioOrigem.setColumns(10);

		tfSenhaOrigem = new JPasswordField();
		tfSenhaOrigem.setColumns(10);
		GridBagConstraints gbc_tfSenhaOrigem = new GridBagConstraints();
		gbc_tfSenhaOrigem.insets = new Insets(0, 0, 0, 5);
		gbc_tfSenhaOrigem.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSenhaOrigem.gridx = 1;
		gbc_tfSenhaOrigem.gridy = 1;
		jpConexao.add(tfSenhaOrigem, gbc_tfSenhaOrigem);

		btnConectarOrigem = new JButton("Conectar");
		GridBagConstraints gbc_btnConectarOrigem = new GridBagConstraints();
		gbc_btnConectarOrigem.gridx = 2;
		gbc_btnConectarOrigem.gridy = 1;
		jpConexao.add(btnConectarOrigem, gbc_btnConectarOrigem);

		lbMensagemSoft = new JLabel("");
		GridBagConstraints gbc_lbMensagemSoft = new GridBagConstraints();
		gbc_lbMensagemSoft.insets = new Insets(0, 0, 5, 5);
		gbc_lbMensagemSoft.gridx = 0;
		gbc_lbMensagemSoft.gridy = 1;
		getContentPane().add(lbMensagemSoft, gbc_lbMensagemSoft);

		jpProgresso = new JPanel();
		GridBagConstraints gbc_jpProgresso = new GridBagConstraints();
		gbc_jpProgresso.insets = new Insets(0, 0, 5, 0);
		gbc_jpProgresso.fill = GridBagConstraints.BOTH;
		gbc_jpProgresso.gridx = 1;
		gbc_jpProgresso.gridy = 1;
		getContentPane().add(jpProgresso, gbc_jpProgresso);
		jpProgresso.setLayout(new BorderLayout(0, 0));

		progressBar = new JProgressBar(JProgressBar.HORIZONTAL);
		jpProgresso.add(progressBar, BorderLayout.CENTER);
		progressBar.setMinimum(300);
		progressBar.setMaximum(200);

		JPanel jpAplicacao = new JPanel();
		gbc_jpAplicacao.gridwidth = 2;
		gbc_jpAplicacao.fill = GridBagConstraints.BOTH;
		gbc_jpAplicacao.gridx = 0;
		gbc_jpAplicacao.gridy = 2;
		getContentPane().add(jpAplicacao, gbc_jpAplicacao);
		jpAplicacao.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		jpAplicacao.add(tabbedPane, BorderLayout.CENTER);

		panel = new JPanel();
		tabbedPane.addTab("Produtos", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 681, 0 };
		gbl_panel.rowHeights = new int[] { 97, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		jpTodosProdutos = new JPanel();
		jpTodosProdutos.setBorder(
				new TitledBorder(null, "Todos os Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jpTodosProdutos = new GridBagConstraints();
		gbc_jpTodosProdutos.insets = new Insets(0, 0, 5, 0);
		gbc_jpTodosProdutos.fill = GridBagConstraints.BOTH;
		gbc_jpTodosProdutos.gridx = 0;
		gbc_jpTodosProdutos.gridy = 0;
		panel.add(jpTodosProdutos, gbc_jpTodosProdutos);
		GridBagLayout gbl_jpTodosProdutos = new GridBagLayout();
		gbl_jpTodosProdutos.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_jpTodosProdutos.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpTodosProdutos.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_jpTodosProdutos.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpTodosProdutos.setLayout(gbl_jpTodosProdutos);

		jpDadosOrigemProduto = new JPanel();
		GridBagConstraints gbc_jpDadosOrigemProduto = new GridBagConstraints();
		gbc_jpDadosOrigemProduto.fill = GridBagConstraints.BOTH;
		gbc_jpDadosOrigemProduto.insets = new Insets(0, 0, 5, 5);
		gbc_jpDadosOrigemProduto.gridx = 0;
		gbc_jpDadosOrigemProduto.gridy = 0;
		jpTodosProdutos.add(jpDadosOrigemProduto, gbc_jpDadosOrigemProduto);
		jpDadosOrigemProduto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Origem",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_jpDadosOrigemProduto = new GridBagLayout();
		gbl_jpDadosOrigemProduto.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpDadosOrigemProduto.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_jpDadosOrigemProduto.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpDadosOrigemProduto.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		jpDadosOrigemProduto.setLayout(gbl_jpDadosOrigemProduto);

		lblTotalLocalizadoNa = new JLabel("Total");
		GridBagConstraints gbc_lblTotalLocalizadoNa = new GridBagConstraints();
		gbc_lblTotalLocalizadoNa.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalLocalizadoNa.anchor = GridBagConstraints.WEST;
		gbc_lblTotalLocalizadoNa.gridx = 0;
		gbc_lblTotalLocalizadoNa.gridy = 0;
		jpDadosOrigemProduto.add(lblTotalLocalizadoNa, gbc_lblTotalLocalizadoNa);

		tfTotalProdOrigem = new JTextField();
		tfTotalProdOrigem.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTotalProdOrigem.setText("0");
		tfTotalProdOrigem.setEditable(false);
		GridBagConstraints gbc_tfTotalProdOrigem = new GridBagConstraints();
		gbc_tfTotalProdOrigem.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotalProdOrigem.insets = new Insets(0, 0, 5, 0);
		gbc_tfTotalProdOrigem.gridx = 1;
		gbc_tfTotalProdOrigem.gridy = 0;
		jpDadosOrigemProduto.add(tfTotalProdOrigem, gbc_tfTotalProdOrigem);
		tfTotalProdOrigem.setColumns(10);

		lblTotalComCdigo = new JLabel("Código de barras válido");
		GridBagConstraints gbc_lblTotalComCdigo = new GridBagConstraints();
		gbc_lblTotalComCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalComCdigo.anchor = GridBagConstraints.WEST;
		gbc_lblTotalComCdigo.gridx = 0;
		gbc_lblTotalComCdigo.gridy = 1;
		jpDadosOrigemProduto.add(lblTotalComCdigo, gbc_lblTotalComCdigo);

		tfCodBarraValido = new JTextField();
		tfCodBarraValido.setHorizontalAlignment(SwingConstants.RIGHT);
		tfCodBarraValido.setText("0");
		tfCodBarraValido.setEditable(false);
		GridBagConstraints gbc_tfCodBarraValido = new GridBagConstraints();
		gbc_tfCodBarraValido.insets = new Insets(0, 0, 5, 0);
		gbc_tfCodBarraValido.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCodBarraValido.gridx = 1;
		gbc_tfCodBarraValido.gridy = 1;
		jpDadosOrigemProduto.add(tfCodBarraValido, gbc_tfCodBarraValido);
		tfCodBarraValido.setColumns(10);

		tfporcentagem = new JTextField();
		tfporcentagem.setText("0");
		tfporcentagem.setHorizontalAlignment(SwingConstants.RIGHT);
		tfporcentagem.setEditable(false);
		GridBagConstraints gbc_tfporcentagem = new GridBagConstraints();
		gbc_tfporcentagem.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfporcentagem.gridx = 1;
		gbc_tfporcentagem.gridy = 2;
		jpDadosOrigemProduto.add(tfporcentagem, gbc_tfporcentagem);
		tfporcentagem.setColumns(10);

		jpCompararProduto = new JPanel();
		GridBagConstraints gbc_jpCompararProduto = new GridBagConstraints();
		gbc_jpCompararProduto.fill = GridBagConstraints.BOTH;
		gbc_jpCompararProduto.insets = new Insets(0, 0, 5, 5);
		gbc_jpCompararProduto.gridx = 1;
		gbc_jpCompararProduto.gridy = 0;
		jpTodosProdutos.add(jpCompararProduto, gbc_jpCompararProduto);
		jpCompararProduto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Comparar Softpharma",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_jpCompararProduto = new GridBagLayout();
		gbl_jpCompararProduto.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpCompararProduto.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_jpCompararProduto.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpCompararProduto.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		jpCompararProduto.setLayout(gbl_jpCompararProduto);

		lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.WEST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 0;
		jpCompararProduto.add(lblTotal, gbc_lblTotal);

		tfTotalComparacao = new JTextField();
		tfTotalComparacao.setText("0");
		tfTotalComparacao.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTotalComparacao.setEditable(false);
		tfTotalComparacao.setColumns(10);
		GridBagConstraints gbc_tfTotalComparacao = new GridBagConstraints();
		gbc_tfTotalComparacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotalComparacao.insets = new Insets(0, 0, 5, 0);
		gbc_tfTotalComparacao.gridx = 1;
		gbc_tfTotalComparacao.gridy = 0;
		jpCompararProduto.add(tfTotalComparacao, gbc_tfTotalComparacao);

		lblCdigoDeBarras = new JLabel("Código de iguais");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.WEST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 1;
		jpCompararProduto.add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);

		tfCodigosIguais = new JTextField();
		tfCodigosIguais.setText("0");
		tfCodigosIguais.setHorizontalAlignment(SwingConstants.RIGHT);
		tfCodigosIguais.setEditable(false);
		tfCodigosIguais.setColumns(10);
		GridBagConstraints gbc_tfCodigosIguais = new GridBagConstraints();
		gbc_tfCodigosIguais.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCodigosIguais.insets = new Insets(0, 0, 5, 0);
		gbc_tfCodigosIguais.gridx = 1;
		gbc_tfCodigosIguais.gridy = 1;
		jpCompararProduto.add(tfCodigosIguais, gbc_tfCodigosIguais);

		tfTotalPercentual = new JTextField();
		tfTotalPercentual.setText("0");
		tfTotalPercentual.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTotalPercentual.setEditable(false);
		tfTotalPercentual.setColumns(10);
		GridBagConstraints gbc_tfTotalPercentual = new GridBagConstraints();
		gbc_tfTotalPercentual.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotalPercentual.gridx = 1;
		gbc_tfTotalPercentual.gridy = 2;
		jpCompararProduto.add(tfTotalPercentual, gbc_tfTotalPercentual);

		jpInserirProduto = new JPanel();
		GridBagConstraints gbc_jpInserirProduto = new GridBagConstraints();
		gbc_jpInserirProduto.insets = new Insets(0, 0, 5, 0);
		gbc_jpInserirProduto.fill = GridBagConstraints.BOTH;
		gbc_jpInserirProduto.gridx = 2;
		gbc_jpInserirProduto.gridy = 0;
		jpTodosProdutos.add(jpInserirProduto, gbc_jpInserirProduto);
		jpInserirProduto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inserir",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_jpInserirProduto = new GridBagLayout();
		gbl_jpInserirProduto.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpInserirProduto.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpInserirProduto.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpInserirProduto.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpInserirProduto.setLayout(gbl_jpInserirProduto);

		lbTotalInseridos = new JLabel("Quantidade para inserir");
		GridBagConstraints gbc_lbTotalInseridos = new GridBagConstraints();
		gbc_lbTotalInseridos.anchor = GridBagConstraints.WEST;
		gbc_lbTotalInseridos.insets = new Insets(0, 0, 5, 5);
		gbc_lbTotalInseridos.gridx = 0;
		gbc_lbTotalInseridos.gridy = 0;
		jpInserirProduto.add(lbTotalInseridos, gbc_lbTotalInseridos);

		tfQuantidadeInserir = new JTextField();
		tfQuantidadeInserir.setText("0");
		tfQuantidadeInserir.setHorizontalAlignment(SwingConstants.RIGHT);
		tfQuantidadeInserir.setEditable(false);
		tfQuantidadeInserir.setColumns(10);
		GridBagConstraints gbc_tfQuantidadeInserir = new GridBagConstraints();
		gbc_tfQuantidadeInserir.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQuantidadeInserir.insets = new Insets(0, 0, 5, 0);
		gbc_tfQuantidadeInserir.gridx = 1;
		gbc_tfQuantidadeInserir.gridy = 0;
		jpInserirProduto.add(tfQuantidadeInserir, gbc_tfQuantidadeInserir);

		tfPorcentagemInserido = new JTextField();
		tfPorcentagemInserido.setText("0");
		tfPorcentagemInserido.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPorcentagemInserido.setEditable(false);
		tfPorcentagemInserido.setColumns(10);
		GridBagConstraints gbc_tfPorcentagemInserido = new GridBagConstraints();
		gbc_tfPorcentagemInserido.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPorcentagemInserido.gridx = 1;
		gbc_tfPorcentagemInserido.gridy = 1;
		jpInserirProduto.add(tfPorcentagemInserido, gbc_tfPorcentagemInserido);
		
		btnUtilizar = new JButton("Utilizar");
		btnUtilizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				new TelaAtualizacao(new ArrayList<ProdutosSoftpharma>(), new LinkedHashSet<Tributacao>(), new ArrayList<TributacaoSoftpharma>());
			}
		});
		GridBagConstraints gbc_btnUtilizar = new GridBagConstraints();
		gbc_btnUtilizar.anchor = GridBagConstraints.EAST;
		gbc_btnUtilizar.gridx = 2;
		gbc_btnUtilizar.gridy = 1;
		jpTodosProdutos.add(btnUtilizar, gbc_btnUtilizar);

		jpEstoqueMaior0 = new JPanel();
		jpEstoqueMaior0.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estoque > 0",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_jpEstoqueMaior0 = new GridBagConstraints();
		gbc_jpEstoqueMaior0.insets = new Insets(0, 0, 5, 0);
		gbc_jpEstoqueMaior0.fill = GridBagConstraints.BOTH;
		gbc_jpEstoqueMaior0.gridx = 0;
		gbc_jpEstoqueMaior0.gridy = 1;
		panel.add(jpEstoqueMaior0, gbc_jpEstoqueMaior0);
		GridBagLayout gbl_jpEstoqueMaior0 = new GridBagLayout();
		gbl_jpEstoqueMaior0.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_jpEstoqueMaior0.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpEstoqueMaior0.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_jpEstoqueMaior0.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpEstoqueMaior0.setLayout(gbl_jpEstoqueMaior0);

		jpOrigemEstoqueMaior0 = new JPanel();
		jpOrigemEstoqueMaior0.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Origem",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_jpOrigemEstoqueMaior0 = new GridBagConstraints();
		gbc_jpOrigemEstoqueMaior0.fill = GridBagConstraints.BOTH;
		gbc_jpOrigemEstoqueMaior0.insets = new Insets(0, 0, 5, 5);
		gbc_jpOrigemEstoqueMaior0.gridx = 0;
		gbc_jpOrigemEstoqueMaior0.gridy = 0;
		jpEstoqueMaior0.add(jpOrigemEstoqueMaior0, gbc_jpOrigemEstoqueMaior0);
		GridBagLayout gbl_jpOrigemEstoqueMaior0 = new GridBagLayout();
		gbl_jpOrigemEstoqueMaior0.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpOrigemEstoqueMaior0.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_jpOrigemEstoqueMaior0.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpOrigemEstoqueMaior0.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		jpOrigemEstoqueMaior0.setLayout(gbl_jpOrigemEstoqueMaior0);

		lbTotalEstoqueMaior0 = new JLabel("Total");
		GridBagConstraints gbc_lbTotalEstoqueMaior0 = new GridBagConstraints();
		gbc_lbTotalEstoqueMaior0.anchor = GridBagConstraints.WEST;
		gbc_lbTotalEstoqueMaior0.insets = new Insets(0, 0, 5, 5);
		gbc_lbTotalEstoqueMaior0.gridx = 0;
		gbc_lbTotalEstoqueMaior0.gridy = 0;
		jpOrigemEstoqueMaior0.add(lbTotalEstoqueMaior0, gbc_lbTotalEstoqueMaior0);

		tfTotalEstoqueMaior0 = new JTextField();
		tfTotalEstoqueMaior0.setText("0");
		tfTotalEstoqueMaior0.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTotalEstoqueMaior0.setEditable(false);
		tfTotalEstoqueMaior0.setColumns(10);
		GridBagConstraints gbc_tfTotalEstoqueMaior0 = new GridBagConstraints();
		gbc_tfTotalEstoqueMaior0.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotalEstoqueMaior0.insets = new Insets(0, 0, 5, 0);
		gbc_tfTotalEstoqueMaior0.gridx = 1;
		gbc_tfTotalEstoqueMaior0.gridy = 0;
		jpOrigemEstoqueMaior0.add(tfTotalEstoqueMaior0, gbc_tfTotalEstoqueMaior0);

		label_1 = new JLabel("Código de barras válido");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		jpOrigemEstoqueMaior0.add(label_1, gbc_label_1);

		tfCodigoValidoEstoqueMaior0 = new JTextField();
		tfCodigoValidoEstoqueMaior0.setText("0");
		tfCodigoValidoEstoqueMaior0.setHorizontalAlignment(SwingConstants.RIGHT);
		tfCodigoValidoEstoqueMaior0.setEditable(false);
		tfCodigoValidoEstoqueMaior0.setColumns(10);
		GridBagConstraints gbc_tfCodigoValidoEstoqueMaior0 = new GridBagConstraints();
		gbc_tfCodigoValidoEstoqueMaior0.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCodigoValidoEstoqueMaior0.insets = new Insets(0, 0, 5, 0);
		gbc_tfCodigoValidoEstoqueMaior0.gridx = 1;
		gbc_tfCodigoValidoEstoqueMaior0.gridy = 1;
		jpOrigemEstoqueMaior0.add(tfCodigoValidoEstoqueMaior0, gbc_tfCodigoValidoEstoqueMaior0);

		tfPorcentagemEstoqueMaior0 = new JTextField();
		tfPorcentagemEstoqueMaior0.setText("0");
		tfPorcentagemEstoqueMaior0.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPorcentagemEstoqueMaior0.setEditable(false);
		tfPorcentagemEstoqueMaior0.setColumns(10);
		GridBagConstraints gbc_tfPorcentagemEstoqueMaior0 = new GridBagConstraints();
		gbc_tfPorcentagemEstoqueMaior0.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPorcentagemEstoqueMaior0.gridx = 1;
		gbc_tfPorcentagemEstoqueMaior0.gridy = 2;
		jpOrigemEstoqueMaior0.add(tfPorcentagemEstoqueMaior0, gbc_tfPorcentagemEstoqueMaior0);

		jpCompararEstoqueMaior0 = new JPanel();
		jpCompararEstoqueMaior0.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Comparar Softpharma", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_jpCompararEstoqueMaior0 = new GridBagConstraints();
		gbc_jpCompararEstoqueMaior0.fill = GridBagConstraints.BOTH;
		gbc_jpCompararEstoqueMaior0.insets = new Insets(0, 0, 5, 5);
		gbc_jpCompararEstoqueMaior0.gridx = 1;
		gbc_jpCompararEstoqueMaior0.gridy = 0;
		jpEstoqueMaior0.add(jpCompararEstoqueMaior0, gbc_jpCompararEstoqueMaior0);
		GridBagLayout gbl_jpCompararEstoqueMaior0 = new GridBagLayout();
		gbl_jpCompararEstoqueMaior0.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpCompararEstoqueMaior0.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_jpCompararEstoqueMaior0.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpCompararEstoqueMaior0.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		jpCompararEstoqueMaior0.setLayout(gbl_jpCompararEstoqueMaior0);

		label_2 = new JLabel("Total");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 0;
		jpCompararEstoqueMaior0.add(label_2, gbc_label_2);

		tfTotalCoparadoEstoqueMaior0 = new JTextField();
		tfTotalCoparadoEstoqueMaior0.setText("0");
		tfTotalCoparadoEstoqueMaior0.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTotalCoparadoEstoqueMaior0.setEditable(false);
		tfTotalCoparadoEstoqueMaior0.setColumns(10);
		GridBagConstraints gbc_tfTotalCoparadoEstoqueMaior0 = new GridBagConstraints();
		gbc_tfTotalCoparadoEstoqueMaior0.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotalCoparadoEstoqueMaior0.insets = new Insets(0, 0, 5, 0);
		gbc_tfTotalCoparadoEstoqueMaior0.gridx = 1;
		gbc_tfTotalCoparadoEstoqueMaior0.gridy = 0;
		jpCompararEstoqueMaior0.add(tfTotalCoparadoEstoqueMaior0, gbc_tfTotalCoparadoEstoqueMaior0);

		label_3 = new JLabel("Código de iguais");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 1;
		jpCompararEstoqueMaior0.add(label_3, gbc_label_3);

		tfCogidoIguaisEstoqueMaior0 = new JTextField();
		tfCogidoIguaisEstoqueMaior0.setText("0");
		tfCogidoIguaisEstoqueMaior0.setHorizontalAlignment(SwingConstants.RIGHT);
		tfCogidoIguaisEstoqueMaior0.setEditable(false);
		tfCogidoIguaisEstoqueMaior0.setColumns(10);
		GridBagConstraints gbc_tfCogidoIguaisEstoqueMaior0 = new GridBagConstraints();
		gbc_tfCogidoIguaisEstoqueMaior0.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCogidoIguaisEstoqueMaior0.insets = new Insets(0, 0, 5, 0);
		gbc_tfCogidoIguaisEstoqueMaior0.gridx = 1;
		gbc_tfCogidoIguaisEstoqueMaior0.gridy = 1;
		jpCompararEstoqueMaior0.add(tfCogidoIguaisEstoqueMaior0, gbc_tfCogidoIguaisEstoqueMaior0);

		tfPorcentagemComparadoEstoqueMaior0 = new JTextField();
		tfPorcentagemComparadoEstoqueMaior0.setText("0");
		tfPorcentagemComparadoEstoqueMaior0.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPorcentagemComparadoEstoqueMaior0.setEditable(false);
		tfPorcentagemComparadoEstoqueMaior0.setColumns(10);
		GridBagConstraints gbc_tfPorcentagemComparadoEstoqueMaior0 = new GridBagConstraints();
		gbc_tfPorcentagemComparadoEstoqueMaior0.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPorcentagemComparadoEstoqueMaior0.gridx = 1;
		gbc_tfPorcentagemComparadoEstoqueMaior0.gridy = 2;
		jpCompararEstoqueMaior0.add(tfPorcentagemComparadoEstoqueMaior0, gbc_tfPorcentagemComparadoEstoqueMaior0);

		jpInserirEstoqueMaior0 = new JPanel();
		jpInserirEstoqueMaior0.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inserir",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_jpInserirEstoqueMaior0 = new GridBagConstraints();
		gbc_jpInserirEstoqueMaior0.insets = new Insets(0, 0, 5, 0);
		gbc_jpInserirEstoqueMaior0.fill = GridBagConstraints.BOTH;
		gbc_jpInserirEstoqueMaior0.gridx = 2;
		gbc_jpInserirEstoqueMaior0.gridy = 0;
		jpEstoqueMaior0.add(jpInserirEstoqueMaior0, gbc_jpInserirEstoqueMaior0);
		GridBagLayout gbl_jpInserirEstoqueMaior0 = new GridBagLayout();
		gbl_jpInserirEstoqueMaior0.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpInserirEstoqueMaior0.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpInserirEstoqueMaior0.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpInserirEstoqueMaior0.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpInserirEstoqueMaior0.setLayout(gbl_jpInserirEstoqueMaior0);

		lblQuantidadeParaInserir = new JLabel("Quantidade para inserir");
		GridBagConstraints gbc_lblQuantidadeParaInserir = new GridBagConstraints();
		gbc_lblQuantidadeParaInserir.anchor = GridBagConstraints.WEST;
		gbc_lblQuantidadeParaInserir.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidadeParaInserir.gridx = 0;
		gbc_lblQuantidadeParaInserir.gridy = 0;
		jpInserirEstoqueMaior0.add(lblQuantidadeParaInserir, gbc_lblQuantidadeParaInserir);

		tfQuantidadeInserirEstorqueMaior0 = new JTextField();
		tfQuantidadeInserirEstorqueMaior0.setText("0");
		tfQuantidadeInserirEstorqueMaior0.setHorizontalAlignment(SwingConstants.RIGHT);
		tfQuantidadeInserirEstorqueMaior0.setEditable(false);
		tfQuantidadeInserirEstorqueMaior0.setColumns(10);
		GridBagConstraints gbc_tfQuantidadeInserirEstorqueMaior0 = new GridBagConstraints();
		gbc_tfQuantidadeInserirEstorqueMaior0.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfQuantidadeInserirEstorqueMaior0.insets = new Insets(0, 0, 5, 0);
		gbc_tfQuantidadeInserirEstorqueMaior0.gridx = 1;
		gbc_tfQuantidadeInserirEstorqueMaior0.gridy = 0;
		jpInserirEstoqueMaior0.add(tfQuantidadeInserirEstorqueMaior0, gbc_tfQuantidadeInserirEstorqueMaior0);

		tfPorcentagemInserirEstoqueMaior0 = new JTextField();
		tfPorcentagemInserirEstoqueMaior0.setText("0");
		tfPorcentagemInserirEstoqueMaior0.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPorcentagemInserirEstoqueMaior0.setEditable(false);
		tfPorcentagemInserirEstoqueMaior0.setColumns(10);
		GridBagConstraints gbc_tfPorcentagemInserirEstoqueMaior0 = new GridBagConstraints();
		gbc_tfPorcentagemInserirEstoqueMaior0.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPorcentagemInserirEstoqueMaior0.gridx = 1;
		gbc_tfPorcentagemInserirEstoqueMaior0.gridy = 1;
		jpInserirEstoqueMaior0.add(tfPorcentagemInserirEstoqueMaior0, gbc_tfPorcentagemInserirEstoqueMaior0);
		
		button = new JButton("Utilizar");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.EAST;
		gbc_button.gridx = 2;
		gbc_button.gridy = 1;
		jpEstoqueMaior0.add(button, gbc_button);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estoque > 0",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Origem",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		label = new JLabel("Total");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_2.add(label, gbc_label);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		
		label_4 = new JLabel("Código de barras válido");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 1;
		panel_2.add(label_4, gbc_label_4);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel_2.add(textField_1, gbc_textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_2.add(textField_2, gbc_textField_2);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Comparar Softpharma", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		label_5 = new JLabel("Total");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 0;
		panel_3.add(label_5, gbc_label_5);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 0;
		panel_3.add(textField_3, gbc_textField_3);
		
		label_6 = new JLabel("Código de iguais");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.WEST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 1;
		panel_3.add(label_6, gbc_label_6);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 1;
		panel_3.add(textField_4, gbc_textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 2;
		panel_3.add(textField_5, gbc_textField_5);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inserir",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 0;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		label_7 = new JLabel("Quantidade para inserir");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.WEST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 0;
		panel_4.add(label_7, gbc_label_7);
		
		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 0;
		panel_4.add(textField_6, gbc_textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("0");
		textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 1;
		panel_4.add(textField_7, gbc_textField_7);
		
		button_1 = new JButton("Utilizar");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.EAST;
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 1;
		panel_1.add(button_1, gbc_button_1);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estoque > 0",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 3;
		panel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Origem",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_5.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		label_8 = new JLabel("Total");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.WEST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 0;
		panel_6.add(label_8, gbc_label_8);
		
		textField_8 = new JTextField();
		textField_8.setText("0");
		textField_8.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 0;
		panel_6.add(textField_8, gbc_textField_8);
		
		label_9 = new JLabel("Código de barras válido");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.WEST;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 1;
		panel_6.add(label_9, gbc_label_9);
		
		textField_9 = new JTextField();
		textField_9.setText("0");
		textField_9.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 1;
		panel_6.add(textField_9, gbc_textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("0");
		textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 2;
		panel_6.add(textField_10, gbc_textField_10);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
								"Comparar Softpharma", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 0;
		panel_5.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		label_10 = new JLabel("Total");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.WEST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 0;
		panel_7.add(label_10, gbc_label_10);
		
		textField_11 = new JTextField();
		textField_11.setText("0");
		textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
		gbc_textField_11.gridx = 1;
		gbc_textField_11.gridy = 0;
		panel_7.add(textField_11, gbc_textField_11);
		
		label_11 = new JLabel("Código de iguais");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.WEST;
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 1;
		panel_7.add(label_11, gbc_label_11);
		
		textField_12 = new JTextField();
		textField_12.setText("0");
		textField_12.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.insets = new Insets(0, 0, 5, 0);
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 1;
		panel_7.add(textField_12, gbc_textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("0");
		textField_13.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_13.gridx = 1;
		gbc_textField_13.gridy = 2;
		panel_7.add(textField_13, gbc_textField_13);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inserir",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 2;
		gbc_panel_8.gridy = 0;
		panel_5.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0};
		gbl_panel_8.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		label_12 = new JLabel("Quantidade para inserir");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.anchor = GridBagConstraints.WEST;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 0;
		panel_8.add(label_12, gbc_label_12);
		
		textField_14 = new JTextField();
		textField_14.setText("0");
		textField_14.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		GridBagConstraints gbc_textField_14 = new GridBagConstraints();
		gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_14.insets = new Insets(0, 0, 5, 0);
		gbc_textField_14.gridx = 1;
		gbc_textField_14.gridy = 0;
		panel_8.add(textField_14, gbc_textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("0");
		textField_15.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		GridBagConstraints gbc_textField_15 = new GridBagConstraints();
		gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_15.gridx = 1;
		gbc_textField_15.gridy = 1;
		panel_8.add(textField_15, gbc_textField_15);
		
		button_2 = new JButton("Utilizar");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.EAST;
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 1;
		panel_5.add(button_2, gbc_button_2);

		setTitle("Conversor Softpharma Protótipo");
		setSize(745, 807);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new TelaInicial();
	}

	/**
	 * Quando é feito a troca no Combobox é alterado o jPainal.
	 */
	private void troca() {
		ItemListener itemListener = new ItemListener() {

			public void itemStateChanged(ItemEvent itemEvent) {

				if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
					String string = itemEvent.getItem().toString();
					if (string.equals("CompuFarma")) {
						jpOrigem.remove(jpConexao);
						jpOrigem.add(jpArquivosdbf, gbc_jpArquivosdbf);
						revalidate();
					} else if (string.equals("FireBird")) {
						jpOrigem.remove(jpArquivosdbf);
						selectedFile = null;
						lbSelecionar.setText(SELECIONAR_O_ARQUIVO_DBF);
						jpOrigem.add(jpConexao, gbc_jpConexao);
						revalidate();
					} else if (string.equals("< Selecione a base dados >")) {
						jpOrigem.remove(jpConexao);
						jpOrigem.remove(jpArquivosdbf);
						selectedFile = null;
						lbSelecionar.setText(SELECIONAR_O_ARQUIVO_DBF);
						revalidate();
					}

				}
			}
		};
		comboBox.addItemListener(itemListener);
	}

	/**
	 * Esse método faz a chama a pesquisa e pega o retorno para setar na tela.
	 */
	private void pesquisa() {

		if (conectadoSoft) {

			modelo.setSenha(tfSenhaSoft.getText());
			modelo.setUsuario(tfUsuarioSoft.getText());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				selectedFile = fileChooser.getSelectedFile();
				lbSelecionar.setText(selectedFile.getPath());
				new Thread() {
					@Override
					public void run() {
						progressBar.setIndeterminate(true);
						
						final List<ProdutosCompufarma> consultasProdutosArquivo = consultas.consultasProdutosCompufarma(selectedFile);
						final List<ProdutosSoftpharma> consultaProdutosAtivosSoft = consultas.consultaProdutosAtivosSoft(modelo);

						ObjetoRetorno consultaComparacao = consultas.comparacao(consultasProdutosArquivo,consultaProdutosAtivosSoft);
						EstoqueMaior0 consultaEstoqueMaior0 = consultas.consultaEstoqueMaior0(consultasProdutosArquivo, consultaProdutosAtivosSoft);

						tfporcentagem.setText(String.valueOf(consultaComparacao.getPercentual()) + " %");
						tfTotalProdOrigem.setText(String.valueOf(consultaComparacao.getQtdItemEstoque()));
						tfCodBarraValido.setText(String.valueOf(consultaComparacao.getQtdCodigoBarrasAtivos()));
						tfCodigosIguais.setText(String.valueOf(consultaComparacao.getProdutosIguais()));
						tfTotalComparacao.setText(String.valueOf(consultaComparacao.getQtdCodigoBarrasAtivos()));
						tfTotalPercentual.setText(String.valueOf(consultaComparacao.getPercentualComparacao() + " %"));
						tfQuantidadeInserir.setText(String.valueOf(consultaComparacao.getQtdInserir()));
						tfPorcentagemInserido.setText(String.valueOf(consultaComparacao.getPercentualInserir() + " %"));

						tfTotalEstoqueMaior0.setText(String.valueOf(consultaEstoqueMaior0.getQtdComEstoque()));
						tfCodigoValidoEstoqueMaior0
								.setText(String.valueOf(consultaEstoqueMaior0.getQtdCodBarraValido()));
						tfPorcentagemEstoqueMaior0
								.setText(String.valueOf(consultaEstoqueMaior0.getPercentOrigem() + " %"));

						tfTotalCoparadoEstoqueMaior0
								.setText(String.valueOf(consultaEstoqueMaior0.getQtdCodBarraValido()));
						tfCogidoIguaisEstoqueMaior0
								.setText(String.valueOf(consultaEstoqueMaior0.getQtdCodBarraIguais()));
						tfPorcentagemComparadoEstoqueMaior0
								.setText(String.valueOf(consultaEstoqueMaior0.getPercentCompara() + " %"));

						tfQuantidadeInserirEstorqueMaior0
								.setText(String.valueOf(consultaEstoqueMaior0.getQtdInserir()));
						tfPorcentagemInserirEstoqueMaior0
								.setText(String.valueOf(consultaEstoqueMaior0.getPercentInserir()));

						progressBar.setIndeterminate(false);
					}
				}.start();
			} else {
				lbSelecionar.setText(SELECIONAR_O_ARQUIVO_DBF);
			}
		} else {
			lbMensagemSoft.setText("Conectar no softpharma primeiro");
		}
	}

	/**
	 * Esse método tem a função de chama a método de teste de conexão para validar.
	 */
	private void conectar() {

		modelo.setSenha(tfSenhaSoft.getText());
		modelo.setUsuario(tfUsuarioSoft.getText());
		modelo.setIp(tfIpServidor.getText());
		modelo.setBanco(tfBanco.getText());

		if (!modelo.getUsuario().isEmpty() && !modelo.getSenha().isEmpty()) {
			if (consultas.testeConexao(modelo)) {
				lbMensagemSoft.setText("Conectado.");
				tfUsuarioSoft.setEnabled(false);
				tfSenhaSoft.setEnabled(false);
				tfIpServidor.setEnabled(false);
				tfBanco.setEnabled(false);
				btnConectar.setEnabled(false);
				conectadoSoft = true;
			} else {
				lbMensagemSoft.setText("Usuário e Senha inválido.");
				tfUsuarioSoft.requestFocus();
			}
		} else {

			lbMensagemSoft.setText("Digitar usuário e senha.");
		}

	}

}
