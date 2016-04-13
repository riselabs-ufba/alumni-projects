//#if ${Comunicacao} == "T"
//#if ${FAQ} == "T"
package br.com.webstore.features;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Faq;


public class FaqDetalhes extends JPanel {
	
	
	private static final long serialVersionUID = 7164319316603465493L;

	public static final String NAME = "FaqDetalhes";
	
	private boolean editMode = false;
	private Integer Id;
	
	
	private JTextField descricaoFld;
	private JTextField respostaFld;
	
	
	
	

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
	
	
	
	public FaqDetalhes(Integer id) {
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

	public FaqDetalhes() {
		this.setLayout(null);

		// Descricao
		JLabel descricaoLbl = new JLabel("Questao");
		descricaoLbl.setBounds(7, 16, 100, 15);
		descricaoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(descricaoLbl);
		
		this.descricaoFld = new JTextField();
		this.descricaoFld.setBounds(7, 29, 438, 25);
		//this.descricaoFld.setToolTipText("Informe a questao");
		this.descricaoFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.descricaoFld.setColumns(10);
		this.add(this.descricaoFld);
		this.descricaoFld.setEditable(false);

		// codigo
		JLabel respostaLbl = new JLabel("Resposta");
		respostaLbl.setBounds(7, 61, 100, 15);
		respostaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(respostaLbl);
		
		this.respostaFld = new JTextField();
		this.respostaFld.setBounds(7, 74, 438, 25);
		//this.respostaFld.setToolTipText("Informe a resposta para questao.");
		this.respostaFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.respostaFld.setColumns(10);
		this.add(this.respostaFld);
		this.respostaFld.setEditable(false);
				
		// Botao Salvar
		
		
	}

}
//#endif
//#endif

