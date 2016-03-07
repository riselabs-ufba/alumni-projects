package br.com.webstore.dao;

import br.com.webstore.model.Categoria;
import br.com.webstore.model.Produto;

public class CategoriaDao extends GenericDao<Categoria, Integer>{
	
	public CategoriaDao() {
		super(Categoria.class);
	}

}
