/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.Perfil;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestPerfil extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.Perfil#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		Perfil perfil = new Perfil();
		perfil.setDescricao("DescricaoPerfil");
		assertEquals("DescricaoPerfil", perfil.getDescricao());
	}

}
