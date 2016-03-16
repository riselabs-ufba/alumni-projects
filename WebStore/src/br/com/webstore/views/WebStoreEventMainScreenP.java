/**
 * 
 */
package br.com.webstore.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import br.com.webstore.features.CarrinhoCheckout;
import br.com.webstore.features.Categoria;
import br.com.webstore.features.FAQ;
import br.com.webstore.features.ProdutoView;
import br.com.webstore.features.BugTrackView;

/**
 * @author webstore
 *
 */
public class WebStoreEventMainScreenP extends JPanel {

	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = -2884618217124578987L;

	private static final String APPLICATION_NAME = "WebStore";
	
	private static final int WIDTH_SCREEN = 600;
	private static final int HEIGHT_SCREEN = 400;
	
	JFrame mainFrame = new JFrame(APPLICATION_NAME);
	
	public WebStoreEventMainScreenP() {
		JTabbedPane panelTab = new JTabbedPane();
		
		
		//#if ${Event} == "T"
		panelTab.addTab(Categoria.NAME, new Categoria());
		//#endif
		
		//#if ${Event} == "T"
		panelTab.addTab(FAQ.NAME, new FAQ());
		//#endif
		
		//#if ${Event} == "F"
		panelTab.addTab(ProdutoView.NAME, new ProdutoView());
		//#endif
		
		//#if ${Event} == "F"
		panelTab.addTab(CarrinhoCheckout.NAME, new CarrinhoCheckout());
		//#endif
		
		//#if ${Event} == "T"
		panelTab.addTab(BugTrackView.NAME, new BugTrackView());
		//#endif
				
		//Init the selected tab
		panelTab.setSelectedIndex(0);
		
		//Create a grid layout with 1 column and 1 row
		setLayout(new GridLayout(1, 1));
		
		//Setter tabs in the main panel
		add(panelTab);
	}
	
	/**
	 * Return the mainFrame 
	 * @return the mainFrame
	 */
	public JFrame getMainFrame() {
		return mainFrame;
	}

	/**
	 * Setter the mainFrame
	 * @param mainFrame the mainFrame to set
	 */
	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public static void main(String[] args) {
		WebStoreEventMainScreenP mainScreen = new WebStoreEventMainScreenP();
		
		mainScreen.getMainFrame().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		mainScreen.getMainFrame().getContentPane().add(mainScreen,BorderLayout.CENTER);
		mainScreen.getMainFrame().setSize(WIDTH_SCREEN, HEIGHT_SCREEN);
		mainScreen.getMainFrame().setVisible(true);
	}
}
