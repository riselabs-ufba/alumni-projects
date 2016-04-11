/**
 * 
 */
package br.com.webstore.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

/**
 * @author webstore
 *
 */
public class TestUsuario extends TestCase {

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setNome(java.lang.String)}.
	 */
	public void testSetNome() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setEmail(java.lang.String)}.
	 */
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setSenha(java.lang.String)}.
	 */
	public void testSetSenha() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setDataNascimento(java.util.Date)}.
	 */
	public void testSetDataNascimento() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setTelefone(java.lang.String)}.
	 */
	public void testSetTelefone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setDataInclusao(java.util.Date)}.
	 * @throws ParseException 
	 */
	public void testSetDataInclusao() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("10/04/2016");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setStatusUsuario(br.com.webstore.model.StatusUsuario)}.
	 */
	public void testSetStatusUsuario() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setPerfil(br.com.webstore.model.Perfil)}.
	 */
	public void testSetPerfil() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setDsLogin(java.lang.String)}.
	 */
	public void testSetDsLogin() {
		fail("Not yet implemented");
	}

}
