//#if ${Categoria} == "T"
package br.com.webstore.features;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Categoria;

public class CategoriaEdit extends JPanel {

	private static final long serialVersionUID = -5463321145565350625L;

	public static final String NAME = "Categoria";
	
	private boolean editMode = false;
	private Integer Id;
	private NumberFormat numeroForamat = NumberFormat.getIntegerInstance();
	private JTextField descricaoFld;
	private JFormattedTextField numeroFld;
	private JButton salvarBtn;
	private ActionListener doneEvent;
	
	public Categoria toModel() {
		Categoria categoria = new Categoria();
		
		if (this.editMode) {
			categoria.setId(this.Id);
			
		}
		
		categoria.setDescricao(this.descricaoFld.getText());
	
		
		return categoria;
	}
	
	public boolean validateFields() {
		
		if ("".equals(this.descricaoFld.getText())) {
			JOptionPane.showMessageDialog(null, "Descricao deve ser preenchido");
			return false;
		}

		if (((Number) this.numeroFld.getValue()).intValue() == 0) {
			JOptionPane.showMessageDialog(null, "Codigo deve ser preenchido ");
			return false;
		}
		
		
		
		return true;
	}
	
	public void setDoneEvent(ActionListener doneEvent) {
		this.doneEvent = doneEvent;
	}
	
	public CategoriaEdit(Integer id) {
		this();//falta criar o construtor
		this.editMode = true;
		this.Id = id;
		Categoria categoria = new GenericFacade().getById(this.Id);		
		this.descricaoFld.setText(categoria.getDescricao());
	}



	
	
	
	public CategoriaEdit() {
		this.setLayout(null);


		JLabel descricaoLbl = new JLabel("Descri��o");
		descricaoLbl.setBounds(7, 16, 100, 15);
		descricaoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(descricaoLbl);
		
		this.descricaoFld = new JTextField();
		this.descricaoFld.setBounds(7, 29, 438, 25);
		this.descricaoFld.setToolTipText("Informe a descricao.");
		this.descricaoFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.descricaoFld.setColumns(10);
		this.add(this.descricaoFld);


		JLabel codigoLbl = new JLabel("Codigo");
		codigoLbl.setBounds(7, 61, 100, 15);
		codigoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(codigoLbl);
		this.numeroFld = new JFormattedTextField(this.numeroForamat);
		
		this.numeroFld.setBounds(7, 74, 438, 25);
		this.numeroFld.setToolTipText("Informe o codigo");
		this.numeroFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.numeroFld.setColumns(10);
		this.add(this.numeroFld);
		
		this.numeroFld.setValue(0);
		this.numeroForamat.setMaximumFractionDigits(0);		
		
		

		this.salvarBtn = new JButton("Salvar");
		this.salvarBtn.setBounds(7, 241, 100, 32);
		this.salvarBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.salvarBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (CategoriaEdit.this.validateFields()) {
					Categoria categoria = CategoriaEdit.this.toModel();
					if (CategoriaEdit.this.editMode) {
						new GenericFacade().updateCategoria(categoria);
					} else {
						new GenericFacade().insertCategoria(categoria);
					}

					if (CategoriaEdit.this.doneEvent != null) {
						CategoriaEdit.this.doneEvent.actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, e.getActionCommand()));
					}
					
				}
			}
		});
		this.add(this.salvarBtn);
		
	}

	


}
//#endif