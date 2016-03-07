package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.StatusVendaDao;
import br.com.webstore.model.StatusVenda;

public class StatusVendaFacade implements IStatusVendaFacade {

	// @Inject
	private StatusVendaDao statusVendaDataProvider;	
	
	@Override
	public StatusVenda insertStatusVenda(StatusVenda statusVenda) {
		return statusVendaDataProvider.insert(statusVenda);
	}

	@Override
	public void updateStatusVenda(StatusVenda statusVenda) {
		statusVendaDataProvider.update(statusVenda);		
	}

	@Override
	public List<StatusVenda> findStatusVenda(StatusVenda query) {
		return statusVendaDataProvider.getList();
	}

}
