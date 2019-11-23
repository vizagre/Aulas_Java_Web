package br.com.didata.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InserirEditoraFinal {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		try {
			System.out.println("Abrindo conex�o...");
			Connection conexao = ConnectionFactory.getConnection();

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

			System.out.println("Fechando conex�o... ");
			
			entrada.close();
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}