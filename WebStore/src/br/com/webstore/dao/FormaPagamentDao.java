//#if ${FormaPagamento} == "T"
package br.com.webstore.dao;



import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.webstore.model.FormaPagamento;

public class FormaPagamentDao extends GenericDao<FormaPagamento, Integer> {
	public FormaPagamentDao(EntityManager entityManager) {
		super(entityManager, FormaPagamento.class);
	}
	
	public FormaPagamento findByNome(String nome) {
		entityManager.clear();
		TypedQuery<FormaPagamento> query = this.entityManager.createQuery("from FormaPagamento p where p.descricao like :descricao", FormaPagamento.class);
		query.setParameter("descricao", nome + "%");
		return query.getSingleResult();
	}
}
//#endif