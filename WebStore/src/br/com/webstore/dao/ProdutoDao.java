//#if ${Produto} == "T"

package br.com.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.webstore.model.Produto;


public class ProdutoDao extends GenericDao<Produto, Integer> {
	
	public ProdutoDao(EntityManager entityManager) {
		super(entityManager, Produto.class);
	}

	public List<Produto> findByNome(String nome) {
		entityManager.clear();
		TypedQuery<Produto> query = this.entityManager.createQuery("from Produto p where p.descricao like :descricao", Produto.class);
		query.setParameter("descricao", nome + "%");
		return query.getResultList();
	}
	
	public List<Produto> getProdutos(){
		TypedQuery<Produto> query = this.entityManager.createQuery("from Produto", Produto.class);
		return query.getResultList();
	}
}
//#endif