//#if ${CarrinhoCompras} == "T"
package br.com.webstore.features;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Usuario;
import br.com.webstore.model.Venda;

/**
 * @author webstore
 *
 */
public class PagamentoCupom extends JFrame {

	private static final long serialVersionUID = 7046684960720630980L;
	private JFormattedTextField cupomField;

	public PagamentoCupom(final GenericFacade gfacade, final Usuario usuario, String formaDePagamento, final String valorTotal) {
		final JDialog frame = new JDialog();
		this.setLayout(null);	
		this.setTitle("Cupom");
		this.setSize(400, 300);
		PagamentoCupom.this.setLocationRelativeTo(null);
		
		JLabel lbCumpom = new JLabel("Cupom: ");		
		lbCumpom.setBounds(2,10,200,15);
		this.add(lbCumpom);
		
		this.cupomField = new JFormattedTextField();
		this.cupomField.setBounds(60, 10, 219, 25);
		this.cupomField.setToolTipText("Informe o numero do cartao.");
		this.cupomField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cupomField.setColumns(10);
		this.add(this.cupomField);
		
		JButton btFinalizarCompra = new JButton("Finalizar Compra");
		btFinalizarCompra.setBounds(110,210,160,23);
		this.add(btFinalizarCompra);
		btFinalizarCompra.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//falta a validação Acredito que essa informações seriam suficiente. 
				Venda v = new Venda();
				Calendar c = Calendar.getInstance(); 					
				v.setDataVenda(c.getTime());
				v.setUsuarioVenda(usuario);
				//formaDePagamento só que aqui é uma String
				v.setValorTotal(new BigDecimal(valorTotal));
				gfacade.insertVenda(v);		
			}
		});
		
		
		this.setVisible(true);
	}


}
//#endif