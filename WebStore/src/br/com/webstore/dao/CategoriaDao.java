package br.com.webstore.dao;

import br.com.webstore.model.Categoria;

public class CategoriaDao extends GenericDao<Categoria, Integer>{
	
	public CategoriaDao() {
		super(Categoria.class);
	}

}
