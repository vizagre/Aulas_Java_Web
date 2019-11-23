package br.com.didata.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.didata.model.Fornecedor;
import br.com.didata.model.TipoEmpresa;
import br.com.didata.util.JpaUtil;

public class AlteraFornecedor {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Fornecedor fornecedor = manager.find(Fornecedor.class, 2L);
		fornecedor.setRazaoSocial("Fornecedor JPA2 alterado");
		fornecedor.setTipo(TipoEmpresa.EPP);

		manager.merge(fornecedor);
		
		trx.commit();
		manager.close();
		JpaUtil.close();
	}
	
}
