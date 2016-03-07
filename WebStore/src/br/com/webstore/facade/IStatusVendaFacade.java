package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.StatusVenda;

public interface IStatusVendaFacade {

	public StatusVenda insertStatusVenda(StatusVenda statusVenda);

	public void saveStatusVenda(StatusVenda statusVenda);
	
	public List<StatusVenda> findStatusVenda(StatusVenda query);		
	
}
