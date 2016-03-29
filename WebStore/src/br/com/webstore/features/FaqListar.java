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

public class FaqListar extends JPanel {
	
	
	private static final long serialVersionUID = 5324562225697709297L;


	

	public static final String NAME = "FAQ";


	private JScrollPane scrollPane;


	private JTable table;


	public FaqListar() {
		this.setLayout(null);

		

		JLabel lblRelaoDeFaq = new JLabel("Frequent Asked Questions");
		lblRelaoDeFaq.setBounds(50, 30, 175, 14);
		this.add(lblRelaoDeFaq);

		this.scrollPane = new JScrollPane();
	
		this.scrollPane.setBounds(50, 50, 480, 200);

		final Vector<String> headers = new Vector<String>(3);
		headers.addElement(new String("Nº"));
		headers.addElement(new String("Questão"));
		
		
		this.table = new JTable();
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		this.scrollPane.setViewportView(this.table);
 
		
		this.add(this.scrollPane);

				List<Faq> lista = new GenericFacade().findFaq("");
				
				DefaultTableModel model = new DefaultTableModel(headers, lista.size());				
				FaqListar.this.table.setModel(model);
				

				int row = 0;
				for (Faq faq : lista) {
					FaqListar.this.table.getModel().setValueAt(faq.getId(), row, 0);
					
					FaqListar.this.table.getModel().setValueAt(faq.getDescricao(), row, 1);
					
					row++;
				}				
				FaqListar.this.table.getColumnModel().getColumn(0).setPreferredWidth(40);
				FaqListar.this.table.getColumnModel().getColumn(1).setPreferredWidth(435);
	
				JButton btnDetalhes = new JButton("Detalhes");
				btnDetalhes .addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						ListSelectionModel lsm = FaqListar.this.table.getSelectionModel();
						int index = lsm.getLeadSelectionIndex();
						
						if (index == -1) {
							JOptionPane.showMessageDialog(null, "É necessário selecionar um item.");
						} else {
							Integer id = (Integer) FaqListar.this.table.getValueAt(index, 0);
							
							FaqDetalhes fd = new FaqDetalhes(id);
							
							final JDialog frame = new JDialog();
							
						
							
							frame.setModal(true);
							frame.setResizable(false);
							frame.setBounds(500, 300, 460, 200);
							frame.getContentPane().add(fd);
							frame.setVisible(true);
						}
						
					}
				});
				btnDetalhes .setBounds(440, 273, 90, 23);
				this.add(btnDetalhes );

	}
}
// #endif
