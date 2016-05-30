/**
 * 
 */
package br.com.webstore.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.webstore.model.Cupom;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestCupom extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.Cupom#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		Cupom cupom = new Cupom();
		cupom.setDescricao("Cupom JUNIT");
		assertEquals("Cupom JUNIT", cupom.getDescricao());
		
	}

	/**
	 * Test method for {@link br.com.webstore.model.Cupom#setDataValidade(java.util.Date)}.
	 * @throws ParseException 
	 */
	public void testSetDataValidade() throws ParseException {
		Cupom cupom = new Cupom();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("10/04/2016");
		cupom.setDataValidade(date);
		assertEquals(date, cupom.getDataValidade());
	}

}
