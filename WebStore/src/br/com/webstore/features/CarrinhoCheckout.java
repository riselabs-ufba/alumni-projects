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

import br.com.webstore.facade.GenericFacade;

import java.sql.*;
import javax.swing.JTable;

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
	public CarrinhoCheckout(final GenericFacade gfacade) {/*
		connection=sqliteConnection.dbconnector();
		setLayout(null);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(185, 266, 79, 23);
		btnConfirmar.setVerticalAlignment(SwingConstants.BOTTOM);
		add(btnConfirmar);
		
		JLabel lblCarrinho = new JLabel("Carrinho");
		lblCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblCarrinho.setBounds(134, -19, 175, 95);
		add(lblCarrinho);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 232, 403, 23);
		add(separator);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSaldo.setBounds(126, 207, 46, 14);
		add(lblSaldo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 58, 323, 146);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		try {
			String query ="select  dsProduto,vlProduto from produto";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
			
			
			
		}
		
		JTextArea textArea = new JTextArea();
		private JTable table;
		textArea.setText("_____");
		textArea.setBounds(185, 199, 73, 22);
		add(textArea);
*/
	}
}
//#endif
