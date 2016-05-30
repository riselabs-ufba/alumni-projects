//#if ${Categoria} == "T"
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
import javax.swing.JTextArea;
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
	private JTable table;
	private JTextField textField;
	private JScrollPane scrollPane;
	


	/**
	 * Create the panel.
	 */
	public CategoriaP(final GenericFacade gfacade) {
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
		
		this.table = new JTable();
		this.scrollPane.setViewportView(this.table);
		this.add(this.scrollPane);
		listagemcategoria(CategoriaP.this.textField.getText());
		
		JButton btnCadastrp = new JButton("Pesquisar");
		btnCadastrp.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listagemcategoria(CategoriaP.this.textField.getText());
				}				
		});

			
			
		
		btnCadastrp.setBounds(312, 84, 79, 23);
		add(btnCadastrp);
		
		JButton btnNewButton = new JButton("Cadastro");		
		btnNewButton.setBounds(6, 85, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final JDialog DxCad = new JDialog();
				DxCad.setModal(true);
				DxCad.setTitle("Nova Categoria");
				DxCad.setResizable(false);
				DxCad.setBounds(0, 0, 460, 320);
				DxCad.setLocationRelativeTo(null);
				final JTextField cDescricao = new JTextField(40);
				JPanel panel = new JPanel();
				panel.add(new JLabel("Descricao: "));
				panel.add(cDescricao);					
				JButton btnSend = new JButton("Salvar");
				btnSend.setBounds(20, 85, 89, 23);
				btnSend.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(cDescricao.getText().length()==0){
									JOptionPane.showMessageDialog(null, "O Campo descricao deve ser preenchido");
								}
							else{						
									Categoria cate = new Categoria();									
									cate.setDescricao(cDescricao.getText());									
									gfacade.insertCategoria(cate);									
									DxCad.dispose();
									listagemcategoria(CategoriaP.this.textField.getText());

						};
						
						
					};

				});
				panel.add(btnSend);
				DxCad.add(panel);
				DxCad.setVisible(true);

		
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
						gfacade.removerCategoria(id);
						JOptionPane.showMessageDialog(null, "Categoria Apagada");
						listagemcategoria(CategoriaP.this.textField.getText());
					}

				}
			}
		});
		
		
		
		btnNewButton_1.setBounds(195, 84, 89, 23);
		add(btnNewButton_1);

		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um item antes de editar.");
				} else 			{
					int id = Integer.parseInt(table.getModel().getValueAt(selectedRow, 0).toString());
					final Categoria cat = gfacade.getById(id);					
					if(cat!=null){
						final JDialog cxDialog = new JDialog();						
						cxDialog.setModal(true);
						cxDialog.setTitle("Editar Categoria");
						cxDialog.setResizable(false);
						cxDialog.setBounds(0, 0, 460, 320);
						cxDialog.setLocationRelativeTo(null);
						JPanel panel = new JPanel();
						final JTextArea NovaCat = new JTextArea(10,40);
						NovaCat.setText(cat.getDescricao());
						panel.add(new JLabel("Descricao"));
					    	panel.add(NovaCat);
						JButton btnSalvar = new JButton("Salvar");
						btnSalvar.setBounds(6, 85, 89, 23);
						btnSalvar.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if(NovaCat.getText().length()==0){
									JOptionPane.showMessageDialog(null, "O campo descrição deve ser preenchido");
								}
								else{									
									cat.setDescricao(NovaCat.getText());									
									gfacade.updateCategoria(cat);
									JOptionPane.showMessageDialog(null, "Alteracao Salva com Sucesso");
									cxDialog.dispose();
									listagemcategoria(CategoriaP.this.textField.getText());
								}
							}
						});
						
						panel.add(btnSalvar);
						cxDialog.add(panel);
						cxDialog.setVisible(true);
					
					}
					
				}
			}

		});
		btnEditar.setBounds(430, 85, 79, 23);
		this.add(btnEditar);
		

		
	}
	private void listagemcategoria(String nomecate) {
		final Vector<String> headers = new Vector<String>(3);
		headers.addElement(new String("Id"));
		headers.addElement(new String("Nome"));
		//headers.addElement(new String("Valor"));
		List<Categoria> lista = new GenericFacade().findCategoria(nomecate);		
		DefaultTableModel modelList = new DefaultTableModel(headers, lista.size());
		CategoriaP.this.table.setModel(modelList);
		int row = 0;
		for (Categoria categoria : lista) {
			CategoriaP.this.table.getModel().setValueAt(categoria.getId(), row, 0);
			CategoriaP.this.table.getModel().setValueAt(categoria.getDescricao(), row, 1);			
			row++;
			}
		CategoriaP.this.table.getColumnModel().getColumn(0).setPreferredWidth(40);
		CategoriaP.this.table.getColumnModel().getColumn(1).setPreferredWidth(200);
			
		}		
	
}
//#endif

