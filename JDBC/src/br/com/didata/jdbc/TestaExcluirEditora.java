package br.com.didata.jdbc;
import java.sql.SQLException;

public class TestaExcluirEditora {
	public static void main(String[] args) throws SQLException {
		Fornecedor editora = new Fornecedor();

		editora.setIdEditora(3);

		EditoraDAO dao = new EditoraDAO();

		dao.remove(editora);
		System.out.println("Editora removida!"); 

	}
}