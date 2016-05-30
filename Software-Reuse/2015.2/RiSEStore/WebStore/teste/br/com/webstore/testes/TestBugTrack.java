/**
 * 
 */
package br.com.webstore.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.webstore.model.BugTrack;
import br.com.webstore.model.SituacaoBug;
import br.com.webstore.model.Usuario;
import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestBugTrack extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.BugTrack#setUsuarioResponde(br.com.webstore.model.Usuario)}.
	 */
	public void testSetUsuarioResponde() {
		Usuario usuario = new Usuario();
		usuario.setNome("Angela");
		BugTrack bugTrack = new BugTrack();
		bugTrack.setUsuarioResponde(usuario);
		assertEquals(usuario, bugTrack.getUsuarioResponde());
	}

	/**
	 * Test method for {@link br.com.webstore.model.BugTrack#setUsuarioRegistro(br.com.webstore.model.Usuario)}.
	 */
	public void testSetUsuarioRegistro() {
		Usuario usuario = new Usuario();
		usuario.setNome("UsuarioRegistro");
		BugTrack bugTrack = new BugTrack();
		bugTrack.setUsuarioRegistro(usuario);
		assertEquals(usuario, bugTrack.getUsuarioRegistro());
	}

	/**
	 * Test method for {@link br.com.webstore.model.BugTrack#getSituacaoBug()}.
	 */
	public void testGetSituacaoBug() {
		SituacaoBug situacaoBug = new SituacaoBug();
		situacaoBug.setDescricao("SitucaoBug");
		BugTrack bugTrack = new BugTrack();
		bugTrack.setSituacaoBug(situacaoBug);
		assertEquals(situacaoBug, bugTrack.getSituacaoBug());
	}

	/**
	 * Test method for {@link br.com.webstore.model.BugTrack#setDescricao(java.lang.String)}.
	 */
	public void testSetDescricao() {
		BugTrack bugTrack = new BugTrack();
		bugTrack.setDescricao("DescricaoBugTrack");
		assertEquals("DescricaoBugTrack", bugTrack.getDescricao());
	}

	/**
	 * Test method for {@link br.com.webstore.model.BugTrack#setDataRegistro(java.util.Date)}.
	 * @throws ParseException 
	 */
	public void testSetDataRegistro() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("10/04/2016");
		BugTrack bugTrack = new BugTrack();
		bugTrack.setDataRegistro(date);
		assertEquals(date, bugTrack.getDataRegistro());
	}

	/**
	 * Test method for {@link br.com.webstore.model.BugTrack#setDataResposta(java.util.Date)}.
	 * @throws ParseException 
	 */
	public void testSetDataResposta() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("10/04/2016");
		BugTrack bugTrack = new BugTrack();
		bugTrack.setDataResposta(date);
		assertEquals(date, bugTrack.getDataResposta());
	}

	/**
	 * Test method for {@link br.com.webstore.model.BugTrack#getDescricaoResposta()}.
	 */
	public void testSetDescricaoResposta() {
		BugTrack bugTrack = new BugTrack();
		bugTrack.setDescricaoResposta("DescricaoRespostaBugTrack");
		assertEquals("DescricaoRespostaBugTrack", bugTrack.getDescricaoResposta());
	}

	/**
	 * Test method for {@link br.com.webstore.model.BugTrack#setTitulo(java.lang.String)}.
	 */
	public void testSetTitulo() {
		BugTrack bugTrack = new BugTrack();
		bugTrack.setTitulo("TituloBugTrack");
		assertEquals("TituloBugTrack", bugTrack.getTitulo());
	}

}
