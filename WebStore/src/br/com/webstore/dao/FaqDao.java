//#if ${FAQ} == "T"
package br.com.webstore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.webstore.model.Faq;


public class FaqDao extends GenericDao<Faq, Integer>{
	
	public FaqDao() {
		super(Faq.class);
	}
	public List<Faq> findByNome(String nome) {
		TypedQuery<Faq> query = this.entityManager.createQuery("from Faq f where f.descricao like :descricao", Faq.class);
		query.setParameter("descricao", nome + "%");
		return query.getResultList();
	}

}
//#endif