
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.Endereco;

public class EnderecoDao extends GenericDao<Endereco, Integer>{
	public EnderecoDao(EntityManager entityManager) {
		super(entityManager, Endereco.class);
	}
}
