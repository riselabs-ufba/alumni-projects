//#if ${StatusVenda} == "T"
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.StatusVenda;

public class StatusVendaDao extends GenericDao<StatusVenda, Integer>{
	
	public StatusVendaDao(EntityManager entityManager) {
		super(entityManager, StatusVenda.class);
	}

}
//#endif