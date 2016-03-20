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

public class CarrinhoCheckout extends JPanel {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 8737213081913021625L;
	
	public static final String NAME = "Carrinho";

	/**
	 * Create the panel.
	 */
	public CarrinhoCheckout() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("1\r\n2 3 4 5 6");
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.WHITE, Color.DARK_GRAY, Color.LIGHT_GRAY));
		scrollPane.setBounds(49, 74, 337, 116);
		add(scrollPane);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSaldo.setBounds(126, 207, 46, 14);
		add(lblSaldo);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("_____");
		textArea.setBounds(185, 199, 73, 22);
		add(textArea);

	}
}
//#endif
