//#if ${Produto} == "T"

package br.com.webstore.features;

import javax.swing.JPanel;
import javax.swing.JTable;
import br.com.webstore.dao.ProdutoDao;
import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Produto;
import br.com.webstore.model.Usuario;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * @author webstore
 *
 */
public class ProdutoView extends JPanel {

	public static final String NAME = null;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public ProdutoView(final GenericFacade gfacade, final Usuario usuarioLogado) {
		setLayout(null);		

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(new ProdutoDao(null).getProdutos());
		table_1.setBounds(22, 24, 361, 76);
		add(table_1);
		
		JButton btnAdicionarAoCarrinho = new JButton("Adicionar ao Carrinho");
		btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table_1.getSelectedRow()>=0) 
					JOptionPane.showMessageDialog(null, "Produto: "+table_1.getValueAt(table_1.getSelectedRow(),  table_1.getSelectedColumn()) +" inserido no carrinho com sucesso!");
			}
		});
		btnAdicionarAoCarrinho.setBounds(22, 114, 135, 23);
		add(btnAdicionarAoCarrinho);
	}
}
//#endif