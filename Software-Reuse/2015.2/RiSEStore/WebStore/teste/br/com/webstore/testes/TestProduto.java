/**
 * 
 */
package br.com.webstore.testes;

import java.math.BigDecimal;

import br.com.webstore.model.Categoria;
import br.com.webstore.model.Produto;
import br.com.webstore.model.UnidadeMedida;
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
		UnidadeMedida unidadeMedida = new UnidadeMedida();
		unidadeMedida.setDescricao("UnidadeMedida");
		Produto produto = new Produto();
		produto.setUnidadeMedida(unidadeMedida);
		assertEquals(unidadeMedida, produto.getUnidadeMedida());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Produto#setNumero(java.lang.Integer)}.
	 */
	public void testSetNumero() {
		Produto produto = new Produto();
		Integer valor = 10;
		produto.setNumero(valor);
		assertEquals(valor, produto.getNumero());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Produto#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		Produto produto = new Produto();
		produto.setDescricao("DescriçãoProduto");
		assertEquals("DescriçãoProduto", produto.getDescricao());
	}
	

	/**
	 * Test method for {@link br.com.webstore.model.Produto#setValor(java.math.BigDecimal)}.
	 */
	public void testSetValor() {
		Produto produto = new Produto();
		BigDecimal valor = new BigDecimal(0.35);;
		produto.setValor(valor);
		assertEquals(valor, produto.getValor());
		
	}

}
