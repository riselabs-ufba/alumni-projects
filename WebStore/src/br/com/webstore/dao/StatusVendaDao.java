//#if ${Event} == "T"
package br.com.webstore.dao;

import br.com.webstore.model.StatusVenda;

public class StatusVendaDao extends GenericDao<StatusVenda, Integer>{
	
	public StatusVendaDao() {
		super(StatusVenda.class);
	}

}
//#endif