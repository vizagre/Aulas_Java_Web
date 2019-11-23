package br.com.didata.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.didata.repository.UsuariosRepository;
import br.com.didata.util.FacesMessages;

@Named(value="loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String user;
	private String pass;
	
	// injetar a classe de repositorio
	@Inject
	private UsuariosRepository usuarios;

	// injetar a classe utilitaria de mensagens
	@Inject
	private FacesMessages messages;
	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// validar se pode acessar
	public String podeLogar() {
		boolean valid = usuarios.validarLogin(user, pass);
		if (valid) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", user);
			return "/sistema/principal.xhtml?faces-redirect=true";
			
		} else {
			messages.error("Usuário ou Senha incorretos, tente novamente!");			
			return null;
		}
	}

	// logout event, invalidate session
	public String logout() {	
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();		 
		return "/login.xhtml?faces-redirect=true";
		
	}

}
