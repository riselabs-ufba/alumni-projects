/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.FormaPagamento;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestFormaPagamento extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.FormaPagamento#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setDescricao("FormaPagamento");
		assertEquals("FormaPagamento", formaPagamento.getDescricao());
	}

}
