
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.VendaProduto;;

public class VendaProdutoDao extends GenericDao<VendaProduto, Integer>{
	
	public VendaProdutoDao(EntityManager entityManager) {
		super(entityManager, VendaProduto.class);
	}

}
