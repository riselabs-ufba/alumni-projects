//#if ${Usuario} == "T"
/**
 * 
 */
package br.com.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.com.webstore.model.Usuario;

/**
 * @author webstore
 *
 */
public class UsuarioDao extends GenericDao<Usuario, Integer>{

	/**
	 * Construtor
	 */
	public UsuarioDao(EntityManager entityManager) {
		super(entityManager, Usuario.class);
	}
	
	public List<Usuario> getUsuarioByLoginSenha(String Login, String Senha){
		TypedQuery<Usuario> query = this.entityManager.createQuery("from Usuario u where u.dsLogin = :login and u.senha = :senha", Usuario.class);
		query.setParameter("login", Login);
		query.setParameter("senha", Senha);
		return query.getResultList();
	}
	
	public List<Usuario> findByEmail(String email) {
		TypedQuery<Usuario> query = this.entityManager.createQuery("from Usuario u where u.email like :email", Usuario.class);
		query.setParameter("email", email + "%");
		return query.getResultList();
	}
	
	public Usuario findByLogin(String login){
		
		TypedQuery<Usuario> query = this.entityManager.createQuery("from Usuario u where u.dsLogin =:login", Usuario.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}
	
}
//#endif