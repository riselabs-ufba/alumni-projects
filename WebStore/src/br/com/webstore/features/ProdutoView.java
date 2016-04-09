//#if ${Produto} == "T"

package br.com.webstore.features;

import javax.swing.JPanel;
import javax.swing.JTable;
import br.com.webstore.dao.ProdutoDao;
import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Usuario;
import br.com.webstore.model.Venda;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.awt.event.ActionEvent;


/**
 * @author webstore
 *
 */
public class ProdutoView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NAME = null;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ProdutoView(final GenericFacade gfacade, final Usuario usuarioLogado) {
		setLayout(null);		

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new ProdutoDao(null).getProdutos());
		table.setBounds(22, 24, 361, 76);
		add(table);
		
		JButton btnAdicionarAoCarrinho = new JButton("Adicionar ao Carrinho");
		btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow()>=0){
					Venda venda = toModel(gfacade, usuarioLogado, table.getValueAt(table.getSelectedRow(),2).toString());
					Venda retVenda = new GenericFacade().insertVenda(venda);
					JOptionPane.showMessageDialog(null, "Venda "+ retVenda.getId());
					JOptionPane.showMessageDialog(null, "Produto: "+table.getValueAt(table.getSelectedRow(),  0) +" inserido no carrinho com sucesso!");
				}else{
					JOptionPane.showMessageDialog(null, "Selecione pelo menos um produto para adicionar ao carrinho!");
				}
			}
		});
		btnAdicionarAoCarrinho.setBounds(22, 114, 135, 23);
		add(btnAdicionarAoCarrinho);
	}
	public Venda toModel(final GenericFacade gfacade, Usuario user, String valor) {
		Venda venda = new Venda(); 
		BigDecimal val = new BigDecimal(valor);
		venda.setId(1);
		
		venda.setDataVenda(new Date());
		venda.setFormaPagamento(gfacade.findFormaPagamentoByNome("Boleto Bancário"));
		venda.setStatusVenda(gfacade.findStatusVendabyName("Carrinho"));
		venda.setValorTotal(val);
		venda.setUsuarioVenda(user);
		venda.setUsuarioCupom(null);

		return venda;
	}
	
}
//#endif