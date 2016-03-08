/**
 * 
 */
package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.Categoria;
import br.com.webstore.model.Usuario;

/**
 * @author webstore
 *
 */
public interface IUsuarioFacade {

	public Usuario insertUsuario(Usuario usuario);

	public void updateUsuario(Usuario usuario);

	public List<Usuario> findUsuario(Usuario usuario);
	


}
