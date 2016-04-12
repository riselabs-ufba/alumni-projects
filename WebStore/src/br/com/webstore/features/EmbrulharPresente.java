/**
 * 
 */
package br.com.webstore.features;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Usuario;

/**
 * @author webstore
 *
 */
public class EmbrulharPresente extends JFrame 
{
	private static final long serialVersionUID = 4585539280382798864L;
	
	private JTextField paraField;
	private JTextField deField;
	private JTextArea mensagemField;
	
	
	public EmbrulharPresente(GenericFacade gfacade, Usuario usuario, String string) 
	{
		final JDialog frame = new JDialog();
		this.setLayout(null);	
		this.setTitle("Embrulhar de presente");
		this.setSize(400, 300);
		EmbrulharPresente.this.setLocationRelativeTo(null);
		
		JLabel lblPara = new JLabel("Para: ");		
		lblPara.setBounds(2,10,200,15);
		this.add(lblPara);
		
		this.paraField = new JTextField();
		this.paraField.setBounds(2, 25, 219, 25);
		this.paraField.setToolTipText("Informe o remetente do presente.");
		this.paraField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.paraField.setColumns(10);
		this.add(this.paraField);
		
		JLabel lblDe = new JLabel("Para: ");		
		lblDe.setBounds(2,55,200,15);
		this.add(lblDe);
		
		this.deField = new JTextField();
		this.deField.setBounds(2,70, 219, 25);
		this.deField.setToolTipText("Informe o destinatario do presente.");
		this.deField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.deField.setColumns(10);
		this.add(this.deField);
		
		JLabel lblMensagem = new JLabel("De: ");		
		lblMensagem.setBounds(2,105,200,15);
		this.add(lblMensagem);
		
		this.mensagemField = new JTextArea(5,10);
		this.mensagemField.setBounds(2, 120, 219, 25);
		this.mensagemField.setToolTipText("Informe a mensagem para o embrulho do presente.");
		this.mensagemField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.mensagemField.setColumns(10);
		this.add(this.mensagemField);
		
		JButton btFinalizarCompra = new JButton("Finalizar Compra");
		btFinalizarCompra.setBounds(110,250,160,23);
		this.add(btFinalizarCompra);
		
		this.setVisible(true);
	}
}
