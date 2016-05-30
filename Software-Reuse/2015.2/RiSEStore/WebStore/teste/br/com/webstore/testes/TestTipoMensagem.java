/**
 * 
 */
package br.com.webstore.testes;

import br.com.webstore.model.TipoMensagem;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestTipoMensagem extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.TipoMensagem#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		TipoMensagem tipoMensagem = new TipoMensagem();
		tipoMensagem.setDescricao("TipoDescricaoMensagem");
		assertEquals("TipoDescricaoMensagem", tipoMensagem.getDescricao());
		
	}

}
