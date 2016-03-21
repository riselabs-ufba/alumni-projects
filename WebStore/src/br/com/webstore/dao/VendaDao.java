//#if ${Venda} == "T"
package br.com.webstore.dao;

import br.com.webstore.model.Venda;

public class VendaDao extends GenericDao<Venda, Integer>{
	
	public VendaDao() {
		super(Venda.class);
	}

}
//#endif