//#if ${FAQ} == "T"
package br.com.webstore.features;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FAQ extends JPanel {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 5857352359748798118L;
	
	public static final String NAME = "FAQ";

	/**
	 * Create the panel.
	 */
	public FAQ() {
		setLayout(null);
	
		JTextArea txtrLorenIpsum = new JTextArea();
		JScrollPane sp = new JScrollPane();
		txtrLorenIpsum.setBackground(Color.WHITE);
		txtrLorenIpsum.setBounds(88, 64, 278, 187);
		txtrLorenIpsum.setText("Lorem ipsum dolor sit amet, \r\npro ea affert bonorum, \r\nvis deleniti similique \r\nconceptam ea. \r\nAeque constituto sed ut, animal \r\naliquip maiorum in usu. Mea ex error \r\nancillae adversarium, mel facer qualisque democritum ea. \r\nMei ex essent feugiat, facilisis concludaturque vis ei. \r\nNominavi patrioque ne has. \r\nNam ea atqui adversarium, \r\nadmodum fuisset in mel.");
		add(txtrLorenIpsum);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(362, 64, 17, 187);
		add(scrollBar);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(178, 266, 89, 23);
		add(btnOk);
		
		JLabel lblFaq = new JLabel("FAQ");
		lblFaq.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblFaq.setBounds(177, -15, 175, 95);
		add(lblFaq);
		
		JFrame f = new JFrame();
		f.getContentPane().add(sp);

	}
}
//#endif
