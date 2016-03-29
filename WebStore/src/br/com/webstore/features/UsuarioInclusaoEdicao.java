//#if ${UsuarioInclusaoEdicao} == "T"
package br.com.webstore.features;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Perfil;
import br.com.webstore.model.StatusUsuario;
import br.com.webstore.model.Usuario;

/**
 * @author webstore
 *
 */
public class UsuarioInclusaoEdicao extends JPanel 
{
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5464321145565350625L;

	public static final String NAME = "Cliente";
	
	private boolean editMode = false;
	private Integer Id;
	
	private JTextField nomeFld;
	private JTextField senhaFld;
	private JFormattedTextField emailFld;
	private JFormattedTextField dtNascimentoFld;
	private JFormattedTextField telefoneFld;
	private JComboBox<br.com.webstore.model.StatusUsuario> statusFld;
	private JComboBox<br.com.webstore.model.Perfil> perfilFld;

	private JButton salvarBtn;
	
	private ActionListener doneEvent;

	public Usuario toModel() 
	{
		Usuario usuario = new Usuario();
		
		if (this.editMode) 
		{
			usuario.setId(this.Id);
		}
		
		usuario.setNome(this.nomeFld.getText());
		usuario.setEmail(this.emailFld.getText());
		usuario.setSenha(this.senhaFld.getText());		
		usuario.setStatusUsuario(this.statusFld.getItemAt(this.statusFld.getSelectedIndex()));
		usuario.setPerfil(this.perfilFld.getItemAt(this.perfilFld.getSelectedIndex()));
		return usuario;
	}
	
	public boolean validateFields() 
	{
		
		if ("".equals(this.nomeFld.getText())) {
			JOptionPane.showMessageDialog(null, "Descricao deve ser preenchido");
			return false;
		}
		
		if ("".equals(this.emailFld.getText())) {
			JOptionPane.showMessageDialog(null, "Descricao deve ser preenchido");
			return false;
		}
		
		return true;
	}
	
	public void setDoneEvent(ActionListener doneEvent) 
	{
		this.doneEvent = doneEvent;
	}
	
	public UsuarioInclusaoEdicao(Integer id) 
	{
		this();
		this.editMode = true;
		this.Id = id;
		Usuario usuario = new GenericFacade().getUsuarioById(this.Id);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		this.nomeFld.setText(usuario.getNome());
		this.emailFld.setText(usuario.getEmail());
		this.senhaFld.setText(usuario.getSenha());
		this.dtNascimentoFld.setText(df.format(usuario.getDataNascimento()));
		this.telefoneFld.setText(usuario.getTelefone());
		this.perfilFld.setSelectedItem(usuario.getPerfil());
		this.statusFld.setSelectedItem(usuario.getStatusUsuario());
	}
	
	/**
	 * Create the panel.
	 */
	public UsuarioInclusaoEdicao() {
		this.setLayout(null);

		// Nome
		JLabel nomeLbl = new JLabel("Nome");
		nomeLbl.setBounds(7, 16, 100, 15);
		nomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(nomeLbl);
		
		this.nomeFld = new JTextField();
		this.nomeFld.setBounds(7, 29, 438, 25);
		this.nomeFld.setToolTipText("Informe o nome.");
		this.nomeFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.nomeFld.setColumns(10);
		this.add(this.nomeFld);

		// Email
		JLabel emailLbl = new JLabel("E-mail");
		emailLbl.setBounds(7, 61, 100, 15);
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(emailLbl);
		
		this.emailFld.setBounds(7, 74, 438, 25);
		this.emailFld.setToolTipText("Informe o E-mail.");
		this.emailFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.emailFld.setColumns(10);
		this.add(this.emailFld);
		
		// Senha
		JLabel SenhaLbl = new JLabel("Senha");
		SenhaLbl.setBounds(7, 106, 100, 15);
		SenhaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(SenhaLbl);
		
		this.senhaFld.setBounds(7, 119, 438, 25);
		this.senhaFld.setToolTipText("Informe o Senha.");
		this.senhaFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.senhaFld.setColumns(10);
		this.add(this.senhaFld);

		// Status de Usuario
		JLabel statusLbl = new JLabel("");
		statusLbl.setBounds(7, 151, 100, 15);
		statusLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(statusLbl);
		
		this.statusFld = new JComboBox<StatusUsuario>();
		this.statusFld.setBounds(7, 164, 438, 25);
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

		// Perfil
		JLabel pefilLbl = new JLabel("Perfil");
		pefilLbl.setBounds(7, 196, 100, 15);
		pefilLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(pefilLbl);
		
		this.perfilFld = new JComboBox<br.com.webstore.model.Perfil>();
		this.perfilFld.setBounds(7, 209, 438, 25);
		this.perfilFld.setToolTipText("Selecione o perfil do Usuario.");
		this.perfilFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(this.perfilFld);

		List<br.com.webstore.model.Perfil> perfilList = new GenericFacade().findPerfil(new Perfil());
		DefaultComboBoxModel<br.com.webstore.model.Perfil> perfilModel = new DefaultComboBoxModel<br.com.webstore.model.Perfil>();
		for (br.com.webstore.model.Perfil perfil : perfilList) 
		{
			perfilModel.addElement(perfil);
		}
		this.perfilFld.setModel(perfilModel);
		
		// Botao Salvar
		this.salvarBtn = new JButton("Salvar");
		this.salvarBtn.setBounds(7, 241, 100, 32);
		this.salvarBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.salvarBtn.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (UsuarioInclusaoEdicao.this.validateFields()) 
				{
					Usuario usuario = UsuarioInclusaoEdicao.this.toModel();
					if (UsuarioInclusaoEdicao.this.editMode) 
					{
						new GenericFacade().updateUsuario(usuario);
					} 
					else 
					{
						usuario.setDataInclusao(Calendar.getInstance().getTime());
						new GenericFacade().insertUsuario(usuario);
					}

					if (UsuarioInclusaoEdicao.this.doneEvent != null) 
					{
						UsuarioInclusaoEdicao.this.doneEvent.actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, e.getActionCommand()));
					}
					
				}
			}
		});
		this.add(this.salvarBtn);
}
}
//#endif
