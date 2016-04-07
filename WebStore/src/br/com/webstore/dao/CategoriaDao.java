//#if ${Categoria} == "T"
package br.com.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.webstore.model.Categoria;


public class CategoriaDao extends GenericDao<Categoria, Integer>{
	
	public CategoriaDao(EntityManager entityManager) {
		super(entityManager, Categoria.class);
	}
	public List<Categoria> findByNome(String nome) {
		TypedQuery<Categoria> query = this.entityManager.createQuery("from Categoria c where c.descricao like :descricao", Categoria.class);
		query.setParameter("descricao", nome + "%");
		return query.getResultList();
	}

}
//#endif