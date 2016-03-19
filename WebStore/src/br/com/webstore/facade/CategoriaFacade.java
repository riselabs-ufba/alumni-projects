package br.com.webstore.facade;

import java.util.List;


import br.com.webstore.dao.CategoriaDao;
import br.com.webstore.model.Categoria;
import br.com.webstore.model.Produto;

public class CategoriaFacade implements ICategoriaFacade{
	
	// @Inject
	private CategoriaDao categoriaDataProvider;
	
	public CategoriaFacade() {
//replace		categoriaDataProvider = new CategoriaDao();
		this.categoriaDataProvider = new CategoriaDao();
	}	
	
	@Override
	public Categoria insertCategoria(Categoria categoria) {
		return this.categoriaDataProvider.insert(categoria);
//replace		return categoriaDataProvider.insert(categoria);		
	}

	@Override
	public void updateCategoria(Categoria categoria) {
//replace	categoriaDataProvider.update(categoria);		
		this.categoriaDataProvider.update(categoria);
	}

	@Override
	public List<Categoria> findCategoria(String nome) {	
//replace	public List<Categoria> findCategoria() {
//		return categoriaDataProvider.getList();
		return this.categoriaDataProvider.findByNome(nome);
	}
	

//add	
	
	@Override
	public Categoria getById(int id) {
		return this.categoriaDataProvider.find(id);
	}
	
	
	@Override
	public void removerCategoria(int id) {
		this.categoriaDataProvider.remove(id);
	}
	public List<Categoria> getList() {
		return categoriaDataProvider.getList();
	}

	
}
