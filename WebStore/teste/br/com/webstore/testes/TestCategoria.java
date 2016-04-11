/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.Categoria;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestCategoria extends TestCase {
	
	/**
	 * Test method for {@link br.com.webstore.model.Categoria#setId(java.lang.Integer)}.
	 */
	public void testSetId() {
		//CAMPO AUTO INCREMENTADO NÃO PRECISA GERAR TESTES
	}

	/**
	 * Test method for {@link br.com.webstore.model.Categoria#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		Categoria categoria = new Categoria();
		categoria.setDescricao("Categoria JUNIT");
		assertEquals("Categoria JUNIT", categoria.getDescricao());
	}

}
