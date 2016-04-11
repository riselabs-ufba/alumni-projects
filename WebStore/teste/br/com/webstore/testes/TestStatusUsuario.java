/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.StatusUsuario;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestStatusUsuario extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.StatusUsuario#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		StatusUsuario statusUsuario = new StatusUsuario();
		statusUsuario.setDescricao("DescricaoStatusUsuario");
		assertEquals("DescricaoStatusUsuario", statusUsuario.getDescricao());
	}

}
