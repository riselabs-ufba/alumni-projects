/**
 * 
 */
package br.com.webstore.features;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Perfil;
import br.com.webstore.model.StatusUsuario;
import br.com.webstore.model.Usuario;



/**
 * @author webstore
 *
 */
public class UsuarioComumEdicao extends JPanel 
{
	
	public Usuario toModel() 
	{
		Usuario usuario = new Usuario();
		
		if (this.editMode) 
		{
			usuario.setId(this.Id);
		}
		
		usuario.setNome(this.nomeFld.getText());
		usuario.setEmail(this.emailFld.getText());
		usuario.setSenha(new String(this.senhaFld.getPassword()));		
		usuario.setStatusUsuario(this.statusFld.getItemAt(this.statusFld.getSelectedIndex()));
		usuario.setTelefone(this.telefoneFld.getText());
		
	    String pattern = "dd/MM/yyyy";
	    DateFormat df = new SimpleDateFormat(pattern);
	    
	    try 
	    {
	    	Date date = df.parse(this.dtNascimentoFld.getText());
	    	usuario.setDataNascimento(date);
	    }
	    catch(Exception e)
	    {
	    }
				
		return usuario;
	}
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5464321145565350625L;

	public static final String NAME = "Cliente Edicao";
	
	private boolean editMode = false;
	private Integer Id;
	
	private JTextField nomeFld;
	private JPasswordField senhaFld;
	private JFormattedTextField emailFld;
	private JFormattedTextField dtNascimentoFld;
	private JFormattedTextField telefoneFld;
	private JComboBox<br.com.webstore.model.StatusUsuario> statusFld;

	private JButton salvarBtn;
	
	public boolean validateFields() 
	{
		
		if ("".equals(this.nomeFld.getText())) 
		{
			JOptionPane.showMessageDialog(null, "Descricao deve ser preenchido");
			return false;
		}
		
		if ("".equals(this.emailFld.getText())) 
		{
			JOptionPane.showMessageDialog(null, "E-mail deve ser preenchido");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Create the panel.
	 */
	public UsuarioComumEdicao() 
	{
		this.setLayout(null);
		
		// Nome Label
		JLabel nomeLbl = new JLabel("Nome");
		nomeLbl.setBounds(7, 16, 100, 15);
		nomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(nomeLbl);
		
		// Nome TextField
		this.nomeFld = new JTextField();
		this.nomeFld.setBounds(7, 29, 219, 25);
		this.nomeFld.setToolTipText("Informe o nome.");
		this.nomeFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.nomeFld.setColumns(10);
		this.add(this.nomeFld);		

		// Email Label
		JLabel emailLbl = new JLabel("E-mail");
		emailLbl.setBounds(7, 61, 100, 15);
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(emailLbl);
		
		// Email TextField 
		this.emailFld = new JFormattedTextField();
		this.emailFld.setBounds(7, 74, 219, 15);
		this.emailFld.setToolTipText("Informe o E-mail.");
		this.emailFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.emailFld.setColumns(10);
		this.add(this.emailFld);
		
		// Senha Label 
		JLabel SenhaLbl = new JLabel("Senha");
		SenhaLbl.setBounds(7, 106, 100, 25);
		SenhaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(SenhaLbl);
		
		// Senha PasswordField
		this.senhaFld = new JPasswordField();
		this.senhaFld.setBounds(7, 129, 219, 25);
		this.senhaFld.setToolTipText("Informe o Senha.");
		this.senhaFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.senhaFld.setColumns(10);
		this.add(this.senhaFld);

		// Status de Usuario Label
		JLabel statusLbl = new JLabel("Status");
		statusLbl.setBounds(7, 161, 100, 15);
		statusLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(statusLbl);
		
		// Status de Usuario ComboBox
		this.statusFld = new JComboBox<StatusUsuario>();
		this.statusFld.setBounds(7, 174, 438, 25);
		this.statusFld.setToolTipText("Selecione o Status do usuario");
		this.statusFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(this.statusFld);
		DefaultComboBoxModel<StatusUsuario> statusUsuarioModel = new DefaultComboBoxModel<StatusUsuario>();
		List<StatusUsuario> statusList = new GenericFacade().findStatusUsuario(new StatusUsuario());
		for (StatusUsuario status : statusList) 
		{
			statusUsuarioModel.addElement(status);
		}
		this.statusFld.setModel(statusUsuarioModel);

		// Data de Nascimento Label
		JLabel DtNascimentoLbl = new JLabel("Data de Nascimento");
		DtNascimentoLbl.setBounds(7, 206, 150, 15);
		DtNascimentoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(DtNascimentoLbl);
		
		// Data de Nascimento TextField
		this.dtNascimentoFld = new JFormattedTextField();
		this.dtNascimentoFld.setBounds(7, 219, 100, 25);
		this.dtNascimentoFld.setToolTipText("Informe a data de nascimento.");
		this.dtNascimentoFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.dtNascimentoFld.setColumns(10);
		this.add(this.dtNascimentoFld);
		
		// Telfone Label
		JLabel TelefoneLbl = new JLabel("Telefone");
		TelefoneLbl.setBounds(7, 238, 150, 15);
		TelefoneLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(TelefoneLbl);
				
		try
		{
		    javax.swing.text.MaskFormatter telefone = new MaskFormatter("(##) ####-####");
		    this.telefoneFld = new JFormattedTextField(telefone);
		}
		catch(Exception e)
		{
		};    
		
		// Telefone TextField
		this.telefoneFld.setBounds(7, 251, 100, 25);
		this.telefoneFld.setToolTipText("Informe o telefone.");
		this.telefoneFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.telefoneFld.setColumns(10);
		this.add(this.telefoneFld);	
		
		// Botao Salvar
		this.salvarBtn = new JButton("Salvar");
		this.salvarBtn.setBounds(190, 400, 100, 32);
		this.salvarBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.salvarBtn.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (UsuarioComumEdicao.this.validateFields()) 
				{
					Usuario usuario = UsuarioComumEdicao.this.toModel();
					if (UsuarioComumEdicao.this.editMode) 
					{
						new GenericFacade().updateUsuario(usuario);
					}
				}
			}
		});
		this.add(this.salvarBtn);
	}
	
	public UsuarioComumEdicao(Integer id) 
	{
		this();
		this.editMode = true;
		this.Id = id;
		Usuario usuario = new GenericFacade().getUsuarioById(this.Id);
		
		this.nomeFld.setText(usuario.getNome());
		this.emailFld.setText(usuario.getEmail());
		this.senhaFld.setText(usuario.getSenha());
		
	    if (usuario.getDataNascimento() != null)
	    {
	    	try
	    	{
	    		String pattern = "dd/MM/yyyy";
		        DateFormat df = new SimpleDateFormat(pattern);
			    this.dtNascimentoFld.setText(df.format(usuario.getDataNascimento()));
		    }
	    	catch(Exception e)
	    	{
	    	}
	    }   	
		if (usuario.getTelefone()!=null)
		{
		     this.telefoneFld.setText(usuario.getTelefone());
		}
		this.statusFld.setSelectedItem(usuario.getStatusUsuario());		
	}
}
