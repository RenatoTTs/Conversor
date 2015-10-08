package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lib.ProdutosSoftpharma;
import lib.TributacaoSoftpharma;

/**
 * 
 * @author Renato Barbosa
 *
 */
public class ConectarMysql {
	private static Statement stms;
	private static List<ProdutosSoftpharma> listretorno = null;
	private static List<TributacaoSoftpharma> listTibutacoes = null;

	/**
	 * Esse metodo tem a função de fazer a conexão com o Base Softpharma.
	 * 
	 * @param usuario
	 * @param senha
	 * @return
	 */
	public static Connection conectarBanco(String ip,String banco,String usuario, String senha) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+banco, usuario, senha);
			System.out.println("Conectando ao banco Soft...");
			return con;
		} catch (ClassNotFoundException ex) {
		} catch (SQLException e) {
			return null;
		}
		return null;
	}

	/**
	 * Esse metodo tem a função de pesquisar os produtos ativos.
	 * 
	 * @param sql
	 * @param usuario
	 * @param senha
	 * @return
	 */
	public static List<ProdutosSoftpharma> pesquisaAtivos(String sql, String ip,String banco,String usuario, String senha) {

		try {
			Connection con = conectarBanco(ip,banco,usuario, senha);

			stms = con.createStatement();

			ProdutosSoftpharma retornoAtivos;
			listretorno = new ArrayList<ProdutosSoftpharma>();
			ResultSet executeQuery;

			executeQuery = stms.executeQuery(sql);

			while (executeQuery.next()) {
				retornoAtivos = new ProdutosSoftpharma();

				retornoAtivos.setDescricao(executeQuery.getString("c.cad_descricao"));
				retornoAtivos.setCodigoBarras(executeQuery.getString("c.cad_cod_barra"));
				retornoAtivos.setQtde(executeQuery.getString("cad_qtde_estoque"));

				listretorno.add(retornoAtivos);

			}
			stms.close();
			return listretorno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listretorno;
	}
	public static List<TributacaoSoftpharma> pesquisaTributacoes(String sql, String ip,String banco,String usuario, String senha) {
		try {
			Connection con = conectarBanco(ip,banco,usuario, senha);

			stms = con.createStatement();

			TributacaoSoftpharma retornoTributacao;
			listTibutacoes = new ArrayList<TributacaoSoftpharma>();
			ResultSet executeQuery;

			executeQuery = stms.executeQuery(sql);

			while (executeQuery.next()) {
				retornoTributacao = new TributacaoSoftpharma();

				retornoTributacao.setCodigo(executeQuery.getString("icm_codigo"));
				retornoTributacao.setTributacao(executeQuery.getString("icm_descricao"));

				listTibutacoes.add(retornoTributacao);

			}
			stms.close();
			return listTibutacoes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTibutacoes;
		
	}
}
