/**
 *
 */
package br.com.webstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

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

	public List<Produto> findByNome(String nome) {
		TypedQuery<Produto> query = this.entityManager.createQuery("from Produto p where p.descricao like :descricao", Produto.class);
		query.setParameter("descricao", nome + "%");
		return query.getResultList();
	}
}