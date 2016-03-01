package br.com.webstore.features;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Pesquisa extends JPanel{

	public JPanel Pesquisa() {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel("Pesquisa");
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}
}
