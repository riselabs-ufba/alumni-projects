
//#if ${UsuarioPesquisa} == "T"
package br.com.webstore.features;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		headers.addElement(new String("Login"));
		headers.addElement(new String("Nome"));
		
		
		this.table = new JTable();
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				List<Usuario> lista = new GenericFacade().findUsuario(UsuarioPesquisa.this.textField.getText()) ;
				DefaultTableModel model = new DefaultTableModel(headers, lista.size());
				UsuarioPesquisa.this.table.setModel(model);
							

				int row = 0;
				for (Usuario usuario : lista) {
					UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getId(), row, 0);
					UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getDsLogin(), row, 1);
					UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getNome(), row, 2);
					
					row++;
				}
				UsuarioPesquisa.this.table.getColumnModel().getColumn(0).setPreferredWidth(40);
				UsuarioPesquisa.this.table.getColumnModel().getColumn(1).setPreferredWidth(135);
				UsuarioPesquisa.this.table.getColumnModel().getColumn(2).setPreferredWidth(300);	
			}
		});
		btnPesquisa.setBounds(312, 84, 96, 23);
		this.add(btnPesquisa);
		
		this.scrollPane.setViewportView(this.table);
		this.add(this.scrollPane);

		JButton btnCadastrar = new JButton("Cadastro");
		btnCadastrar.setBounds(80, 84, 89, 23);
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
												
						List<Usuario> lista = new GenericFacade().findUsuario(UsuarioPesquisa.this.textField.getText());
						
						DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
						UsuarioPesquisa.this.table.setModel(model);

						int row = 0;
						for (Usuario usr : lista) 
						{
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getId(), row, 0);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getDsLogin(),row,1);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getNome(), row, 2);
							
							row++;
						}
						UsuarioPesquisa.this.table.getColumnModel().getColumn(0).setPreferredWidth(40);
						UsuarioPesquisa.this.table.getColumnModel().getColumn(1).setPreferredWidth(135);
						UsuarioPesquisa.this.table.getColumnModel().getColumn(2).setPreferredWidth(300);
					}
				});
				frame.setModal(true);
				frame.setResizable(false);
				frame.setBounds(400, 200, 480, 480);
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
							
							List<Usuario> lista = new GenericFacade().findUsuario(UsuarioPesquisa.this.textField.getText());
							
							DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
							UsuarioPesquisa.this.table.setModel(model);

							int row = 0;
							for (Usuario usuario : lista) 
							{
								UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getId(), row, 0);
								UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getDsLogin(), row, 1);
								UsuarioPesquisa.this.table.getModel().setValueAt(usuario.getNome(), row, 2);								
								
								row++;
							}
							UsuarioPesquisa.this.table.getColumnModel().getColumn(0).setPreferredWidth(40);
							UsuarioPesquisa.this.table.getColumnModel().getColumn(1).setPreferredWidth(135);
							UsuarioPesquisa.this.table.getColumnModel().getColumn(2).setPreferredWidth(300);
						}
					});
					frame.setModal(true);
					frame.setResizable(false);
					frame.setBounds(400, 200, 480, 480);
					frame.getContentPane().add(uie);
					frame.setVisible(true);
				}
			}
		});
		btnEditar.setBounds(430, 85, 79, 23);
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
						
						List<Usuario> lista = new GenericFacade().findUsuario(UsuarioPesquisa.this.textField.getText());
						
						DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
						UsuarioPesquisa.this.table.setModel(model);				

						int row = 0;
						for (Usuario usr : lista) 
						{
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getId(), row, 0);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getDsLogin(), row, 1);
							UsuarioPesquisa.this.table.getModel().setValueAt(usr.getNome(), row, 2);
							
							row++;
						}
						UsuarioPesquisa.this.table.getColumnModel().getColumn(0).setPreferredWidth(40);
						UsuarioPesquisa.this.table.getColumnModel().getColumn(1).setPreferredWidth(135);
						UsuarioPesquisa.this.table.getColumnModel().getColumn(2).setPreferredWidth(300);
					}
				}
			}
		});
		btnExcluir.setBounds(195, 84, 89, 23);
		this.add(btnExcluir);
	}
}
//#endif