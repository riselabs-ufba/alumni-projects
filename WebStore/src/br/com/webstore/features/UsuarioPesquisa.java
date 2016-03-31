
//#if ${UsuarioPesquisa} == "T"
package br.com.webstore.features;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Produto;
import br.com.webstore.model.Usuario;


/**
 * @author webstore
 *
 */
public class UsuarioPesquisa extends JPanel 
{
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5464321145565350625L;

	public static final String NAME = "Usuario";
	
	private JTextField textField;
	private JScrollPane scrollPane;
	// private static JTable tableList;

	private JTable table;

	/**
	 * Create the panel.
	 */
	
	public UsuarioPesquisa(final GenericFacade gfacade)
	{
		this.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Email do cliente: ");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoCliente.setBounds(6, 24, 96, 14);
		this.add(lblNomeDoCliente);
		
		this.textField = new JTextField();
		this.textField.setToolTipText("Informe o email do cliente.");
		this.textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.textField.setBounds(6, 53, 480, 20);
		this.add(this.textField);
		this.textField.setColumns(10);
		
		JLabel lblRelaoDoCliente = new JLabel("Clientes");
		lblRelaoDoCliente.setBounds(6, 140, 175, 14);
		this.add(lblRelaoDoCliente);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(6, 165, 480, 99);

		final Vector<String> headers = new Vector<String>(3);
		headers.addElement(new String("Id"));
		headers.addElement(new String("Nome"));
		headers.addElement(new String("Email"));
		headers.addElement(new String("Data de Nascimento"));
		headers.addElement(new String("Telefone"));
		headers.addElement(new String("Status"));
		headers.addElement(new String("Perfil"));
		headers.addElement(new String("Data de Inclusao"));
		
		this.table = new JTable();
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Usuario user = new Usuario();
				user.setEmail(UsuarioPesquisa.this.textField.getText());
				
				List<Usuario> lista = gfacade.findUsuario(user);
				
				DefaultTableModel model = new DefaultTableModel(headers, lista.size());
				UsuarioPesquisa.this.table.setModel(model);
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

				int row = 0;
				for (Usuario usuario : lista) {
					UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getId(), row, 0);
					UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getNome(), row, 1);
					UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getEmail(), row, 2);
					UsuarioPesquisa.this.table.getModel().setValueAt(df.format(usuario.getDataNascimento()), row, 3);
					UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getTelefone(), row, 4);
					UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getStatusUsuario().getDescricao(), row, 5);
					UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getPerfil().getDescricao(), row, 6);
					UsuarioPesquisa.this.table.getModel().setValueAt(df.format(usuario.getDataInclusao()), row, 7);
					row++;
				}
			}
		});
		btnPesquisa.setBounds(176, 85, 96, 23);
		this.add(btnPesquisa);
		
		this.scrollPane.setViewportView(this.table);
		this.add(this.scrollPane);

		JLabel lblPreenchimentoObrigatrio = new JLabel("Campos obrigat\u00F3rio.");
		lblPreenchimentoObrigatrio.setForeground(Color.RED);
		lblPreenchimentoObrigatrio.setBounds(350, 276, 136, 14);
		this.add(lblPreenchimentoObrigatrio);

		JLabel labelAterisk = new JLabel("*");
		labelAterisk.setForeground(new Color(255, 0, 0));
		labelAterisk.setBounds(102, 25, 109, 14);
		this.add(labelAterisk);
		
		JButton btnCadastrar = new JButton("Cadastro");
		btnCadastrar.setBounds(6, 85, 89, 23);
		btnCadastrar.addActionListener(new ActionListener() 
		{			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				UsuarioInclusaoEdicao uie = new UsuarioInclusaoEdicao();
				
				final JDialog frame = new JDialog();
				
				uie.setDoneEvent(new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						frame.dispose();
						Usuario usuario = new Usuario();
						usuario.setEmail(UsuarioPesquisa.this.textField.getText());
						List<Usuario> lista = gfacade.findUsuario(usuario);
						
						DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
						UsuarioPesquisa.this.table.setModel(model);
						
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

						int row = 0;
						for (Usuario usr : lista) 
						{
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getId(), row, 0);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getNome(), row, 1);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getEmail(), row, 2);
							UsuarioPesquisa.this.table.getModel().setValueAt(df.format(usr.getDataNascimento()), row, 3);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getTelefone(), row, 4);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getStatusUsuario().getDescricao(), row, 5);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getPerfil().getDescricao(), row, 6);
							UsuarioPesquisa.this.table.getModel().setValueAt(df.format(usr.getDataInclusao()), row, 7);
							row++;
						}
					}
				});
				frame.setModal(true);
				frame.setResizable(false);
				frame.setBounds(0, 0, 640, 480);
				frame.getContentPane().add(uie);
				frame.setVisible(true);
			}

		});

		this.add(btnCadastrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				ListSelectionModel lsm = UsuarioPesquisa.this.table.getSelectionModel();
				int index = lsm.getLeadSelectionIndex();
				
				if (index == -1) 
				{
					JOptionPane.showMessageDialog(null, "Selecione um cliente antes de editar.");
				} 
				else 
				{
					Integer id = (Integer) UsuarioPesquisa.this.table.getValueAt(index, 0);
					
					UsuarioInclusaoEdicao uie = new UsuarioInclusaoEdicao(id);
					
					final JDialog frame = new JDialog();
					
					uie.setDoneEvent(new ActionListener() 
					{
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							frame.dispose();
							Usuario usr = new Usuario();
							usr.setEmail(UsuarioPesquisa.this.textField.getText());
							List<Usuario> lista = gfacade.findUsuario(usr);
							
							DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
							UsuarioPesquisa.this.table.setModel(model);
							
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

							int row = 0;
							for (Usuario usuario : lista) {
								UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getId(), row, 0);
								UsuarioPesquisa.this.table.getModel().setValueAt(usr.getNome(), row, 1);
								UsuarioPesquisa.this.table.getModel().setValueAt(usr.getEmail(), row, 2);
								UsuarioPesquisa.this.table.getModel().setValueAt(df.format(usr.getDataNascimento()), row, 3);
								UsuarioPesquisa.this.table.getModel().setValueAt(usr.getTelefone(), row, 4);
								UsuarioPesquisa.this.table.getModel().setValueAt(usr.getStatusUsuario().getDescricao(), row, 5);
								UsuarioPesquisa.this.table.getModel().setValueAt(usr.getPerfil().getDescricao(), row, 6);
								UsuarioPesquisa.this.table.getModel().setValueAt(df.format(usr.getDataInclusao()), row, 7);
								row++;
							}
						}
					});
					
					frame.setModal(true);
					frame.setResizable(false);
					frame.setBounds(0, 0, 460, 320);
					frame.getContentPane().add(uie);
					frame.setVisible(true);
				}
				
			}
		});
		btnEditar.setBounds(268, 85, 79, 23);
		this.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ListSelectionModel lsm = UsuarioPesquisa.this.table.getSelectionModel();
				int index = lsm.getLeadSelectionIndex();
				
				if (index == -1) 
				{
					JOptionPane.showMessageDialog(null, "Selecione um cliente antes de excluir.");
				} 
				else 
				{	
					if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Excluir cliente selecionado?", "Excluir?", JOptionPane.YES_NO_OPTION)) 
					{
						Integer id = (Integer) UsuarioPesquisa.this.table.getValueAt(index, 0);
						gfacade.removeUsuario(id);
						Usuario usuario = new Usuario();
						usuario.setEmail(UsuarioPesquisa.this.textField.getText());
						List<Usuario> lista = gfacade.findUsuario(usuario);
						
						DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
						UsuarioPesquisa.this.table.setModel(model);
						
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

						int row = 0;
						for (Usuario usr : lista) 
						{
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getId(), row, 0);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getNome(), row, 1);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getEmail(), row, 2);
							UsuarioPesquisa.this.table.getModel().setValueAt(df.format(usr.getDataNascimento()), row, 3);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getTelefone(), row, 4);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getStatusUsuario().getDescricao(), row, 5);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getPerfil().getDescricao(), row, 6);
							UsuarioPesquisa.this.table.getModel().setValueAt(df.format(usr.getDataInclusao()), row, 7);
							row++;
						}
					}

				}
			}
		});
		btnExcluir.setBounds(92, 85, 89, 23);
		this.add(btnExcluir);
	}
}
//#endif