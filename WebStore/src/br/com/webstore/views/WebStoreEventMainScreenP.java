package br.com.webstore.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//#if ${BugTrack} == "T"
import br.com.webstore.features.BugTrackView;
//#endif
//#if ${CarrinhoCheckout} == "T"
import br.com.webstore.features.CarrinhoCheckout;
//#endif
//#if ${CategoriaP} == "T"
import br.com.webstore.features.CategoriaP;
//#endif
//#if ${FAQ} == "T"
import br.com.webstore.features.FAQ;
import br.com.webstore.features.FaqListar;
import br.com.webstore.features.FaqPesquisa;
//#endif
//#if ${Faq} == "T"


//#endif
//<<<<<<< 045456b365e7197cebeb34b5b80ae9c5ae5f16e9
import br.com.webstore.features.FaleConoscoView;
//=======

//#if ${Usuario} == "T"
import br.com.webstore.features.UsuarioInclusaoEdicao;
import br.com.webstore.features.UsuarioPesquisa;
//#endif

>>>>>>> Parte de Manter Usuario
//#if ${Produto} == "T"
import br.com.webstore.features.ProdutoPesquisa;
import br.com.webstore.features.ProdutoView;
//#endif

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
		
		//#if ${Usuario} == "T"
		panelTab.addTab(UsuarioPesquisa.NAME, new UsuarioPesquisa());
		//#endif
		
		//#if ${Categoria} == "T"
		panelTab.addTab(CategoriaP.NAME, new CategoriaP());
		//#endif
		
		//#if ${FAQ} == "T"
		panelTab.addTab(FaqListar.NAME, new FaqListar());
		//#endif
		
		//#if ${Produto} == "T"
		panelTab.addTab(ProdutoView.NAME, new ProdutoView());
		//#endif
		
		//#if ${CarrinhoCheckout} == "T"
		panelTab.addTab(CarrinhoCheckout.NAME, new CarrinhoCheckout());
		//#endif
		
		//#if ${Produto} == "T"
		panelTab.addTab(ProdutoPesquisa.NAME, new ProdutoPesquisa());
		//#endif
		
		//#if ${BugTrack} == "T"
		panelTab.addTab(BugTrackView.NAME, new BugTrackView());
		//#endif
		
		
		//#if ${FaleConosco} == "T"
		panelTab.addTab(FaqPesquisa.NAME, new FaqPesquisa());
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

