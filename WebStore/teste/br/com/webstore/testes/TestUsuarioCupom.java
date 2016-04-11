/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.Usuario;
import br.com.webstore.model.UsuarioCupom;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestUsuarioCupom extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.UsuarioCupom#setDisponivel(java.lang.Boolean)}.
	 */
	public void testSetDisponivel() {
		UsuarioCupom usuarioCupom = new UsuarioCupom();
		Boolean disponivel = true;
		usuarioCupom.getId();
		usuarioCupom.setDisponivel(disponivel);
		assertEquals(disponivel, usuarioCupom.getDisponivel());
		
		
	}

}
