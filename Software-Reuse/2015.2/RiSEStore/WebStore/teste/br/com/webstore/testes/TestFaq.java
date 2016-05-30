/**
 * 
 */
package br.com.webstore.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.webstore.model.Faq;

/**
 * @author webstore
 *
 */
public class TestFaq {

	/**
	 * Test method for {@link br.com.webstore.model.Faq#setDescricao(java.lang.String)}.
	 */
	@Test
	public void testSetDescricao() {
		Faq faq = new Faq();
		faq.setDescricao("DescricaoFaQ");
		assertEquals("DescricaoFaQ", faq.getDescricao());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Faq#setResposta(java.lang.String)}.
	 */
	@Test
	public void testSetResposta() {
		Faq faq = new Faq();
		faq.setResposta("RespostaFAQ");
		assertEquals("RespostaFAQ", faq.getResposta());
	}

}
