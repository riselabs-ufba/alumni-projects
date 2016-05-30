//#if ${CarrinhoCompras} == "T"
package br.com.webstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.webstore.model.StatusVenda;

public class StatusVendaDao extends GenericDao<StatusVenda, Integer>{
	
	public StatusVendaDao(EntityManager entityManager) {
		super(entityManager, StatusVenda.class);
	}

	/**
	 * @param nome
	 * @return
	 */
	public StatusVenda findByName(String nome) {
		entityManager.clear();
		TypedQuery<StatusVenda> query = this.entityManager.createQuery("from StatusVenda p where p.descricao like :descricao", StatusVenda.class);
		query.setParameter("descricao", nome + "%");
		return query.getSingleResult();
	}

}
//#endif