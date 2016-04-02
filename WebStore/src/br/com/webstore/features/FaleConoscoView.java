/**
 * 
 */
package br.com.webstore.features;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.webstore.model.Usuario;

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
	
	public FaleConoscoView(final Usuario usuarioLogado){
		this.setLayout(null);
		/*final JTextField email = new JTextField(40);
		email.setBounds(57, 53, 353, 20);
		email.setColumns(10);*/
		JLabel emailL = new JLabel("Email: "+usuarioLogado.getEmail());
		emailL.setBounds(57, 24, 200, 14);
		add(emailL);
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
				if(message.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
				}
				else{
					Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
					final String userName = "dccreuso@gmail.com";
					final String password = "dccufba123";
					Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					    protected PasswordAuthentication getPasswordAuthentication() {
					        return new PasswordAuthentication(userName, password);
					    }
					});
				    try {
				        MimeMessage msg = new MimeMessage(session);
				        msg.setFrom(new InternetAddress("dccreuso@gmail.com"));
				        msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse("dccreuso@gmail.com"));
				        msg.setSubject("Contato");
				        msg.setSentDate(new Date());
				        msg.setText("De: "+usuarioLogado.getEmail()+"\n"+message.getText());
				        Transport.send(msg);
				        JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso.");
						message.setText("");
				    } catch (MessagingException mex) {
				        System.out.println("send failed, exception: " + mex);
				        JOptionPane.showMessageDialog(null, "Nao foi possivel enviar a mensagem.");
				    }
					
				}
			}
		});
		
		add(btnSendBug);
	}
}
