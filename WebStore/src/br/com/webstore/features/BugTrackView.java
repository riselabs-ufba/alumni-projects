//#if ${BugTrack} == "T"
package br.com.webstore.features;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	
	public BugTrackView() {
		final GenericFacade situacaoBugFacade = new GenericFacade();
		situacoes = situacaoBugFacade.getListSituacaoBug();
		
		JComboBox combo = new JComboBox();
		for(int i=0;i<situacoes.size();i++)
			combo.addItem(situacoes.get(i).getDescricao());
		

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
				panel.add(new JLabel("Descri��o:"));
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
							GenericFacade bugFacade = new GenericFacade();
							GenericFacade usuarioFacade = new GenericFacade();
							Usuario usuario = usuarioFacade.getUsuarioById(1);
							System.out.println(usuario.getNome());
							SituacaoBug situacaoBug = situacaoBugFacade.findSituacaoBug(1);
							System.out.println(situacaoBug.getDescricao());
							BugTrack bug = new BugTrack(bugTitle.getText(),bugDescricao.getText(),usuario,situacaoBug);
							BugTrack result = bugFacade.insertBugTrack(bug);
							System.out.println(result.getTitulo());								
						}
					}
				});
				
				panel.add(btnSendBug);
				bugDialog.add(panel);
				bugDialog.setVisible(true);
			}

		});

		add(btnNewBug);
		
		

	}
}
//#endif
