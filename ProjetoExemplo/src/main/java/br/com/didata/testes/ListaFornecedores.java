package br.com.didata.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.didata.model.Fornecedor;
import br.com.didata.util.JpaUtil;

public class ListaFornecedores {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Query query = manager.createQuery(" SELECT f FROM Fornecedor f");
		@SuppressWarnings("unchecked")
		List<Fornecedor> fornecedores = query.getResultList();

		for (Fornecedor f : fornecedores) {
			System.out.println(f.getId() + " - " + f.getRazaoSocial());
		}

		trx.commit();
		manager.close();
		JpaUtil.close();
	}

}
