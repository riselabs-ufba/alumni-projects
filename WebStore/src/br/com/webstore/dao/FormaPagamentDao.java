//#if ${FormaPagamento} == "T"
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.FormaPagamento;

public class FormaPagamentDao extends GenericDao<FormaPagamento, Integer> {
	public FormaPagamentDao(EntityManager entityManager) {
		super(entityManager, FormaPagamento.class);
	}

}
//#endif