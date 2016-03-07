package br.com.webstore.facade;

import java.util.List;


import br.com.webstore.dao.CategoriaDao;
import br.com.webstore.model.Categoria;

public class CategoriaFacade implements ICategoriaFacade{
	
	// @Inject
	private CategoriaDao categoriaDataProvider;
	
	@Override
	public Categoria insertCategoria(Categoria categoria) {
		return categoriaDataProvider.insert(categoria);
	}

	@Override
	public void saveCategoria(Categoria categoria) {
		categoriaDataProvider.insert(categoria);		
	}

	@Override
	public List<Categoria> findCategoria(Categoria categoria) {
		return categoriaDataProvider.getList();
	}
	

}
