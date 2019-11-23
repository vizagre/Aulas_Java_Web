package br.com.didata.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.didata.model.Fornecedor;
import br.com.didata.util.JpaUtil;

public class RemoveFornecedor {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Fornecedor fornecedor = manager.find(Fornecedor.class, 2L);

		manager.remove(fornecedor);
		
		trx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
