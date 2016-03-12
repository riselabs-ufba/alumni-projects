package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.Produto;

public interface IProdutoFacade {

	public Produto insertProduto(Produto produto);

	public void updateProduto(Produto produto);
	
//	public List<Produto> findProduto(Produto query);

	public List<Produto> findProduto(String nome);

	public Produto getById(int id);

	public void removerProduto(int id);	
	
	
}
