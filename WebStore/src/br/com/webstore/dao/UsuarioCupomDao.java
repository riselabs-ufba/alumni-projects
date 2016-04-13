//#if ${Usuario} == "T"
package br.com.webstore.dao;


import javax.persistence.EntityManager;

import br.com.webstore.model.UsuarioCupom;

public class UsuarioCupomDao extends GenericDao<UsuarioCupom, Integer>{

	public UsuarioCupomDao(EntityManager entityManager) {
		super(entityManager, UsuarioCupom.class);
	}
}

//#endif