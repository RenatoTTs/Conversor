package Importacao.softpharma;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class TelaImportacao extends JFrame {

	private static final long serialVersionUID = 1L;

	String cliente = "";
	String valorFatura = "";

	private JTextArea taImportar;
	private JButton btnImportar;
	private ObjetoExportacao infoCliente;
	private JScrollPane scrollPane;

	public TelaImportacao() {
		Inicializacao();
	}

	/**
	 * Esse método tem como função a inicialização da tela, e chamadas dos
	 * métodos necessário.
	 */
	private void Inicializacao() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JPanel jpBotoes = new JPanel();
		jpBotoes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jpBotoes = new GridBagConstraints();
		gbc_jpBotoes.insets = new Insets(5, 5, 5, 5);
		gbc_jpBotoes.anchor = GridBagConstraints.EAST;
		gbc_jpBotoes.gridx = 0;
		gbc_jpBotoes.gridy = 1;
		getContentPane().add(jpBotoes, gbc_jpBotoes);
		GridBagLayout gbl_jpBotoes = new GridBagLayout();
		gbl_jpBotoes.columnWidths = new int[] { 0, 0 };
		gbl_jpBotoes.rowHeights = new int[] { 0, 0 };
		gbl_jpBotoes.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_jpBotoes.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		jpBotoes.setLayout(gbl_jpBotoes);

		btnImportar = new JButton("Exportar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = taImportar.getText();
				if (text != null && !text.isEmpty()) {
					List<ObjetoExportacao> leitura = leitura(taImportar.getText());
					gravar(leitura);
				} else {
					JOptionPane.showMessageDialog(null, "Necessário informar algo para converter", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnImportar = new GridBagConstraints();
		gbc_btnImportar.gridx = 0;
		gbc_btnImportar.gridy = 0;
		jpBotoes.add(btnImportar, gbc_btnImportar);

		JPanel jpTextArea = new JPanel();
		jpTextArea.setBorder(new TitledBorder(null, "Converter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jpTextArea = new GridBagConstraints();
		gbc_jpTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_jpTextArea.fill = GridBagConstraints.BOTH;
		gbc_jpTextArea.gridx = 0;
		gbc_jpTextArea.gridy = 0;
		getContentPane().add(jpTextArea, gbc_jpTextArea);
		jpTextArea.setLayout(new BorderLayout(0, 0));

		taImportar = new JTextArea();
		taImportar.setText("");
		scrollPane = new JScrollPane(taImportar);
		jpTextArea.add(scrollPane, BorderLayout.CENTER);

		setTitle("Conversor");
		setSize(600, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	/**
	 * Este método tem com função fazer a leitura do texto colado no textArea,
	 * de que esteja no padrão predefinido anteriomente.
	 * 
	 * @param texto.
	 * @return lista Objetos para exportação.
	 */
	private List<ObjetoExportacao> leitura(String texto) {

		String[] textoSeparadoEmLinhas = texto.split("\\R");
		cliente = textoSeparadoEmLinhas[20];
		valorFatura = textoSeparadoEmLinhas[29];
		List<ObjetoExportacao> listaInfo = new ArrayList<ObjetoExportacao>();

		for (int j = 38; j < textoSeparadoEmLinhas.length; j++) {
			String[] linhaSeparadaPorEspaco = textoSeparadoEmLinhas[j].split(" ");
			char[] primeiraPosicao = linhaSeparadaPorEspaco[0].toCharArray();
			Character primeiraLetraDaPosicao = primeiraPosicao[0];

			if (primeiraLetraDaPosicao.isDigit(primeiraLetraDaPosicao)) {
				if (linhaSeparadaPorEspaco[0].length() >= 6 && linhaSeparadaPorEspaco[0].length() <= 9) {

					infoCliente = new ObjetoExportacao();

					String textoLinha = textoSeparadoEmLinhas[j];

					String[] linhaDoTexto = textoLinha.split(" ");

					for (String parteDaLinha : linhaDoTexto) {
						char[] parteDaParteDaLinha = parteDaLinha.toCharArray();
						Character primeiraLetradaParte = parteDaParteDaLinha[0];

						if (primeiraLetradaParte.isAlphabetic(primeiraLetradaParte)) {
							if (infoCliente.getNome() == null || infoCliente.getNome().isEmpty()) {
								infoCliente.setNome(parteDaLinha);
							} else {
								infoCliente.setNome(infoCliente.getNome() + " " + parteDaLinha);
							}
						}
					}

					int length = linhaDoTexto.length;
					int getMatricula = (length - 3);

					String string = linhaDoTexto[getMatricula];

					if (string.length() <= 8 && string.length() >= 6) {

						infoCliente.setMatricula(linhaDoTexto[getMatricula]);
						listaInfo.add(infoCliente);

					} else {
						getMatricula = length - 4;
						infoCliente.setMatricula(linhaDoTexto[getMatricula]);
						listaInfo.add(infoCliente);
					}
				}
			}
			String str = textoSeparadoEmLinhas[j];
			String[] spl = str.split(" ");
			String string2 = spl[0];

			if (primeiraLetraDaPosicao.isDigit(primeiraLetraDaPosicao)) {
				if (string2.length() > 0 && string2.length() < 5) {

					String replace = spl[7].replace(".", "").replace(",", ".");

					String stringTitulos = spl[2] + ";" + spl[3] + ";" + replace;
					infoCliente.getTitulos().add(stringTitulos);
				}
			}
		}
		return listaInfo;
	}

	/**
	 * Tem como objetivo gravar em um documento txt na seguinte ordem:
	 * diaMesAnoHora-arquivo.txt.
	 * 
	 * @param leitura.
	 *            Retorono do metodo Leitura
	 */

	private void gravar(List<ObjetoExportacao> leitura) {
		try {
			Date dataSemFormatacao = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmm");
			String dataFormatada = sdf.format(dataSemFormatacao);

			FileWriter arquivoExportacao = new FileWriter(dataFormatada + "-arquivo.txt");
			arquivoExportacao.write(cliente + "\n");
			String arquivoJustadoCasaDecimal = valorFatura.replace(".", "").replace(",", ".");

			arquivoExportacao.write(arquivoJustadoCasaDecimal + "\n");
			for (ObjetoExportacao objetoImportacao : leitura) {
				String matricula = objetoImportacao.getMatricula();
				String nome = objetoImportacao.getNome();
				List<String> titulos = objetoImportacao.getTitulos();
				for (String string : titulos) {
					arquivoExportacao.write(matricula + ";" + nome + ";" + string + "\n");
				}

			}

			arquivoExportacao.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Concluido com sucesso !", "Alerta", JOptionPane.WARNING_MESSAGE);

	}

	public static void main(String[] args) {
		new TelaImportacao();
	}

}
