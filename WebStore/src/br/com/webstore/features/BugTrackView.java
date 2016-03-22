//#if ${BugTrack} == "T"
package br.com.webstore.features;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.BugTrack;
import br.com.webstore.model.SituacaoBug;
import br.com.webstore.model.Usuario;

public class BugTrackView extends JPanel{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "BugTrack";
	
	public List<br.com.webstore.model.SituacaoBug> situacoes;
	public String[] items;
	public Vector<Vector<String>> data;
	public JTable table;
	TableModel myTableModel;
	GenericFacade facade;
	
	public BugTrackView() {
		facade = new GenericFacade();
		situacoes = facade.getListSituacaoBug();
		
		JComboBox<String> combo = new JComboBox<String>();
		for(int i=0;i<situacoes.size();i++)
			combo.addItem(situacoes.get(i).getDescricao());
		
		//Jtable data
		List<BugTrack> results = facade.findBugTrack();
		data = resultsToData(results);
		final Vector<String> columnNames = new Vector<String>();
		columnNames.add("ID");
		columnNames.add("Usuário registro");
		columnNames.add("Usuário resposta");
		columnNames.add("Título");
		columnNames.add("Situação");
		columnNames.add("Ações");
		//myTableModel = new MyTableModel(data,columnNames);
	    table = new JTable(data, columnNames);

		JTextField query = new JTextField(15);
	    add(new JLabel("Palavra-chave:"));
	    add(query);
	    add(new JLabel("Status:"));
	    add(combo);
	    JButton submit = new JButton("Pesquisar");
	    submit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	          //System.out.println(this..getText()) + " " + form.getText(1));
	        }
	    });
	    add(submit);
	    
	    JButton btnNewBug = new JButton("Reportar bug");
		btnNewBug.setBounds(6, 85, 89, 23);
		btnNewBug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final JDialog bugDialog = new JDialog();
				
				bugDialog.setModal(true);
				bugDialog.setTitle("Reportar bug");
				bugDialog.setResizable(false);
				bugDialog.setBounds(0, 0, 460, 320);
				final JTextField bugTitle = new JTextField(40);
				JPanel panel = new JPanel();
				panel.add(new JLabel("Titulo:"));
			    panel.add(bugTitle);
			    final JTextArea bugDescricao = new JTextArea(10,40);
				panel.add(new JLabel("Descrição:"));
			    panel.add(bugDescricao);
				
				JButton btnSendBug = new JButton("Enviar");
				
				btnSendBug.setBounds(6, 85, 89, 23);
				btnSendBug.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(bugTitle.getText().length()==0 || bugDescricao.getText().length()==0){
							JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
						}
						else{
							
							
							Usuario usuario = facade.getUsuarioById(1);
							System.out.println(usuario.getNome());
							SituacaoBug situacaoBug = facade.findSituacaoBug(1);
							System.out.println(situacaoBug.getDescricao());
							BugTrack bug = new BugTrack();
							bug.setTitulo(bugTitle.getText());
							bug.setDescricao(bugDescricao.getText());
							bug.setUsuarioRegistro(usuario);
							bug.setSituacaoBug(situacaoBug);
							bug.setDataRegistro(new Date());
							BugTrack result = facade.insertBugTrack(bug);
							if(result.getId()!= null){
								System.out.println(result.getTitulo());								
								List<BugTrack> results = facade.findBugTrack();
								data = resultsToData(results);
								DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.setDataVector(data, columnNames);
								table.repaint();
								bugDialog.dispose();
							}
							else{
								JOptionPane.showMessageDialog(null, "Não foi possível salvar o bug.");
							}
															
						}
					}
				});
				
				panel.add(btnSendBug);
				bugDialog.add(panel);
				bugDialog.setVisible(true);
			}

		});

		add(btnNewBug);
		
		
		JButton btnDeleteBug = new JButton("Deletar bug");
		btnDeleteBug.setBounds(6, 85, 89, 23);
		btnDeleteBug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				System.out.println("deletar bug "+selectedRow);
				
				if(selectedRow==-1){
					JOptionPane.showMessageDialog(null, "Selecione algum registro.");
				}
				else{
					int id = Integer.parseInt(table.getModel().getValueAt(selectedRow, 0).toString());
					if(facade.removeBugTrack(id)){
						List<BugTrack> results = facade.findBugTrack();
						data = resultsToData(results);
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setDataVector(data, columnNames);
						table.repaint();
					}
					else{
						JOptionPane.showMessageDialog(null, "Não foi possível remover o registro.");
					}
				}
			}

		});

		add(btnDeleteBug);

		JButton btnFixingBug = new JButton("Consertando bug");
		btnFixingBug.setBounds(6, 85, 89, 23);
		btnFixingBug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				System.out.println("deletar bug "+selectedRow);
				
				if(selectedRow==-1){
					JOptionPane.showMessageDialog(null, "Selecione algum registro.");
				}
				else{
					int id = Integer.parseInt(table.getModel().getValueAt(selectedRow, 0).toString());
					BugTrack bug = facade.getBugTrack(id);
					if(bug!=null){
						bug.setSituacaoBug(facade.findSituacaoBug(2));
						if(facade.updateBugTrack(bug)){
							List<BugTrack> results = facade.findBugTrack();
							data = resultsToData(results);
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model.setDataVector(data, columnNames);
							table.repaint();
						}
						else{
							JOptionPane.showMessageDialog(null, "Não foi possível atualizar o registro.");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Não foi possível atualizar o registro.");
					}
				}
			}

		});

		add(btnFixingBug);
		
		JButton btnCloseBug = new JButton("Fechar bug");
		btnCloseBug.setBounds(6, 85, 89, 23);
		btnCloseBug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				System.out.println("deletar bug "+selectedRow);
				
				if(selectedRow==-1){
					JOptionPane.showMessageDialog(null, "Selecione algum registro.");
				}
				else{
					int id = Integer.parseInt(table.getModel().getValueAt(selectedRow, 0).toString());
					BugTrack bug = facade.getBugTrack(id);
					if(bug!=null){
						bug.setSituacaoBug(facade.findSituacaoBug(3));
						if(facade.updateBugTrack(bug)){
							List<BugTrack> results = facade.findBugTrack();
							data = resultsToData(results);
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model.setDataVector(data, columnNames);
							table.repaint();
						}
						else{
							JOptionPane.showMessageDialog(null, "Não foi possível atualizar o registro.");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Não foi possível atualizar o registro.");
					}
				}
			}

		});

		add(btnCloseBug);


		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		add(scrollPane);
		
	}
	
	public Vector<Vector<String>> resultsToData(List<BugTrack> results){
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		for(int i=0; i<results.size();i++){
			Vector<String> vec = new Vector<String>();
			
			System.out.println(results.get(i).getId());
			vec.add(results.get(i).getId().toString());
			System.out.println(results.get(i).getUsuarioRegistro().getNome());
			vec.add(results.get(i).getUsuarioRegistro().getNome());
			if(results.get(i).getUsuarioResponde()!=null){
				System.out.println(results.get(i).getUsuarioResponde().getNome());
				vec.add(results.get(i).getUsuarioResponde().getNome());
			}
			else{
				vec.add("");
			}
			System.out.println(results.get(i).getTitulo());
			vec.add(results.get(i).getTitulo());
			System.out.println(results.get(i).getSituacaoBug().getDescricao());
			vec.add(results.get(i).getSituacaoBug().getDescricao());
			System.out.println("btn");
			vec.add("btns");
			data.add(vec);
		}
		return data;
	}
}
//#endif
