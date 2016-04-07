//#if ${StatusUsuario} == "T"
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.StatusUsuario;

public class StatusUsuarioDao extends GenericDao<StatusUsuario, Integer>{
	
	public StatusUsuarioDao(EntityManager entityManager) {
		super(entityManager, StatusUsuario.class);
	}

}
//#endif
