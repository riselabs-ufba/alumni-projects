//#if ${Usuario} == "T"
/**
 * 
 */
package br.com.webstore.dao;

import java.util.List;

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
	public UsuarioDao() {
		super(Usuario.class);
	}
	
	public List<Usuario> getUsuarioByLoginSenha(String Login, String Senha){
		TypedQuery<Usuario> query = this.entityManager.createQuery("from Usuario u where u.dsLogin = :login and u.senha = :senha", Usuario.class);
		query.setParameter("login", Login);
		query.setParameter("senha", Senha);
		return query.getResultList();
	}
}
//#endif