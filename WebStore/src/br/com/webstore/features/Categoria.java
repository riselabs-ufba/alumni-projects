package br.com.webstore.features;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Categoria extends JPanel {
	
	private JTextField textField;
	private JScrollPane scrollPane;
	private static JTable tableList;

	private JTable table;

	/**
	 * Create the panel.
	 */
	public Categoria() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("Informe o nome da categoria.");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(57, 53, 353, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDaCategoria = new JLabel("Nome da Categoria ");
		lblNomeDaCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaCategoria.setBounds(57, 24, 124, 14);
		add(lblNomeDaCategoria);
		
		JLabel lblRelaoDeCategorias = new JLabel("Categorias");
		lblRelaoDeCategorias.setBounds(57, 140, 124, 14);
		add(lblRelaoDeCategorias);
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(57, 165, 353, 99);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JLabel lblPreenchimentoObrigatrio = new JLabel("Campos obrigat\u00F3rio.");
		lblPreenchimentoObrigatrio.setForeground(Color.RED);
		lblPreenchimentoObrigatrio.setBounds(274, 275, 136, 14);
		add(lblPreenchimentoObrigatrio);
		
		JLabel labelAterisk = new JLabel("*");
		labelAterisk.setForeground(new Color(255, 0, 0));
		labelAterisk.setBounds(165, 25, 46, 14);
		add(labelAterisk);
		
		JButton btnCadastrp = new JButton("Pesquisar");
		btnCadastrp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrp.setBounds(312, 84, 79, 23);
		add(btnCadastrp);
		
		JButton btnNewButton = new JButton("Cadastro");
		btnNewButton.setBounds(80, 84, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.setBounds(195, 84, 89, 23);
		add(btnNewButton_1);
		
	}
}

