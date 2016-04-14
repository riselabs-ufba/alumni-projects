package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.SituacaoBug;

public class SituacaoBugDao extends GenericDao<SituacaoBug, Integer>{
	
	public SituacaoBugDao(EntityManager entityManager) {
		super(entityManager, SituacaoBug.class);
	}

}
