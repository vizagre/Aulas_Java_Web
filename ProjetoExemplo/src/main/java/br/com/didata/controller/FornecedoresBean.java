package br.com.didata.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.didata.model.Fornecedor;
import br.com.didata.model.TipoEmpresa;
import br.com.didata.service.FornecedoresService;
import br.com.didata.util.FacesMessages;

@Named
@ViewScoped
public class FornecedoresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//injetar a classe de servicos
	@Inject
	private FornecedoresService cadastroFornecedor;
	
	//injetar a classe utilitaria de mensagens	
	@Inject
	private FacesMessages messages;	

	// variavel do tipo Fornecedor para armazenar um fornecedor quando estiver incluindo ou alterando
	private Fornecedor fornecedorEdicao = new Fornecedor();
	
	// método get para forncedorEdicao	
	public Fornecedor getFornecedorEdicao() {
		return fornecedorEdicao;
	}

	// método set para fornecedorEdicao
	public void setFornecedorEdicao(Fornecedor fornecedorEdicao) {
		this.fornecedorEdicao = fornecedorEdicao;
	}

	// propriedade que armazenará o fornecedor selecionado;
	private Fornecedor fornecedorSelecionado;
	
	// método get para fornecedorSelecionado	
	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	// método set para fornecedorSelecionado	
	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

	// método que será utilizado para instanciar novo fornecedor antes de abrir o diálogo
	public void prepararNovoCadastro() {
		fornecedorEdicao = new Fornecedor();
	}
	
	private List<Fornecedor> todosFornecedores;
	
	public void consultar() {
		todosFornecedores =  cadastroFornecedor.todosFornecedores();
	}

	public List<Fornecedor> getTodosFornecedores() {
		return todosFornecedores;
	}

	//atributo que representará os fornecedores filtrados no datatable
	private List<Fornecedor> fornecedoresFiltrados;
	
	public List<Fornecedor> getFornecedoresFiltrados() {
		return fornecedoresFiltrados;
	}
	
	public void setFornecedoresFiltrados(List<Fornecedor> fornecedoresFiltrados) {
		this.fornecedoresFiltrados = fornecedoresFiltrados;
	}
	
	
	// recupera os tipos existentes na enumeração
	public TipoEmpresa[] getTipos() {
		return TipoEmpresa.values();
	}	
	
	public void salvar() {
		//salva registro utilizando o método salvar da classe de serviços
		cadastroFornecedor.salvar(fornecedorEdicao);
		
		//executa nova consulta após salvar para recarregar a grid
		consultar();
		
		//exibir mensagem após concluir
		messages.info("Fornecedor salvo com sucesso!");
		
		//atualiza programaticamente os componentes da lista
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:fornecedores-table"));
		
		RequestContext.getCurrentInstance().execute("PF('tabelaFornecedores').clearFilters()");
		
	}
	
	public void excluir() {
		// exclui regisgtro utilizando o método excluir da classe de serviços
		
		try {
			cadastroFornecedor.excluir(fornecedorSelecionado);
			fornecedorSelecionado = null;
			
			//executa nova consulta após excluir para recarregar a grid
			consultar();
			
			//exibir mensagem após concluir
			messages.info("Fornecedor excluído com sucesso!");
			RequestContext.getCurrentInstance().execute("PF('tabelaFornecedores').clearFilters()");
			
		} catch (Exception e) {
			messages.error("Fornecedor não pode ser excluído!");
		} 
		
	}
	
}
