//#if ${Cupom} == "T"
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.Cupom;

public class CupomDao extends GenericDao<Cupom, Integer>{
	public CupomDao(EntityManager entityManager) {
		super(entityManager, Cupom.class);
	}

}
//#endif