/**
 * 
 */
package br.com.webstore.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.webstore.model.Mensagem;
import br.com.webstore.model.TipoMensagem;
import br.com.webstore.model.Usuario;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestMensagem extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.Mensagem#setUsuarioResposta(br.com.webstore.model.Usuario)}.
	 */
	public void testSetUsuarioResposta() {
		Usuario usuario = new Usuario();
		usuario.setNome("NomeUsuarioResposta");
		Mensagem mensagem = new Mensagem();
		mensagem.setUsuarioResposta(usuario);
		assertEquals(usuario, mensagem.getUsuarioResposta());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Mensagem#setUsuarioRegistro(br.com.webstore.model.Usuario)}.
	 */
	public void testSetUsuarioRegistro() {
		Usuario usuario = new Usuario();
		usuario.setNome("NomeUsuarioRgistro");
		Mensagem mensagem = new Mensagem();
		mensagem.setUsuarioRegistro(usuario);
		assertEquals(usuario, mensagem.getUsuarioRegistro());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Mensagem#setTipoMensagem(br.com.webstore.model.TipoMensagem)}.
	 */
	public void testSetTipoMensagem() {
		TipoMensagem tipoMensagem = new TipoMensagem();
		tipoMensagem.setDescricao("DescricaoTipoMensagem");
		Mensagem mensagem = new Mensagem();
		mensagem.setTipoMensagem(tipoMensagem);
		assertEquals(tipoMensagem, mensagem.getTipoMensagem());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Mensagem#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		Mensagem mensagem = new Mensagem();
		mensagem.setDescricao("DescricaoMensagem");
		assertEquals("DescricaoMensagem", mensagem.getDescricao());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Mensagem#setDataRegistro(java.util.Date)}.
	 * @throws ParseException 
	 */
	public void testSetDataRegistro() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("10/04/2016");
		Mensagem mensagem = new Mensagem();
		mensagem.setDataRegistro(date);
		assertEquals(date, mensagem.getDataRegistro());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Mensagem#setDataResposta(java.util.Date)}.
	 * @throws ParseException 
	 */
	public void testSetDataResposta() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("10/04/2016");
		Mensagem mensagem = new Mensagem();
		mensagem.setDataResposta(date);
		assertEquals(date, mensagem.getDataResposta());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Mensagem#setDescricaoResposta(java.lang.String)}.
	 */
	public void testSetDescricaoResposta() {
		Mensagem mensagem = new Mensagem();
		mensagem.setDescricaoResposta("DescricaoRespostaMensagem");
		assertEquals("DescricaoRespostaMensagem", mensagem.getDescricaoResposta());
	}

}
