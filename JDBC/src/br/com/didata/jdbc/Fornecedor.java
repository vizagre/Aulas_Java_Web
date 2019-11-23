package br.com.didata.jdbc;

public class Fornecedor {

	private int idEditora;
	private String nomeEditora;
	private String emailEditora;

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public String getEmailEditora() {
		return emailEditora;
	}

	public void setEmailEditora(String emailEditora) {
		this.emailEditora = emailEditora;
	}

	public int getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}

}