package br.com.webstore.facade;


import java.util.List;

import br.com.webstore.model.Categoria;
import br.com.webstore.model.Produto;

public interface ICategoriaFacade {
	
	public Categoria insertCategoria(Categoria categoria);

	public void updateCategoria(Categoria categoria);
//removed
/*	
	public List<Categoria> findCategoria();

	public List<Categoria> getList();
*/
	
//add
	public List<Categoria> findCategoria(String nome);

//add
	public Categoria getById(int id);
//add	
	public void removerCategoria(int id);

}
