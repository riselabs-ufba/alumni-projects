package br.com.webstore.facade;

import java.util.List;


import br.com.webstore.dao.VendaDao;
import br.com.webstore.model.Venda;

public class VendaFacade implements IVendaFacade{
	
	// @Inject
	private VendaDao vendaDao;
	
	@Override
	public Venda insertVenda(Venda venda) {
		return vendaDao.insert(venda);
	}

	@Override
	public void updateVenda(Venda venda) {
		vendaDao.update(venda);		
	}

	@Override
	public List<Venda> findCategoria(Venda venda) {
		return vendaDao.getList();
	}
	

}
