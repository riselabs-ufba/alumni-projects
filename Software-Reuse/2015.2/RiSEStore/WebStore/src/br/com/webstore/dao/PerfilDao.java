//#if ${Usuario} == "T"
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.Perfil;

public class PerfilDao extends GenericDao<Perfil, Integer>{
	
	public PerfilDao(EntityManager entityManager) {
		super(entityManager, Perfil.class);
	}

}
//#endif