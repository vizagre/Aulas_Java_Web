package br.com.didata.jdbc;
import java.sql.SQLException;

public class TestaInserirEditora {
	public static void main(String[] args) throws SQLException {
		Fornecedor editora = new Fornecedor();

		editora.setNomeEditora("Editora Teste XXX");
		editora.setEmailEditora("teste@editoraxxx.com.br");

		EditoraDAO dao = new EditoraDAO();

		dao.adiciona(editora);
		System.out.println("Editora adicionada!"); 

	}
}