//#if ${CarrinhoCheckout} == "T"
package br.com.webstore.features;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import br.com.webstore.dao.CarrinhoDao;
import br.com.webstore.dao.ProdutoDao;
import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.StatusVenda;
import br.com.webstore.model.Usuario;
import br.com.webstore.model.Venda;

import java.sql.*;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CarrinhoCheckout extends JPanel {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 8737213081913021625L;
	
	public static final String NAME = "Carrinho";

	/**
	 * Create the panel.
	 */
	Connection connection = null;
	private JTable table;
	public CarrinhoCheckout(final GenericFacade gfacade, final Usuario usuario) {
		setLayout(null);
		//List<Venda> venda = gfacade.findVendaByUser(usuario,  gfacade.findStatusVendabyName("Carrinho"));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//table.setModel(new CarrinhoDao(null).getCarrinho(venda.get(0)));
		table.setBounds(22, 24, 361, 76);
		add(table);
	}
}
//#endif
