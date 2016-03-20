//#if ${CategoriaP} == "F"
package br.com.webstore.features;

import java.awt.Color;
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
import br.com.webstore.model.Categoria;

public class CategoriaP extends JPanel {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5464321145565350625L;

	public static final String NAME = "Categoria";
	
	private JTextField textField;
	private JScrollPane scrollPane;
	//private static JTable tableList;

	private JTable table;

	/**
	 * Create the panel.
	 */
	public CategoriaP() {
//add this		
		this.setLayout(null);
		
		this.textField = new JTextField();
		this.textField.setToolTipText("Informe o nome da categoria.");
		this.textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.textField.setBounds(57, 53, 353, 20);
		this.add(textField);
		this.textField.setColumns(10);
		
		JLabel lblNomeDaCategoria = new JLabel("Nome da Categoria ");
		lblNomeDaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaCategoria.setBounds(57, 24, 124, 14);
		add(lblNomeDaCategoria);
		
		JLabel lblRelaoDeCategorias = new JLabel("Categorias");
		lblRelaoDeCategorias.setBounds(57, 140, 124, 14);
		add(lblRelaoDeCategorias);
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(57, 165, 353, 99);
		add(scrollPane);

		final Vector<String> headers = new Vector<String>(3);
		headers.addElement(new String("Id"));
		headers.addElement(new String("Nome"));
		headers.addElement(new String("Valor"));

		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JLabel lblPreenchimentoObrigatrio = new JLabel("Campos obrigat\u00F3rio.");
		lblPreenchimentoObrigatrio.setForeground(Color.RED);
		lblPreenchimentoObrigatrio.setBounds(274, 275, 136, 14);
		add(lblPreenchimentoObrigatrio);
		
		JLabel labelAterisk = new JLabel("*");
		labelAterisk.setForeground(new Color(255, 0, 0));
		labelAterisk.setBounds(165, 25, 46, 14);

		
		this.add(labelAterisk);
		
		JButton btnCadastrp = new JButton("Pesquisar");
		btnCadastrp.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				List<Categoria> lista = new GenericFacade().findCategoria(CategoriaP.this.textField.getText());				
				DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
				CategoriaP.this.table.setModel(model);
				

				int row = 0;
				for (Categoria categoria : lista) {
					CategoriaP.this.table.getModel().setValueAt(categoria.getId(), row, 0);
					CategoriaP.this.table.getModel().setValueAt(categoria.getDescricao(), row, 1);							
					row++;
				}				
			}
		});
//		btnCadastrp.setBounds(176, 85, 96, 23);	
			
			
		
		btnCadastrp.setBounds(312, 84, 79, 23);
		add(btnCadastrp);
		
		JButton btnNewButton = new JButton("Cadastro");		
		btnNewButton.setBounds(6, 85, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CategoriaEdit pe = new CategoriaEdit();				
				final JDialog frame = new JDialog();				
				pe.setDoneEvent(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});				
				frame.setModal(true);
				frame.setResizable(false);
				frame.setBounds(0, 0, 460, 320);
				frame.getContentPane().add(pe);
				frame.setVisible(true);
			}

		});

		btnNewButton.setBounds(80, 84, 89, 23);		
		this.add(btnNewButton);
		
				
		
		JButton btnNewButton_1 = new JButton("Excluir");
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ListSelectionModel lsm = CategoriaP.this.table.getSelectionModel();
				int index = lsm.getLeadSelectionIndex();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um item antes de excluir.");
				} else {
					
					if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Excluir item selecionado?", "Excluir?", JOptionPane.YES_NO_OPTION)) {
						Integer id = (Integer) CategoriaP.this.table.getValueAt(index, 0);
						new GenericFacade().removerCategoria(id);
					}

				}
			}
		});
		
		
		
		btnNewButton_1.setBounds(195, 84, 89, 23);
		add(btnNewButton_1);

		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListSelectionModel lsm = CategoriaP.this.table.getSelectionModel();
				int index = lsm.getLeadSelectionIndex();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um item antes de editar.");
				} else {
					Integer id = (Integer) CategoriaP.this.table.getValueAt(index, 0);
					
					CategoriaEdit pe = new CategoriaEdit(id);
					
					final JDialog frame = new JDialog();
					
					pe.setDoneEvent(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
						}
					});
					
					frame.setModal(true);
					frame.setResizable(false);
					frame.setBounds(0, 0, 460, 320);
					frame.getContentPane().add(pe);
					frame.setVisible(true);
				}
				
			}
		});
		btnEditar.setBounds(430, 85, 79, 23);
		this.add(btnEditar);
		
		

		
	}
}
//#endif
