package br.com.webstore.facade;


import java.util.List;

import br.com.webstore.model.Categoria;

public interface ICategoriaFacade {
	
	public Categoria insertCategoria(Categoria categoria);

	public void updateCategoria(Categoria categoria);
	
	public List<Categoria> findCategoria();

	public List<Categoria> getList();

}
