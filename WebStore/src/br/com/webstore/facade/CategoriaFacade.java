package br.com.webstore.facade;

import java.util.List;


import br.com.webstore.dao.CategoriaDao;
import br.com.webstore.model.Categoria;

public class CategoriaFacade implements ICategoriaFacade{
	
	// @Inject
	private CategoriaDao categoriaDataProvider = new CategoriaDao();
	
	@Override
	public Categoria insertCategoria(Categoria categoria) {
		return categoriaDataProvider.insert(categoria);
	}

	@Override
	public void updateCategoria(Categoria categoria) {
		categoriaDataProvider.update(categoria);		
	}

	@Override
	public List<Categoria> findCategoria() {
		return categoriaDataProvider.getList();
	}
	

}
