/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.UnidadeMedida;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestUnidadeMedida extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.UnidadeMedida#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		UnidadeMedida unidadeMedida = new UnidadeMedida();
		unidadeMedida.setDescricao("DescriçãoUnidademedida");
		assertEquals("DescriçãoUnidademedida", unidadeMedida.getDescricao());
	}

}
