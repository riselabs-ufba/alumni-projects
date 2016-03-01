package br.com.webstore.features;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Pesquisa extends JPanel{

	public Pesquisa() {
		
	    String[] items = {"Todas"};
	    JComboBox combo = new JComboBox(items);
	    JTextField query = new JTextField(15);
	    JPanel panel = new JPanel(new GridLayout(0, 1));
	    add(new JLabel("Palavra-chave:"));
	    add(query);
	    add(new JLabel("Categoria:"));
	    add(combo);
	    JButton submit = new JButton("Pesquisar");
	    submit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	          //System.out.println(this..getText()) + " " + form.getText(1));
	        }
	    });
	    add(submit);
	}
}
