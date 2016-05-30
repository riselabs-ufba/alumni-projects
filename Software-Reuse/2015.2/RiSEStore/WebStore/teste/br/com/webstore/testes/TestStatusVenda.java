/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.StatusVenda;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestStatusVenda extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.StatusVenda#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		StatusVenda statusVenda = new StatusVenda();
		statusVenda.setDescricao("DescricaoStatusVenda");
		assertEquals("DescricaoStatusVenda", statusVenda.getDescricao());
	}

}
