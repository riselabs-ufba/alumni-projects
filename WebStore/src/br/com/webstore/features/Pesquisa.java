//#if ${Event} == "T"
package br.com.webstore.features;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.webstore.facade.CategoriaFacade;
import br.com.webstore.facade.ProdutoFacade;
import br.com.webstore.model.Produto;

public class Pesquisa extends JPanel{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "Pesquisa";
	
	public List<br.com.webstore.model.Categoria> categorias;
	public String[] items;
	
	public Pesquisa() {
		JComboBox combo = new JComboBox();
	    /*
		//items[0] = "Todas";
		categorias = new CategoriaFacade().findCategoria();
		for(int i=0;i<categorias.size();i++){
			combo.addItem(categorias.get(i));
			//items[i+1] = categorias.get(i).getDescricao();
		}
	    */
	    
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
//#endif
