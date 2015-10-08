package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * 
 * @author Renato Barbosa
 * 
 */
public class ConectarFireBird {

	public Connection con = null;
	public Statement stm = null;

	public Connection conectarFireBird(String usuario, String senha) {
		try {

			Class.forName("org.firebirdsql.jdbc.FBDriver");
			con = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:D:/BD/TESTE.FDB", usuario, senha);
			return con;

		} catch (Exception e) {
			System.out.println("Não foi possível conectar ao banco: " + e.getMessage());
		}
		return con;

	}

	public String pesquisaAtivos(String sql, String usuario, String senha) {
			String retornoTotalFire = "";
		try {

			Connection con = conectarFireBird(usuario, senha);
			
			stm = con.createStatement();

			ResultSet executeQuery = stm.executeQuery(sql);

			while (executeQuery.next()) {
				retornoTotalFire = executeQuery.getString("teste");
			}
			return retornoTotalFire;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retornoTotalFire;

	}

}
