/**
 * 
 */
package br.com.webstore.features;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author webstore
 *
 */
public class FaleConoscoView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NAME = "Fale conosco";
	
	public FaleConoscoView(){
		this.setLayout(null);
		
		final JTextField email = new JTextField(40);
		email.setBounds(57, 53, 353, 20);
		email.setColumns(10);
		JLabel emailL = new JLabel("Email:");
		emailL.setBounds(57, 24, 124, 14);
		add(emailL);
	    add(email);
	    final JTextArea message = new JTextArea(10,40);
		JLabel msgL = new JLabel("Mensagem:");
		msgL.setBounds(57, 74, 124, 14);
		message.setBounds(57, 103, 353, 40);
		add(msgL);
	    add(message);
		
		JButton btnSendBug = new JButton("Enviar");
		btnSendBug.setBounds(57, 170, 89, 23);
		btnSendBug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(email.getText().length()==0 || message.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
				}
				else{
					JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso.");
					email.setText("");
					message.setText("");
				}
			}
		});
		
		add(btnSendBug);
	}
}
