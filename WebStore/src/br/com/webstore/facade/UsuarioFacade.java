/**
 * 
 */
package br.com.webstore.facade;

/**
 * @author webstore
 *
 */
import java.util.List;



import br.com.webstore.dao.UsuarioDao;
import br.com.webstore.model.Usuario;

public class UsuarioFacade implements IUsuarioFacade{
	
	// @Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public Usuario insertUsuario(Usuario usuario) {
		return usuarioDao.insert(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		usuarioDao.update(usuario);		
	}

	@Override
	public List<Usuario> findUsuario(Usuario usuario) {
		return usuarioDao.getList();
	}

}
