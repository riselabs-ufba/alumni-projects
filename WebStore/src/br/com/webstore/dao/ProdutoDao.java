/**
 * 
 */
package br.com.webstore.dao;

import br.com.webstore.model.Produto;

/**
 * @author webstore
 *
 */
public class ProdutoDao extends GenericDao<Produto, Integer> {

	/**
	 * Construtor
	 */
	public ProdutoDao() {
		super(Produto.class);
	}
}