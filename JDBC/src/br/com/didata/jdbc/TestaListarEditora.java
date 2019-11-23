package br.com.didata.jdbc;
import java.sql.SQLException;
import java.util.List;

public class TestaListarEditora {
	public static void main(String[] args) throws SQLException {
		EditoraDAO dao = new EditoraDAO();

		List<Fornecedor> editoras;

		editoras = dao.listaEditora();

		for (Fornecedor editora : editoras) {
			System.out.println(editora.getNomeEditora() + " | "
					+ editora.getEmailEditora());
		} 

	}
}