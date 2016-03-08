package br.com.webstore.facade;

import java.util.List;


import br.com.webstore.dao.VendaProdutoDao;
import br.com.webstore.model.VendaProduto;

public class VendaProdutoFacade implements IVendaProdutoFacade{
	
	// @Inject
	private VendaProdutoDao vendaProdutoDao;
	
	@Override
	public VendaProduto insertVendaProduto(VendaProduto vendaProduto) {
		return vendaProdutoDao.insert(vendaProduto);
	}

	@Override
	public void updateVendaProduto(VendaProduto vendaProduto) {
		vendaProdutoDao.update(vendaProduto);		
	}

	@Override
	public List<VendaProduto> findVendaProduto(VendaProduto vendaProduto) {
		return vendaProdutoDao.getList();
	}
	

}
