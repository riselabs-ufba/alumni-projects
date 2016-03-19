package br.com.webstore.facade;

import java.util.List;


import br.com.webstore.dao.UnidadeMedidaDao;
import br.com.webstore.model.UnidadeMedida;

public class UnidadeMedidaFacade implements IUnidadeMedidaFacade{
	
	// @Inject
	private UnidadeMedidaDao unidadeMedidaDao;

	public UnidadeMedidaFacade() {
		unidadeMedidaDao = new UnidadeMedidaDao();
	}

	@Override
	public UnidadeMedida insertUnidadeMedida(UnidadeMedida unidadeMedida) {
		return unidadeMedidaDao.insert(unidadeMedida);
	}

	@Override
	public void updateUnidadeMedida(UnidadeMedida unidadeMedida) {
		unidadeMedidaDao.update(unidadeMedida);		
	}

	@Override
	public List<UnidadeMedida> findUnidadeMedida(UnidadeMedida unidadeMedida) {
		return unidadeMedidaDao.getList();
	}
	
	@Override
	public List<UnidadeMedida> getList() {
		return unidadeMedidaDao.getList();
	}

}
