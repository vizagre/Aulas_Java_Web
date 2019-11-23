package br.com.didata.testes;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.didata.model.Fornecedor;
import br.com.didata.model.TipoEmpresa;
import br.com.didata.util.JpaUtil;

public class CriaFornecedor {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Fornecedor f1 = new Fornecedor();
		f1.setRazaoSocial("Fornecedor JPA8");
		f1.setNomeFantasia("F JPA8");
		f1.setEmail("fornecedorjpa8@fornecedor.com.br");
		f1.setCnpj("21.633.322/0001-48");
		f1.setTipo(TipoEmpresa.MEI);
		f1.setDataFundacao(new Date());		
		
		Fornecedor f2 = new Fornecedor();
		f2.setRazaoSocial("Fornecedor JPA9");
		f2.setNomeFantasia("F JPA9");
		f2.setEmail("fornecedorjpa9@fornecedor.com.br");
		f2.setCnpj("17.261.692/0001-24");	
		f2.setTipo(TipoEmpresa.EIRELI);
		f2.setDataFundacao(new Date());	
		
		manager.persist(f1);
		manager.persist(f2);
		
		trx.commit();
		manager.close();
		JpaUtil.close();
		
	}

}
