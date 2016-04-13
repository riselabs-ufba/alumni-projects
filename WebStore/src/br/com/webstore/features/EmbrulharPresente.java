/**
 * 
 */
package br.com.webstore.features;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	Usuario usr;
	
	private boolean validarCampos()
	{
		if ("".equals(paraField.getText()) || "".equals(deField.getText()) || "".equals(paraField.getText()))
		{
			JOptionPane.showMessageDialog(null, "Por favor preencher os campos");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	public void EnviarEmail(Usuario usuario, String mensagem, String de, String para)
	{	
		StringBuilder str = new StringBuilder();
		
		str.append("<!DOCTYPE html><html><head><style>#header ");
		str.append("{    background-color:black;    color:white; ");
		str.append("     text-align:center; ");
		str.append("   	 padding:5px; ");
		str.append("}");
		str.append("#section { ");
		str.append("    width:350px; ");
		str.append("    float:left; ");
		str.append("    padding:10px; "); 	 
		str.append("} ");
		str.append("#footer { ");
		str.append("    background-color:black; ");
		str.append("    color:white; ");
		str.append("    clear:both; ");
		str.append("    text-align:center; ");
		str.append("   padding:5px;	 	 ");
		str.append("} ");
		str.append("</style> ");
		str.append("</head> ");
		str.append("<body> ");
		str.append("<div id=\"header\"> ");
		str.append("<h1>");
		str.append(para);
		str.append("</h1>");
		str.append("</div>");
		str.append("<div id=\"section\">");
		str.append("<p>");
		str.append(mensagem);
		str.append("</p></div>");
		str.append("<div id=\"footer\">");
		str.append("<h2>");
		str.append(de);
		str.append("</h2>");
		str.append("</div></body></html>");

		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		final String userName = "dccreuso@gmail.com";
		final String password = "dccufba123";
		Session session = Session.getInstance(props, new javax.mail.Authenticator()
		{
		    protected PasswordAuthentication getPasswordAuthentication() 
		    {
		        return new PasswordAuthentication(userName, password);
		    }
		});
	    try 
	    {
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress("dccreuso@gmail.com"));
	        msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(usuario.getEmail()));
	        msg.setSubject("Cartão de presente");
	        msg.setSentDate(new Date());
	        msg.setContent(str.toString(), "text/html; charset=utf-8");
	        Transport.send(msg);
	        JOptionPane.showMessageDialog(null, "Cartão para o embrulho de presente criado com sucesso.");
	    } 
	    catch (MessagingException mex) 
	    {
	        System.out.println("send failed, exception: " + mex);
	        JOptionPane.showMessageDialog(null, "Cartão para o embrulho de presente não criado.");
	    }
	}
	
	public EmbrulharPresente(GenericFacade gfacade, Usuario usuario, String string) 
	{
		usr = usuario;
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
		
		JButton btAdicionarMensagem = new JButton("Adicionar Mensagem");
		btAdicionarMensagem.setBounds(110,250,160,23);
		btAdicionarMensagem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (validarCampos())
				{
					EnviarEmail(usr, mensagemField.getText(), deField.getText(), paraField.getText());
				}
			}
		});
		this.add(btAdicionarMensagem);
		
		this.setVisible(true);
	}
}
