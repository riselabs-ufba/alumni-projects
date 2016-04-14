package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.UnidadeMedida;

public class UnidadeMedidaDao extends GenericDao<UnidadeMedida, Integer>{

	public UnidadeMedidaDao(EntityManager entityManager) {
		super(entityManager, UnidadeMedida.class);
	}

}
