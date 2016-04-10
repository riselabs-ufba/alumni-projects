/**
 * 
 */
package br.com.webstore.features;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.webstore.facade.GenericFacade;
import br.com.webstore.model.Categoria;
import br.com.webstore.model.Produto;
import br.com.webstore.model.UnidadeMedida;
import br.com.webstore.model.Usuario;
import br.com.webstore.model.Venda;
import br.com.webstore.views.WebStoreEventMainScreenP;

/**
 * @author webstore
 *
 */
public class ProdutoDetalhes extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final String NAME = "ProdutoDetalhes";
	
	private boolean editMode = false;
	private Produto produto;
	
	private JTextField codigoProduto;
	private JTextField descricaoProduto;
	private JTextField precoProduto;
	private JTextField categoriaProduto;
	private JTextField unidadeMedida;
	private Usuario user;
	private GenericFacade facade;
	/**
	 * 
	 */
	
	
	
	public ProdutoDetalhes(Integer id, final Usuario usuario, final GenericFacade gfacade) {
		this();
		this.editMode = true;
		
		Produto produto = new GenericFacade().getProdutoById(id);
		this.produto = produto;

		this.codigoProduto.setText(produto.getNumero().toString());
		this.descricaoProduto.setText(produto.getDescricao());
		this.precoProduto.setText(produto.getValor().toString());
		this.categoriaProduto.setText(produto.getCategoria().getDescricao());
		this.unidadeMedida.setText(produto.getUnidadeMedida().getDescricao());
		this.user = usuario;
		this.facade = gfacade;
		
	}
	
	
	
	public ProdutoDetalhes() {
		
		//codigo 
		JLabel CodigoLabel = new JLabel("Código");
		CodigoLabel.setBounds(2, 5, 100, 15);
		CodigoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(CodigoLabel);
		
		
		this.codigoProduto = new JTextField();
		this.codigoProduto.setBounds(2, 5, 438, 25);
		
		this.codigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.codigoProduto.setColumns(10);
		this.add(this.codigoProduto);
		this.codigoProduto.setEditable(false);
		
		
		//descricao
		JLabel descricaoLbl = new JLabel("Descrição");
		descricaoLbl.setBounds(6, 10, 100, 15);
		descricaoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(descricaoLbl);
		
		
		this.descricaoProduto = new JTextField();
		this.descricaoProduto.setBounds(6, 16, 438, 25);
		
		this.descricaoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.descricaoProduto.setColumns(10);
		this.add(this.descricaoProduto);
		this.descricaoProduto.setEditable(false);

		// Valor
		JLabel respostaLbl = new JLabel("Valor");
		respostaLbl.setBounds(10, 74, 100, 15);
		respostaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(respostaLbl);
		
		this.precoProduto = new JTextField();
		this.precoProduto.setBounds(10, 74, 438, 25);
		//this.respostaFld.setToolTipText("Informe a resposta para questao.");
		this.precoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.precoProduto.setColumns(10);
		this.add(this.precoProduto);
		this.precoProduto.setEditable(false);
		
		
		JLabel categoriaLabel = new JLabel("Categoria");
		categoriaLabel.setBounds(6, 20, 100, 15);
		categoriaLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(categoriaLabel);
		
		this.categoriaProduto = new JTextField();
		this.categoriaProduto.setBounds(9, 32, 438, 25);
		this.categoriaProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.categoriaProduto.setColumns(10);
		this.add(this.categoriaProduto);
		this.categoriaProduto.setEditable(false);
		
		JLabel unidadeDeMedidaLabel = new JLabel("Unidade de Medida:");
		unidadeDeMedidaLabel.setBounds(6, 20, 100, 15);
		unidadeDeMedidaLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(unidadeDeMedidaLabel);
		
		this.unidadeMedida = new JTextField();
		this.unidadeMedida.setBounds(9, 32, 438, 25);
		this.unidadeMedida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.unidadeMedida.setColumns(10);
		this.add(this.unidadeMedida);
		this.unidadeMedida.setEditable(false);
		
		
		JButton btnAdicionarAoCarrinho = new JButton("Adicionar ao Carrinho");
		btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarrinhoCheckout.getInstance(facade, user).criarLayout(produto);
				//WebStoreEventMainScreenP janela = WebStoreEventMainScreenP.getInstance(facade, user);
	
			}
		});
		btnAdicionarAoCarrinho.setBounds(22, 114, 135, 23);
		add(btnAdicionarAoCarrinho);
		
		
	}
	

}
