package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.ProdutoDao;
import br.com.webstore.model.Produto;

public class ProdutoFacade implements IProdutoFacade {
	
	// @Inject
	private ProdutoDao produtoDataProvider;
	
	public ProdutoFacade() {
		this.produtoDataProvider = new ProdutoDao();
	}

	@Override
	public Produto insertProduto(Produto produto) {
		return this.produtoDataProvider.insert(produto);
	}
	
	@Override
	public void updateProduto(Produto produto) {
		this.produtoDataProvider.update(produto);

	}
	
	@Override
	public List<Produto> findProduto(String nome) {
		return this.produtoDataProvider.findByNome(nome);
	}
	
	@Override
	public Produto getById(int id) {
		return this.produtoDataProvider.find(id);
	}
	
	@Override
	public void removerProduto(int id) {
		this.produtoDataProvider.remove(id);
	}
	
}
