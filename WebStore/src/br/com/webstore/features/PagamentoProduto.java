/**
 * 
 */
package br.com.webstore.features;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

import javax.swing.*;

/**
 * @author webstore
 *
 */
public class PagamentoProduto  extends JFrame{

	private JScrollPane scrollPane;
	private JRadioButton rbFormaDePamento;
	
	public PagamentoProduto(final GenericFacade gfacade, final Usuario usuario, final String valorTotal) {
			
		this.setTitle("Pagamento - teste");
		this.setSize(600, 500);
		
		
		JLabel lblTituloValor = new JLabel("Valor Total");				
		JLabel lblValor = new JLabel(valorTotal);
		
		JLabel lbFormaPagamento = new JLabel("Forma de Pagamento");
		JRadioButton cartaoCredito = new JRadioButton("Cartao de Crédito", false);
		JRadioButton boletoBancario = new JRadioButton("Boleto Bancário", false);
		JRadioButton cupom = new JRadioButton("Cupom", false);
		
		JLabel lbEmbalarParaPresente = new JLabel("Embalar para Presente");
		JRadioButton rdBtEmbalarParaPresente = new JRadioButton("Embalar", false);

		
		JButton btFinalizarCompra = new JButton("Finalizar Compra");
		btFinalizarCompra .addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (valorTotal!= null) {
					JOptionPane.showMessageDialog(null, "Escolha uma forma de Pagamento!");
				} else {
					
					FinalizarCompra pd = new FinalizarCompra(gfacade, usuario,"");
					
					final JDialog frame = new JDialog();
					
					frame.setModal(true);
					frame.setResizable(false);
					frame.setBounds(500, 300, 460, 200);
					frame.setVisible(true);
				}
				
			}
		});
		
/*		this.scrollPane = new JScrollPane();
		scrollPane.add(lblTituloValor);
		scrollPane.add(lblValor);
		*/
		//this.scrollPane.setBounds(10, 10, 480, 99);
		//this.add(this.scrollPane);
		//this.scrollPane.setViewportView(this.table);
		
		lblTituloValor.setBounds(15, 15, 100, 50);
		lblValor.setBounds(15, 50, 100, 50);
		lbFormaPagamento.setBounds(30,50,100,50);
		cartaoCredito.setBounds(40,50,100,50);
		boletoBancario.setBounds(60,50,100,50);
		cupom.setBounds(80,50,100,50);
		lbEmbalarParaPresente.setBounds(200,50,100,50);
		rdBtEmbalarParaPresente.setBounds(230,50,100,50);		
		btFinalizarCompra.setBounds(400, 250, 100, 50);
		
		
		
		this.setLayout(new FlowLayout());
		this.add(lblTituloValor);
		this.add(lblValor);
		this.add(lbFormaPagamento);
		this.add(cartaoCredito);
		this.add(boletoBancario);
		this.add(cupom);
		this.add(lbEmbalarParaPresente);
		this.add(rdBtEmbalarParaPresente);
		this.add(btFinalizarCompra);

		
		this.setVisible(true);
	}
		
	
}
