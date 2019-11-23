package br.com.didata.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/livraria_didata", "root", "master123");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
