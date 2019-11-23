package br.com.didata.testes;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.didata.model.Fornecedor;
import br.com.didata.model.TipoEmpresa;
import br.com.didata.util.JpaUtil;

public class CriaFornecedorComRepositorio {

	public static void main(String[] args) {

		EntityManager manager = JpaUtil.getEntityManager();
		FornecedoresRepositorio fornecedores= new FornecedoresRepositorio(manager);
		
		Fornecedor novoFornecedor = new Fornecedor();
		novoFornecedor.setRazaoSocial("Fornecedor Repository");
		novoFornecedor.setNomeFantasia("F Repository");
		novoFornecedor.setEmail("fornecedorrepository@fornecedor.com.br");
		novoFornecedor.setCnpj("04.586.328/0001-92");
		novoFornecedor.setTipo(TipoEmpresa.MEI);
		novoFornecedor.setDataFundacao(new Date());
		
		manager.getTransaction().begin();
		fornecedores.guardar(novoFornecedor);
		manager.getTransaction().commit();
	
		manager.close();
		JpaUtil.close();
		
	}
}
