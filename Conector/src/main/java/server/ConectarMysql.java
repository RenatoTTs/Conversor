package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lib.ProdutosSoftpharma;

/**
 * 
 * @author Renato Barbosa
 *
 */
public class ConectarMysql {
	private static Statement stms;
	private static List<ProdutosSoftpharma> listretorno = null;

	/**
	 * Esse metodo tem a função de fazer a conexão com o Base Softpharma.
	 * 
	 * @param usuario
	 * @param senha
	 * @return
	 */
	public static Connection conectarBanco(String usuario, String senha) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/softpharma", usuario, senha);
			System.out.println("Conectando ao banco Soft...");
			return con;
		} catch (ClassNotFoundException ex) {
			// Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE,
			// null, ex);
		} catch (SQLException e) {
//			throw new RuntimeException(e + "- " + "Usuario ou a senha está errado.");
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
	public static List<ProdutosSoftpharma> pesquisaAtivos(String sql, String usuario, String senha) {

		try {
			Connection con = conectarBanco(usuario, senha);

			stms = con.createStatement();

			ProdutosSoftpharma retornoTeste;
			listretorno = new ArrayList<ProdutosSoftpharma>();
			ResultSet executeQuery;

			executeQuery = stms.executeQuery(sql);

			while (executeQuery.next()) {
				retornoTeste = new ProdutosSoftpharma();

				retornoTeste.setDescricao(executeQuery.getString("c.cad_descricao"));
				retornoTeste.setCodigoBarras(executeQuery.getString("c.cad_cod_barra"));
				retornoTeste.setQtde(executeQuery.getString("cad_qtde_estoque"));

				listretorno.add(retornoTeste);

			}
			stms.close();
			return listretorno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listretorno;
	}
}
