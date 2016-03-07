package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.Produto;

public interface IProdutoFacade {

	public Produto insertProduto(Produto produto);

	public void saveProduto(Produto produto);
	
	public List<Produto> findProduto(Produto query);	
	
	
}
