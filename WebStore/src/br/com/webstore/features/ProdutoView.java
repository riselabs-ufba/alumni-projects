//#if ${Produto} == "T"

package br.com.webstore.features;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

/**
 * @author webstore
 *
 */
public class ProdutoView extends JPanel {

	public static final String NAME = null;

	/**
	 * Create the panel.
	 */
	public ProdutoView() {
		setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto 1");
		lblProduto.setBounds(130, 11, 196, 55);
		//lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 35));
		add(lblProduto);
		
		JLabel lblasdf = new JLabel("Imagem");
		Image img = new ImageIcon(this.getClass().getResource("/image.png")).getImage();
		lblasdf.setIcon(new ImageIcon(img));
		lblasdf.setBorder(UIManager.getBorder("FormattedTextField.border"));
		lblasdf.setBounds(275, 63, 138, 21);
		add(lblasdf);
		
		JButton btnNewButton = new JButton("Adicionar ao carrinho");
		btnNewButton.setBounds(275, 119, 138, 41);
		add(btnNewButton);
		
		JLabel label = new JLabel("Imagem");
		label.setBorder(UIManager.getBorder("FormattedTextField.border"));
		label.setBounds(45, 63, 192, 97);
		add(label);
		
		JLabel lblLorenIpsum = new JLabel("loren ipsum dolor sit");
		lblLorenIpsum.setBounds(295, 95, 102, 13);
		add(lblLorenIpsum);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Lorem ipsum dolor sit amet, \r\npro ea affert bonorum, \r\nvis deleniti similique \r\nconceptam ea. \r\nAeque constituto sed ut, animal \r\naliquip maiorum in usu. Mea ex error \r\nancillae adversarium, mel facer qualisque democritum ea. \r\nMei ex essent feugiat, facilisis concludaturque vis ei. \r\nNominavi patrioque ne has. \r\nNam ea atqui adversarium, \r\nadmodum fuisset in mel.");
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(33, 171, 213, 115);
		add(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(247, 171, 17, 115);
		add(scrollBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.WHITE, Color.DARK_GRAY, Color.LIGHT_GRAY));
		scrollPane.setToolTipText("1\r\n2 3 4 5 6");
		scrollPane.setBounds(275, 182, 138, 50);
		add(scrollPane);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		scrollPane.setRowHeaderView(lblCategoria);
		
		Label label_1 = new Label("Categoria 1");
		scrollPane.setViewportView(label_1);
		label_1.setForeground(UIManager.getColor("textHighlight"));
	//	label_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblMaisProdutosDesta = new JLabel("Mais produtos desta categoria:");
		lblMaisProdutosDesta.setBounds(275, 234, 165, 14);
		add(lblMaisProdutosDesta);
		
		JLabel label_2 = new JLabel("Imagem");
		label_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		label_2.setBorder(UIManager.getBorder("FormattedTextField.border"));
		label_2.setBounds(275, 259, 40, 41);
		add(label_2);
		
		JLabel label_3 = new JLabel("Imagem");
		label_3.setBorder(UIManager.getBorder("FormattedTextField.border"));
		label_3.setAlignmentY(1.0f);
		label_3.setBounds(325, 259, 40, 41);
		add(label_3);
		
		JLabel label_4 = new JLabel("Imagem");
		label_4.setBorder(UIManager.getBorder("FormattedTextField.border"));
		label_4.setAlignmentY(1.0f);
		label_4.setBounds(375, 259, 40, 41);
		add(label_4);

	}
}
//#endif
