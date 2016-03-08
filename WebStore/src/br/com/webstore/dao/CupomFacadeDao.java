package br.com.webstore.dao;

import br.com.webstore.model.Cupom;

public class CupomFacadeDao extends GenericDao<Cupom, Integer>{
	public CupomFacadeDao() {
		super(Cupom.class);
	}

}
