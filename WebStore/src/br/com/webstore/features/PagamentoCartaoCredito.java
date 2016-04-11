/**
 * 
 */
package br.com.webstore.features;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Usuario;

/**
 * @author webstore
 *
 */
public class PagamentoCartaoCredito extends JFrame{

	private static final long serialVersionUID = 4585539280382798864L;
	
	public PagamentoCartaoCredito(GenericFacade gfacade, Usuario usuario, String string) {
		final JDialog frame = new JDialog();
		this.setLayout(null);	
		this.setTitle("Cartão de Crédito");
		this.setSize(400, 300);
		
		JLabel lbNome = new JLabel("Nome: ");		
		lbNome.setBounds(2,10,200,15);
		this.add(lbNome);
		
		JLabel lbNumeroCartao = new JLabel("Numero: ");		
		lbNumeroCartao.setBounds(2,30,200,15);
		this.add(lbNumeroCartao);
		
		JLabel lbCodigoSeguranca = new JLabel("Código de Segurança: ");		
		lbCodigoSeguranca.setBounds(2,50,200,15);
		this.add(lbCodigoSeguranca);
		
		JButton btFinalizarCompra = new JButton("Finalizar Compra");
		btFinalizarCompra.setBounds(110,210,160,23);
		this.add(btFinalizarCompra);
		
		this.setVisible(true);

	}



}
