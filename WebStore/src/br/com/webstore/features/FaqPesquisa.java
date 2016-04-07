//#if ${FAQ} == "T"
package br.com.webstore.features;

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

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Faq;

public class FaqPesquisa extends JPanel {
	
	private static final long serialVersionUID = 5574342454384440412L;


	

	public static final String NAME = "Cadastro de FAQ";

	
	private JScrollPane scrollPane;
	// private static JTable tableList;

	private JTable table;

	
	
	public FaqPesquisa(final GenericFacade gfacade) {
		this.setLayout(null);

		

		JLabel lblRelaoDeFaq = new JLabel("Frequent Asked Questions");
		lblRelaoDeFaq.setBounds(6, 100, 175, 14);
		this.add(lblRelaoDeFaq);

		this.scrollPane = new JScrollPane();
		
		this.scrollPane.setBounds(6, 125, 480, 99);

		final Vector<String> headers = new Vector<String>(3);
		headers.addElement(new String("No"));
		headers.addElement(new String("Questao"));
		
		
		this.table = new JTable();
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		this.scrollPane.setViewportView(this.table);
			
		 
		
		this.add(this.scrollPane);

			
	
		List<Faq> lista = gfacade.findFaq("");
		
		DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
		FaqPesquisa.this.table.setModel(model);
		

		int row = 0;
		for (Faq faq : lista) {
			FaqPesquisa.this.table.getModel().setValueAt(faq.getId(), row, 0);
			
			FaqPesquisa.this.table.getModel().setValueAt(faq.getDescricao(), row, 1);
			
			row++;
		}				
		FaqPesquisa.this.table.getColumnModel().getColumn(0).setPreferredWidth(40);
		FaqPesquisa.this.table.getColumnModel().getColumn(1).setPreferredWidth(435);
	
		JButton btnNewButton = new JButton("Cadastro");
		btnNewButton.setBounds(80, 44, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FaqEdit fe = new FaqEdit();				
				final JDialog frame = new JDialog();				
				fe.setDoneEvent(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						List<Faq> lista = new GenericFacade().findFaq("");
						
						DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
						FaqPesquisa.this.table.setModel(model);
						

						int row = 0;
						for (Faq faq : lista) {
							FaqPesquisa.this.table.getModel().setValueAt(faq.getId(), row, 0);
							FaqPesquisa.this.table.getModel().setValueAt(faq.getDescricao(), row, 1);
							
							row++;
						}	
					}
				});				
				frame.setModal(true);
				frame.setResizable(false);
				frame.setBounds(400, 200, 460, 320);
				frame.getContentPane().add(fe);
				frame.setVisible(true);
			}

		});

		this.add(btnNewButton);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListSelectionModel lsm = FaqPesquisa.this.table.getSelectionModel();
				int index = lsm.getLeadSelectionIndex();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um item antes de editar.");
				} else {
					Integer id = (Integer) FaqPesquisa.this.table.getValueAt(index, 0);
					
					FaqEdit fe = new FaqEdit(id);
					
					final JDialog frame = new JDialog();
					
					fe.setDoneEvent(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
							List<Faq> lista = new GenericFacade().findFaq("");
							
							DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
							FaqPesquisa.this.table.setModel(model);
							

							int row = 0;
							for (Faq faq : lista) {
								FaqPesquisa.this.table.getModel().setValueAt(faq.getId(), row, 0);
								FaqPesquisa.this.table.getModel().setValueAt(faq.getDescricao(), row, 1);
								
								row++;
							}					
				
							
						}
					});
					
					frame.setModal(true);
					frame.setResizable(false);
					frame.setBounds(400, 200, 460, 320);
					frame.getContentPane().add(fe);
					frame.setVisible(true);
				}
				
			}
		});
		btnEditar.setBounds(312, 44, 79, 23);
		this.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ListSelectionModel lsm = FaqPesquisa.this.table.getSelectionModel();
				int index = lsm.getLeadSelectionIndex();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um item antes de excluir.");
				} else {
					
					if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Excluir item selecionado?", "Excluir?", JOptionPane.YES_NO_OPTION)) {
						Integer id = (Integer) FaqPesquisa.this.table.getValueAt(index, 0);
						gfacade.removerFaq(id);
						List<Faq> lista = new GenericFacade().findFaq("");
						
						DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
						FaqPesquisa.this.table.setModel(model);
						

						int row = 0;
						for (Faq faq : lista) {
							FaqPesquisa.this.table.getModel().setValueAt(faq.getId(), row, 0);
							FaqPesquisa.this.table.getModel().setValueAt(faq.getDescricao(), row, 1);
							
							row++;
						}	
					}

				}
			}
		});
		btnExcluir.setBounds(195, 44, 89, 23);
		this.add(btnExcluir);

	}
}
//#endif
