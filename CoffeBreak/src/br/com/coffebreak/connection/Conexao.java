package br.com.coffebreak.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection conectar() throws ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/coffebreak", "root", "85071262");
			System.out.println("Conectou no banco de dados.");
		} catch (SQLException ex) {
			System.out.println("Erro: Não conseguiu conectar no BD.");
			System.out.println(ex);
		}
		return conn;
	}

	public static void desconectar(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Desconectou do banco de dados.");
			}
		} catch (SQLException ex) {
			System.out.println("Não conseguiu desconectar do BD.");
		}
	}
}