package br.com.didata.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditoraDAO {
	private Connection connection;

	public EditoraDAO() throws ClassNotFoundException {
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Editora editora) {
		String sql = " Insert into Editora (nomeEditora, emailEditora) values (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, editora.getNomeEditora());
			stmt.setString(2, editora.getEmailEditora());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Editora editora) {
		String sql = " Update Editora set nomeEditora = ?, emailEditora = ? " + " where idEditora = ? ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, editora.getNomeEditora());
			stmt.setString(2, editora.getEmailEditora());
			stmt.setInt(3, editora.getIdEditora());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Editora editora) {
		String sql = " Delete from Editora where idEditora = ? ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, editora.getIdEditora());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Editora> listaEditora() {
		String sql = " Select * from Editora ";
		try {
			List<Editora> editoras = new ArrayList<Editora>();
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Editora editora = new Editora();
				editora.setIdEditora(rs.getInt("idEditora"));
				editora.setNomeEditora(rs.getString("nomeEditora"));
				editora.setEmailEditora(rs.getString("emailEditora"));

				editoras.add(editora);
			}

			rs.close();
			stmt.close();

			return editoras;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}