/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.Endereco;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestEndereco extends TestCase {


	/**
	 * Test method for {@link br.com.webstore.model.Endereco#setNumero(java.lang.String)}.
	 */
	public void testSetNumero() {
		Endereco endereco = new Endereco();
		endereco.setNumero("10");
		assertEquals("10", endereco.getNumero());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Endereco#setBairro(java.lang.String)}.
	 */
	public void testSetBairro() {
		Endereco endereco = new Endereco();
		endereco.setBairro("EndereçoBairro");
		assertEquals("EndereçoBairro", endereco.getBairro());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Endereco#setCep(java.lang.String)}.
	 */
	public void testSetCep() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Endereco#setCidade(java.lang.String)}.
	 */
	public void testSetCidade() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Endereco#setUf(java.lang.String)}.
	 */
	public void testSetUf() {
		fail("Not yet implemented");
	}

}
