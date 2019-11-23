package br.com.didata.jdbc;
import java.sql.SQLException;


public class TestaAlterarEditora {
	public static void main(String[] args) throws SQLException {
		Fornecedor editora = new Fornecedor();

		editora.setNomeEditora("Editora Alterada");
		editora.setEmailEditora("alterada@editora.com.br");
		editora.setIdEditora(3);

		EditoraDAO dao = new EditoraDAO();

		dao.altera(editora);
		System.out.println("Editora alterada!"); 

	}
}