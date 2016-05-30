/**
 * 
 */
package br.com.webstore.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.webstore.model.SituacaoBug;

/**
 * @author webstore
 *
 */
public class TestSitucaoBug {

	/**
	 * Test method for {@link br.com.webstore.model.SituacaoBug#setDescricao(java.lang.String)}.
	 */
	@Test
	public void testSetDescricao() {
		SituacaoBug situacaoBug = new SituacaoBug();
		situacaoBug.setDescricao("SitucaoBUG");
		assertEquals("SitucaoBUG", situacaoBug.getDescricao());
	}

}
