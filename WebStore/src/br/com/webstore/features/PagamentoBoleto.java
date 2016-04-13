//#if ${CarrinhoCompras} == "T"
//#if ${CarrinhoFinalizarCompras} == "T"
//#if ${PgtoBoletoBancario} == "T"
package br.com.webstore.features;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Usuario;
import br.com.webstore.model.Venda;

/**
 * @author webstore
 *
 */
public class PagamentoBoleto extends JFrame{
	
	private static final long serialVersionUID = -3494096047070175713L;

	public PagamentoBoleto(final GenericFacade gfacade, final Usuario usuario, String string, final String valorTotal) {
		final JDialog frame = new JDialog();
		this.setLayout(null);	
		this.setTitle("Boleto Bancário");
		this.setSize(400, 300);
		PagamentoBoleto.this.setLocationRelativeTo(null);
		
		JLabel lbNumeroBoleto = new JLabel("Numero do Boleto");		
		lbNumeroBoleto.setBounds(2,10,200,15);
		this.add(lbNumeroBoleto);
		
		JLabel lbValorBoleto = new JLabel("00145.87456 187845.134572 006524.115465 1 875422120000001");		
		lbValorBoleto.setBounds(0,30,300,15);
		this.add(lbValorBoleto);
		
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
				//v.setIdUsuarioCupom(null);
				v.setValorTotal(new BigDecimal(valorTotal));
				v.setStatusVenda(gfacade.findStatusVendabyName("Finalizada"));
				v.setFormaPagamento(gfacade.findFormaPagamentoByNome("Boleto Bancário"));
				gfacade.insertVenda(v);
				JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!");
				PagamentoBoleto.this.setVisible(false);
				CarrinhoCheckout.getInstance(gfacade, usuario).criarLayout(null);
			}
		});
		
		
		
		
		this.setVisible(true);
	}


}
//#endif
//#endif
//#endif