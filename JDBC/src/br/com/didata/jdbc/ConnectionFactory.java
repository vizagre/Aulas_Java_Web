package br.com.didata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {

			return DriverManager.getConnection("jdbc:mysql://localhost/Livraria_Didata", "root", "master");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
