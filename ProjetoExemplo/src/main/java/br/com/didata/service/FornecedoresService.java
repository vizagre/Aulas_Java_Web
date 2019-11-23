package br.com.didata.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.didata.model.Fornecedor;
import br.com.didata.repository.FornecedoresRepository;
import br.com.didata.util.Transacional;

public class FornecedoresService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FornecedoresRepository fornecedores;

	@Transacional
	public void salvar(Fornecedor fornecedor) {
		// aqui serão descritas as regras de negócio antes de efetiva		
		fornecedores.guardar(fornecedor);			
	}

	@Transacional
	public void excluir(Fornecedor fornecedor) {
		// aqui serão descritas as regras de negócio antes de efetivar a exclusão		
		fornecedores.remover(fornecedor);
	}
	
	public List<Fornecedor> todosFornecedores() {
		return fornecedores.todos();
	}
}
