package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.Produto;

public interface IProdutoFacade {

	public Produto insertProduto(Produto produto);

	public void updateProduto(Produto produto);
	
	public List<Produto> findProduto(Produto query);

	/**
	 * @param nome
	 * @return
	 */
	List<Produto> findProduto(String nome);

	/**
	 * @param id
	 * @return
	 */
	Produto getById(int id);

	/**
	 * @param id
	 */
	void removerProduto(int id);	
	
	
}
