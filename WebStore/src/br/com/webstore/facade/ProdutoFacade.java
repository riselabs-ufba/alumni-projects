package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.ProdutoDao;
import br.com.webstore.model.Produto;

public class ProdutoFacade implements IProdutoFacade {

	// @Inject
    private ProdutoDao produtoDataProvider;
	
	@Override
	public Produto insertProduto(Produto produto) {
		return produtoDataProvider.insert(produto);
	}

	@Override
	public void updateProduto(Produto produto) {
		produtoDataProvider.update(produto);
		
	}

	@Override
	public List<Produto> findProduto(Produto query) {
		return produtoDataProvider.getList();
	}

}
