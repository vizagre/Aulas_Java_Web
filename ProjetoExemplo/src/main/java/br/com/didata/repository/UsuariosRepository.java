package br.com.didata.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.didata.model.Usuario;

public class UsuariosRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public boolean validarLogin(String user, String pass) {
		Query query = manager.createQuery(
				"select u from Usuario as u " + " where u.user = :paramUser " + " and u.pass = :paramPass");
		query.setParameter("paramUser", user);
		query.setParameter("paramPass", pass);

		@SuppressWarnings("unchecked")
		List<Usuario> lista = query.getResultList();

		if (lista.size() == 0) {
			return false;
		} else {
			return true;
		}

	}

}
