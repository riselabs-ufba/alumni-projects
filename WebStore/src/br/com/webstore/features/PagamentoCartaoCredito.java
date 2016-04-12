//#if ${CarrinhoCompras} == "T"
//#if ${CarrinhoFinalizarCompras} == "T"
package br.com.webstore.features;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Usuario;

/**
 * @author webstore
 *
 */
public class PagamentoCartaoCredito extends JFrame
{
	private static final long serialVersionUID = 4585539280382798864L;
	
	private JTextField nomeField;
	private JFormattedTextField numeroCartaoField;
	private JFormattedTextField dataVencCartaoField;
	private JFormattedTextField codigoSegurancaField;
	
	
	public PagamentoCartaoCredito(GenericFacade gfacade, Usuario usuario, String string) 
	{
		final JDialog frame = new JDialog();
		this.setLayout(null);	
		this.setTitle("Cartao de Credito");
		this.setSize(400, 300);
		PagamentoCartaoCredito.this.setLocationRelativeTo(null);
		
		JLabel lbNome = new JLabel("Nome: ");		
		lbNome.setBounds(2,10,200,15);
		this.add(lbNome);
		
		this.nomeField = new JTextField();
		this.nomeField.setBounds(2, 25, 219, 25);
		this.nomeField.setToolTipText("Informe o nome como consta no cartão.");
		this.nomeField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.nomeField.setColumns(10);
		this.add(this.nomeField);
		
		JLabel lbNumeroCartao = new JLabel("Numero: ");		
		lbNumeroCartao.setBounds(2,55,200,15);
		this.add(lbNumeroCartao);
		
		try
		{
		    javax.swing.text.MaskFormatter numeroCartaoCredito = new MaskFormatter("####.####.####.####");
		    this.numeroCartaoField = new JFormattedTextField(numeroCartaoCredito);
		}
		catch(Exception e)
		{
		};
		
		this.numeroCartaoField.setBounds(2, 70, 219, 25);
		this.numeroCartaoField.setToolTipText("Informe o numero do cartao.");
		this.numeroCartaoField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.numeroCartaoField.setColumns(10);
		this.add(this.numeroCartaoField);
		
		JLabel lbDataVencimento = new JLabel("Data de Vencimento: ");		
		lbDataVencimento.setBounds(2,100,200,15);
		this.add(lbDataVencimento);
		
		try
		{
		    javax.swing.text.MaskFormatter dataVencimento = new MaskFormatter(" ##/##");
		    this.dataVencCartaoField = new JFormattedTextField(dataVencimento);
		}
		catch(Exception e)
		{
		};
		
		this.dataVencCartaoField.setBounds(2, 115, 219, 25);
		this.dataVencCartaoField.setToolTipText("Informe o numero do cartao.");
		this.dataVencCartaoField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.dataVencCartaoField.setColumns(10);
		this.add(this.dataVencCartaoField);
		
		
		JLabel lbCodigoSeguranca = new JLabel("Codigo de Seguranca: ");		
		lbCodigoSeguranca.setBounds(2,145,200,15);
		this.add(lbCodigoSeguranca);
		
		try
		{
		    javax.swing.text.MaskFormatter codigoSeguranca = new MaskFormatter("###");
		    this.codigoSegurancaField = new JFormattedTextField(codigoSeguranca);
		}
		catch(Exception e)
		{
		};
		
		this.codigoSegurancaField.setBounds(2, 160, 75, 25);
		this.codigoSegurancaField.setToolTipText("Informe o numero do cartao.");
		this.codigoSegurancaField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.codigoSegurancaField.setColumns(10);
		this.add(this.codigoSegurancaField);
		
		JButton btFinalizarCompra = new JButton("Finalizar Compra");
		btFinalizarCompra.setBounds(110,210,160,23);
		this.add(btFinalizarCompra);
		
		this.setVisible(true);
	}
}
//#endif
//#endif