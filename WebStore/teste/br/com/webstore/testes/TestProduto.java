/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.Categoria;
import br.com.webstore.model.Produto;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestProduto extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.Produto#setCategoria(br.com.webstore.model.Categoria)}.
	 */
	public void testSetCategoria() {
		Categoria categoria = new Categoria();
		categoria.setDescricao("DescricaoCategoria");
		Produto produto = new Produto();
		produto.setCategoria(categoria);
		assertEquals(categoria, produto.getCategoria());
		
	}

	/**
	 * Test method for {@link br.com.webstore.model.Produto#setUnidadeMedida(br.com.webstore.model.UnidadeMedida)}.
	 */
	public void testSetUnidadeMedida() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Produto#setNumero(java.lang.Integer)}.
	 */
	public void testSetNumero() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Produto#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Produto#setValor(java.math.BigDecimal)}.
	 */
	public void testSetValor() {
		fail("Not yet implemented");
	}

}
