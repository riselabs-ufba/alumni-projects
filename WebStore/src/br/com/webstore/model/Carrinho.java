/**
 * 
 */
package br.com.webstore.model;

import java.util.HashMap;

/**
 * @author webstore
 *
 */
public class Carrinho {
	
	private HashMap<Produto, Integer> mapCarrinho;
	private static Carrinho instance;
	/**
	 * 
	 */
	public static Carrinho getInstance(){
		if(instance == null)
			instance = new Carrinho();
		
		return instance;
	}
	
	public Carrinho() {
		mapCarrinho = new HashMap<>();
	}

	/**
	 * Return the mapCarrinho 
	 * @return the mapCarrinho
	 */
	public HashMap<Produto, Integer> getMapCarrinho() {
		return mapCarrinho;
	}

	/**
	 * Setter the mapCarrinho
	 * @param mapCarrinho the mapCarrinho to set
	 */
	public void setMapCarrinho(HashMap<Produto, Integer> mapCarrinho) {
		this.mapCarrinho = mapCarrinho;
	}

	/**
	 * Setter the mapCarrinho
	 * @param mapCarrinho the mapCarrinho to set
	 */
	public void putMapCarrinho(Produto produto, int quantidade) {
		this.mapCarrinho.put(produto, quantidade);
	}
	
	

}
