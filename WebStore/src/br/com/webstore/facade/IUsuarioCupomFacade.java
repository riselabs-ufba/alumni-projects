/**
 * 
 */
package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.UsuarioCupom;

/**
 * @author webstore
 *
 */
public interface IUsuarioCupomFacade {

	/**
	 * @param usuarioCupom
	 * @return
	 */
	public UsuarioCupom insertUsuarioCupom(UsuarioCupom usuarioCupom);

	/**
	 * @param usuarioCupom
	 */
	public void updateUsuarioCupom(UsuarioCupom usuarioCupom);

	/**
	 * @param usuarioCupom
	 * @return
	 */
	public List<UsuarioCupom> findUsuarioCupom(UsuarioCupom usuarioCupom);

}
