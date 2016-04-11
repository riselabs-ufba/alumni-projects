/**
 * 
 */
package br.com.webstore.features;

import javax.swing.JFrame;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Usuario;

import java.awt.*; 
import javax.swing.*;

/**
 * @author webstore
 *
 */
public class PagamentoProduto  extends JFrame{
	
	
/*	private static final int WIDTH_SCREEN = 600;
	private static final int HEIGHT_SCREEN = 400;*/
	
	
	/**
	 * 
	 */
	public PagamentoProduto(final GenericFacade gfacade, final Usuario usuario, String valorTotal) {
		this.setTitle("Pagamento");
		this.setSize(600, 500);
		
		JLabel lblTituloValor = new JLabel("Valor Total");
		lblTituloValor.setBounds(2, 0, 100, 50);
		
		JLabel lblValor = new JLabel(valorTotal);
		lblValor.setBounds(2, 0, 100, 50);
		
		this.add(lblTituloValor);
		this.add(lblValor);
		
		
		this.setVisible(true);
	}

	
	
	
	/*mainScreen.getMainFrame().getContentPane().add(mainScreen,BorderLayout.CENTER);
	mainScreen.getMainFrame().setSize(WIDTH_SCREEN, HEIGHT_SCREEN);
	mainScreen.getMainFrame().setVisible(true);
	mainScreen.getMainFrame().setLocationRelativeTo(null);
	*/

}
