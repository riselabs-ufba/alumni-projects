//#if ${Cupom} == "T"
package br.com.webstore.dao;

import br.com.webstore.model.Cupom;

public class CupomDao extends GenericDao<Cupom, Integer>{
	public CupomDao() {
		super(Cupom.class);
	}

}
//#endif