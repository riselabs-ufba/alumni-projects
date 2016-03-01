/**
 * 
 */
package br.com.webstore.dao;

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
}
