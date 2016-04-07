//#if ${Venda} == "T"
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.Venda;

public class VendaDao extends GenericDao<Venda, Integer>{
	
	public VendaDao(EntityManager entityManager) {
		super(entityManager, Venda.class);
	}

}
//#endif