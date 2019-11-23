package br.com.didata.util;

import javax.persistence.Persistence;

public class GeraTabelas {

	public static void main(String[] args) {

		Persistence.createEntityManagerFactory("DidataPU");

		System.out.println("Tabelas criadas / atualizadas!");

	}

}
