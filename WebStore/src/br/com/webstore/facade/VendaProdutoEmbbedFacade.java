package br.com.webstore.facade;

import java.util.List;


import br.com.webstore.dao.VendaProdutoEmbbedDao;
import br.com.webstore.model.VendaProdutoEmbbed;

public class VendaProdutoEmbbedFacade implements IVendaProdutoEmbbedFacade{
	
	// @Inject
	private VendaProdutoEmbbedDao vendaProdutoEmbbedDao;
	
	@Override
	public VendaProdutoEmbbed insertVendaProdutoEmbbed(VendaProdutoEmbbed vendaProdutoEmbbed) {
		return vendaProdutoEmbbedDao.insert(vendaProdutoEmbbed);
	}

	@Override
	public void updateVendaProdutoEmbbed(VendaProdutoEmbbed vendaProdutoEmbbed) {
		vendaProdutoEmbbedDao.update(vendaProdutoEmbbed);		
	}

	@Override
	public List<VendaProdutoEmbbed> findVendaProdutoEmbbed(VendaProdutoEmbbed vendaProdutoEmbbed) {
		return vendaProdutoEmbbedDao.getList();
	}
	

}
