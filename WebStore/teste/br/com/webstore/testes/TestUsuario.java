/**
 *      
 */
package br.com.webstore.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.webstore.model.Perfil;
import br.com.webstore.model.StatusUsuario;
import br.com.webstore.model.Usuario;
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
		Usuario usuario = new Usuario();
		usuario.setNome("NomeUsuario");
		assertEquals("NomeUsuario", usuario.getNome());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setEmail(java.lang.String)}.
	 */
	public void testSetEmail() {
		Usuario usuario = new Usuario();
		usuario.setEmail("email@email.com.br");
		assertEquals("email@email.com.br", usuario.getEmail());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setSenha(java.lang.String)}.
	 */
	public void testSetSenha() {
		Usuario usuario = new Usuario();
		usuario.setSenha("SenhaUsuario");
		assertEquals("SenhaUsuario", usuario.getSenha());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setDataNascimento(java.util.Date)}.
	 * @throws ParseException 
	 */
	public void testSetDataNascimento() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("14/08/1987");
		Usuario usuario = new Usuario();
		usuario.setDataNascimento(date);
		assertEquals(date, usuario.getDataNascimento());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setTelefone(java.lang.String)}.
	 */
	public void testSetTelefone() {
		Usuario usuario = new Usuario();
		usuario.setTelefone("99162-0939");
		assertEquals("99162-0939", usuario.getTelefone());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setDataInclusao(java.util.Date)}.
	 * @throws ParseException 
	 */
	public void testSetDataInclusao() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("10/04/2016");
		Usuario usuario = new Usuario();
		usuario.setDataInclusao(date);
		assertEquals(date, usuario.getDataInclusao());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setStatusUsuario(br.com.webstore.model.StatusUsuario)}.
	 */
	public void testSetStatusUsuario() {
		StatusUsuario statusUsuario = new StatusUsuario();
		statusUsuario.setDescricao("DescriçãoStatusUsuario");
		Usuario usuario = new Usuario();
		usuario.setStatusUsuario(statusUsuario);
		assertEquals(statusUsuario, usuario.getStatusUsuario());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setPerfil(br.com.webstore.model.Perfil)}.
	 */
	public void testSetPerfil() {
		Perfil perfil = new Perfil();
		perfil.setDescricao("DecsriçãoPerfil");
		Usuario usuario = new Usuario();
		usuario.setPerfil(perfil);
		assertEquals(perfil, usuario.getPerfil());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Usuario#setDsLogin(java.lang.String)}.
	 */
	public void testSetDsLogin() {
		Usuario usuario = new Usuario();
		usuario.setDsLogin("angelaps");
		assertEquals("angelaps", usuario.getDsLogin());
	}

}
