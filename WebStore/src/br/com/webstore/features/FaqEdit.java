//#if ${Comunicacao} == "T"
//#if ${FAQ} == "T"
//#if ${FAQAlterar} == "T" 
package br.com.webstore.features;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Faq;


public class FaqEdit extends JPanel {
	
	
	private static final long serialVersionUID = 5551757562717343404L;



	public static final String NAME = "Faq";
	
	private boolean editMode = false;
	private Integer Id;
	
	
	private JTextField descricaoFld;
	private JTextField respostaFld;
	
	private JButton salvarBtn;
	
	private ActionListener doneEvent;
	


	public Faq toModel() {
		Faq faq = new Faq();
		
		if (this.editMode) {
			faq.setId(this.Id);
		}
		
		faq.setDescricao(this.descricaoFld.getText());
		faq.setResposta(this.respostaFld.getText());
		
		return faq;
	}
	
	public boolean validateFields() {
		
		if ("".equals(this.descricaoFld.getText())) {
			JOptionPane.showMessageDialog(null, "Descricao deve ser preenchido");
			return false;
		}
		
		if ("".equals(this.respostaFld.getText())) {
			JOptionPane.showMessageDialog(null, "Resposta deve ser preenchido");
			return false;
		}
		
		return true;
	}
	
	public void setDoneEvent(ActionListener doneEvent) {
		this.doneEvent = doneEvent;
	}
	
	public FaqEdit(Integer id) {
		this();
		this.editMode = true;
		this.Id = id;
		Faq faq = new GenericFacade().getFaqById(this.Id);
		
		this.descricaoFld.setText(faq.getDescricao());
		this.respostaFld.setText(faq.getResposta());
		
	}
	
	/**
	 * Create the panel.
	 */
	public FaqEdit() {
		this.setLayout(null);

		// Questao
		JLabel descricaoLbl = new JLabel("Questao");
		descricaoLbl.setBounds(7, 16, 100, 15);
		descricaoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(descricaoLbl);
		
		this.descricaoFld = new JTextField();
		this.descricaoFld.setBounds(7, 29, 438, 25);
		this.descricaoFld.setToolTipText("Informe a questao");
		this.descricaoFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.descricaoFld.setColumns(10);
		this.add(this.descricaoFld);

		// Resposta
		JLabel respostaLbl = new JLabel("Resposta");
		respostaLbl.setBounds(7, 61, 100, 15);
		respostaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(respostaLbl);
		
		this.respostaFld = new JTextField();
		this.respostaFld.setBounds(7, 74, 438, 25);
		this.respostaFld.setToolTipText("Informe a resposta para questao.");
		this.respostaFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.respostaFld.setColumns(10);
		this.add(this.respostaFld);
		
				
		// Botao Salvar
		this.salvarBtn = new JButton("Salvar");
		this.salvarBtn.setBounds(190, 241, 100, 32);
		this.salvarBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.salvarBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (FaqEdit.this.validateFields()) {
					Faq faq = FaqEdit.this.toModel();
					if (FaqEdit.this.editMode) {
						new GenericFacade().updateFaq(faq);
					} else {
						new GenericFacade().insertFaq(faq);
					}

					if (FaqEdit.this.doneEvent != null) {
						FaqEdit.this.doneEvent.actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, e.getActionCommand()));
					}
					
				}
			}
		});
		this.add(this.salvarBtn);
		
	}

}
//#endif
//#endif
//#endif

