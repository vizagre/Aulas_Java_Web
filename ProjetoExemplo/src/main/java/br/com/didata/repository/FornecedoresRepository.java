package br.com.didata.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.didata.model.Fornecedor;

public class FornecedoresRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Fornecedor porId(Long id) {
		return manager.find(Fornecedor.class, id);
	}

	public List<Fornecedor> todos() {
		return manager.createQuery("from Fornecedor", Fornecedor.class).getResultList();
	}

	public Fornecedor guardar(Fornecedor fornecedor) {
		return manager.merge(fornecedor);
	}

	public void remover(Fornecedor fornecedor) {
		fornecedor = porId(fornecedor.getId());
		manager.remove(fornecedor);
	}
	

}
