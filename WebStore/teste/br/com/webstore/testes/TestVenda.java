/**
 * 
 */
package br.com.webstore.testes;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import br.com.webstore.model.FormaPagamento;
import br.com.webstore.model.StatusVenda;
import br.com.webstore.model.Usuario;
import br.com.webstore.model.UsuarioCupom;
import br.com.webstore.model.Venda;

/**
 * @author webstore
 *
 */
public class TestVenda {

	/**
	 * Test method for {@link br.com.webstore.model.Venda#setStatusVenda(br.com.webstore.model.StatusVenda)}.
	 */
	@Test
	public void testSetStatusVenda() {
		StatusVenda statusVenda = new StatusVenda();
		statusVenda.setDescricao("StatusVenda");
		Venda venda = new Venda();
		venda.setStatusVenda(statusVenda);
		assertEquals(statusVenda, venda.getStatusVenda());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Venda#setUsuarioVenda(br.com.webstore.model.Usuario)}.
	 */
	@Test
	public void testSetUsuarioVenda() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		Venda venda = new Venda();
		venda.setIdUsuarioVenda(usuario);
		assertEquals(usuario, venda.getIdUsuarioVenda());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Venda#setUsuarioCupom(br.com.webstore.model.UsuarioCupom)}.
	 */
	@Test
	public void testSetUsuarioCupom() {
		UsuarioCupom usuarioCupom = new UsuarioCupom();
		usuarioCupom.setId(1);
		Venda venda = new Venda();
		venda.setIdUsuarioCupom(usuarioCupom);
		assertEquals(usuarioCupom, venda.getIdUsuarioCupom());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Venda#setFormaPagamento(br.com.webstore.model.FormaPagamento)}.
	 */
	@Test
	public void testSetFormaPagamento() {
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setId(1);
		Venda venda = new Venda();
		venda.setIdFormaPagamento(formaPagamento);
		assertEquals(formaPagamento, venda.getIdFormaPagamento());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Venda#setDataVenda(java.util.Date)}.
	 * @throws ParseException 
	 */
	@Test
	public void testSetDataVenda() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("10/04/2016");
		Venda venda = new Venda();
		venda.setDataVenda(date);
		assertEquals(date, venda.getDataVenda());
	}

	/**
	 * Test method for {@link br.com.webstore.model.Venda#setValorTotal(java.math.BigDecimal)}.
	 */
	@Test
	public void testSetValorTotal() {
		Venda venda = new Venda();
		BigDecimal valorTotal = new BigDecimal(0.35);;
		venda.setValorTotal(valorTotal);
		assertEquals(valorTotal, venda.getValorTotal());
	}

}
