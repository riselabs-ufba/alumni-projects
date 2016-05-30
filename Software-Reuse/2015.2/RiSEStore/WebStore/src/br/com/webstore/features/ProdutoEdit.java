//#if ${Produto} == "T"
package br.com.webstore.features;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Produto;
import br.com.webstore.model.UnidadeMedida;

public class ProdutoEdit extends JPanel {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5464321145565350625L;

	public static final String NAME = "Produto";
	
	private boolean editMode = false;
	private Integer Id;
	
	private NumberFormat valorForamat = NumberFormat.getCurrencyInstance();
	private NumberFormat numeroForamat = NumberFormat.getIntegerInstance();
	
	private JTextField descricaoFld;
	private JFormattedTextField numeroFld;
	private JFormattedTextField valorFld;
	private JComboBox<UnidadeMedida> unidadeMedidaFld;
	//#if ${Categoria} == "T"
	private JComboBox<br.com.webstore.model.Categoria> categoriaFld;
	//#endif
	private JButton salvarBtn;
	
	private ActionListener doneEvent;

	public Produto toModel() {
		Produto produto = new Produto();
		
		if (this.editMode) {
			produto.setId(this.Id);
		}
		
		produto.setDescricao(this.descricaoFld.getText());
		produto.setNumero(((Number) this.numeroFld.getValue()).intValue());
		
		produto.setValor(BigDecimal.valueOf(((Number) this.valorFld.getValue()).doubleValue()));
		//#if ${Categoria} == "T"
		produto.setCategoria(this.categoriaFld.getItemAt(this.categoriaFld.getSelectedIndex()));
		//#endif
		produto.setUnidadeMedida(this.unidadeMedidaFld.getItemAt(this.unidadeMedidaFld.getSelectedIndex()));
		return produto;
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
		
		if (((Number) this.valorFld.getValue()).doubleValue() == 0.00d) {
			JOptionPane.showMessageDialog(null, "Valor deve ser preenchido ");
			return false;
		}
		
		return true;
	}
	
	public void setDoneEvent(ActionListener doneEvent) {
		this.doneEvent = doneEvent;
	}
	
	public ProdutoEdit(Integer id) {
		this();
		this.editMode = true;
		this.Id = id;
		Produto produto = new GenericFacade().getProdutoById(this.Id);
		
		this.descricaoFld.setText(produto.getDescricao());
		this.valorFld.setValue(produto.getValor());
		this.numeroFld.setValue(produto.getNumero());
		//#if ${Categoria} == "T"
		this.categoriaFld.setSelectedItem(produto.getCategoria());
		//#endif
		this.unidadeMedidaFld.setSelectedItem(produto.getUnidadeMedida());
	}
	
	/**
	 * Create the panel.
	 */
	public ProdutoEdit() {
		this.setLayout(null);

		// Descricao
		JLabel descricaoLbl = new JLabel("Descricao");
		descricaoLbl.setBounds(7, 16, 100, 15);
		descricaoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(descricaoLbl);
		
		this.descricaoFld = new JTextField();
		this.descricaoFld.setBounds(7, 29, 438, 25);
		this.descricaoFld.setToolTipText("Informe a descricao.");
		this.descricaoFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.descricaoFld.setColumns(10);
		this.add(this.descricaoFld);

		// codigo
		JLabel codigoLbl = new JLabel("Codigo");
		codigoLbl.setBounds(7, 61, 100, 15);
		codigoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(codigoLbl);
		
		this.numeroFld = new JFormattedTextField(this.numeroForamat);
		this.numeroFld.setBounds(7, 74, 438, 25);
		this.numeroFld.setToolTipText("Informe o codigo.");
		this.numeroFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.numeroFld.setColumns(10);
		this.add(this.numeroFld);
		
		this.numeroFld.setValue(0);
		this.numeroForamat.setMaximumFractionDigits(0);

		// Valor
		JLabel valorLbl = new JLabel("Valor");
		valorLbl.setBounds(7, 106, 100, 15);
		valorLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(valorLbl);
		
		this.valorFld = new JFormattedTextField(this.valorForamat);
		this.valorFld.setBounds(7, 119, 438, 25);
		this.valorFld.setToolTipText("Informe o valor.");
		this.valorFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		this.valorFld.setValue(0);
		this.valorForamat.setMaximumFractionDigits(2);
		this.valorForamat.setMinimumFractionDigits(2);
		
		this.valorFld.setColumns(10);
		this.add(this.valorFld);

		// Unidade de medida
		JLabel unidadeMedidaLbl = new JLabel("Unidade de medida");
		unidadeMedidaLbl.setBounds(7, 151, 140, 15);
		unidadeMedidaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(unidadeMedidaLbl);
		
		this.unidadeMedidaFld = new JComboBox<UnidadeMedida>();
		this.unidadeMedidaFld.setBounds(7, 164, 438, 25);
		this.unidadeMedidaFld.setToolTipText("Informe a unidade de medida");
		this.unidadeMedidaFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(this.unidadeMedidaFld);
		
		DefaultComboBoxModel<UnidadeMedida> nidadeMedidaModel = new DefaultComboBoxModel<UnidadeMedida>();
		List<UnidadeMedida> unidadeMedidaList = new GenericFacade().getListUnidadeMedida();
		for (UnidadeMedida unidadeMedida : unidadeMedidaList) {
			nidadeMedidaModel.addElement(unidadeMedida);
		}
		this.unidadeMedidaFld.setModel(nidadeMedidaModel);
		
		//#if ${Categoria} == "T"
		// Categoria
		JLabel categoriaLbl = new JLabel("Categoria");
		categoriaLbl.setBounds(7, 196, 100, 15);
		categoriaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(categoriaLbl);
		
	
		this.categoriaFld = new JComboBox<br.com.webstore.model.Categoria>();
		this.categoriaFld.setBounds(7, 209, 438, 25);
		this.categoriaFld.setToolTipText("Informe o nome da categoria.");
		this.categoriaFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(this.categoriaFld);
		
		
		List<br.com.webstore.model.Categoria> categoriaList = new GenericFacade().getListCategoria();
		DefaultComboBoxModel<br.com.webstore.model.Categoria> categoriaModel = new DefaultComboBoxModel<br.com.webstore.model.Categoria>();
		for (br.com.webstore.model.Categoria categoria : categoriaList) {
			categoriaModel.addElement(categoria);
		}
		this.categoriaFld.setModel(categoriaModel);
		//#endif
		
		// Botao Salvar
		this.salvarBtn = new JButton("Salvar");
		this.salvarBtn.setBounds(190, 241, 100, 32);
		this.salvarBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.salvarBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ProdutoEdit.this.validateFields()) {
					Produto produto = ProdutoEdit.this.toModel();
					if (ProdutoEdit.this.editMode) {
						new GenericFacade().updateProduto(produto);
					} else {
						new GenericFacade().insertProduto(produto);
					}

					if (ProdutoEdit.this.doneEvent != null) {
						ProdutoEdit.this.doneEvent.actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, e.getActionCommand()));
					}
					
				}
			}
		});
		this.add(this.salvarBtn);
		
	}

}
//#endif
