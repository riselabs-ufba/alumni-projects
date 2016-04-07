package br.com.webstore.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

//import javax.faces.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import br.com.webstore.facade.GenericFacade;
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

//#if ${FaleConosco} == "T"
import br.com.webstore.features.FaleConoscoView;
//#endif

//#if ${Usuario} == "T"
import br.com.webstore.features.UsuarioInclusaoEdicao;
import br.com.webstore.features.UsuarioPesquisa;
//#endif

import br.com.webstore.model.Usuario;
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
	
	static List<Usuario> user = null;
	
	JFrame mainFrame = new JFrame(APPLICATION_NAME);

	
	public WebStoreEventMainScreenP(GenericFacade gfacade, Usuario usuarioLogado) {
		JTabbedPane panelTab = new JTabbedPane();
		
		//#if ${Usuario} == "T"
		if (usuarioLogado!=null && usuarioLogado.getPerfil().getDescricao().equals("Admin"))
			panelTab.addTab(UsuarioPesquisa.NAME, new UsuarioPesquisa(gfacade));
		//#endif
		
		//#if ${Categoria} == "T"
		if (usuarioLogado!=null && usuarioLogado.getPerfil().getDescricao().equals("Admin"))
			panelTab.addTab(CategoriaP.NAME, new CategoriaP(gfacade));
		//#endif
		
		//#if ${FAQ} == "T"
		panelTab.addTab(FaqListar.NAME, new FaqListar(gfacade));
		//#endif
		
		//#if ${Produto} == "T"
		//panelTab.addTab("Ver Produto", new ProdutoView(gfacade));
		//#endif
		
		//#if ${CarrinhoCheckout} == "T"
		panelTab.addTab(CarrinhoCheckout.NAME, new CarrinhoCheckout(gfacade));
		//#endif
		
		//#if ${Produto} == "T"
		if (usuarioLogado!=null)
			panelTab.addTab(ProdutoPesquisa.NAME, new ProdutoPesquisa(gfacade,usuarioLogado));
		//#endif
		
		//#if ${BugTrack} == "T"
		if (usuarioLogado!=null)
			panelTab.addTab(BugTrackView.NAME, new BugTrackView(gfacade,usuarioLogado));
		//#endif
		
		
		//#if ${FAQ} == "T"
		if (usuarioLogado!=null && usuarioLogado.getPerfil().getDescricao().equals("Admin"))
			panelTab.addTab(FaqPesquisa.NAME, new FaqPesquisa(gfacade));
		//#endif
		
		//#if ${FaleConosco} == "T"
		if (usuarioLogado!=null)
			panelTab.addTab(FaleConoscoView.NAME, new FaleConoscoView(usuarioLogado));
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
		GenericFacade gfacade = new GenericFacade();
		webStoreEventLogar(gfacade);
	}
	
	public static void webStoreEventLogar(final GenericFacade gfacade){
		final JDialog dlgLogin = new JDialog();
		
		dlgLogin.setModal(true);
		dlgLogin.setTitle("Logar no sistema WebStore");
		dlgLogin.setResizable(false);
		dlgLogin.setBounds(0, 0, 460, 320);
		dlgLogin.setLocationRelativeTo(null);
		final JTextField login = new JTextField(10);
		JPanel panel = new JPanel();
		panel.add(new JLabel("*Login: "));
	    panel.add(login);
	    panel.add(new JLabel("*Senha:"));

	    final JPasswordField senha = new JPasswordField(10);
	    panel.add(senha);	
		
		JButton btnLogar = new JButton("Logar");
		
		btnLogar.setBounds(6, 85, 89, 23);
		btnLogar.addActionListener(new java.awt.event.ActionListener() {
			@SuppressWarnings({ "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {
				if(login.getText().length()==0 || senha.getPassword().toString().length()==0){
					JOptionPane.showMessageDialog(null, "Campos com * sao obrigatorios.");
				}
				else{
					
					
					user = gfacade.getUsuarioByLoginSenha(login.getText(), senha.getText());
					
					if (!user.isEmpty()){
						dlgLogin.setVisible(false);
						
						WebStoreEventMainScreenP mainScreen = new WebStoreEventMainScreenP(gfacade,user.get(0));
						
						mainScreen.getMainFrame().addWindowListener(new WindowAdapter() {
							public void windowClosing(WindowEvent e) {
								System.exit(0);
							}
						});
						
						mainScreen.getMainFrame().getContentPane().add(mainScreen,BorderLayout.CENTER);
						mainScreen.getMainFrame().setSize(WIDTH_SCREEN, HEIGHT_SCREEN);
						mainScreen.getMainFrame().setVisible(true);
						mainScreen.getMainFrame().setLocationRelativeTo(null);
					}
					else{
						JOptionPane.showMessageDialog(null, "Usuario " + login.getText() + " nao encontrado ou usuario e senha incorretos!");
					}
				}
			}
		});
		
		panel.add(btnLogar);
		dlgLogin.getContentPane().add(panel);
		dlgLogin.setVisible(true);
	}
	
}