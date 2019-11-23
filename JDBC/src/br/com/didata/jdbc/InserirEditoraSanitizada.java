package br.com.didata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InserirEditoraSanitizada {

	public static void main(String[] args) {
	
		String stringConexao = "jdbc:mysql://localhost:3306/Livraria_Didata";
		String usuario = "root";
		String senha = "master";
		
		Scanner entrada = new Scanner(System.in);

		try {
			System.out.println("Abrindo conexão...");
			
			Connection conexao = DriverManager.getConnection(stringConexao, usuario, senha);

			System.out.println("Digite o nome da editora: ");
			String nomeEditora = entrada.nextLine();

			System.out.println("Digite o email da editora: ");
			String emailEditora = entrada.nextLine();
			
			String sql = "INSERT INTO Editora (nomeEditora , emailEditora) VALUES (?, ?)";

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, nomeEditora);
			stmt.setString(2, emailEditora);

			System.out.println("Executando comando... ");
			stmt.execute();

			System.out.println("Fechando conexão... ");
			
			entrada.close();
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}