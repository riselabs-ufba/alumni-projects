
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.VendaProdutoEmbbed;

public class VendaProdutoEmbbedDao extends GenericDao<VendaProdutoEmbbed, Integer>{
	
	public VendaProdutoEmbbedDao(EntityManager entityManager) {
		super(entityManager, VendaProdutoEmbbed.class);
	}

}
