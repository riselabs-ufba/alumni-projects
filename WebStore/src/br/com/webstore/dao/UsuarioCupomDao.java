//#if ${Event} == "T"
package br.com.webstore.dao;


import br.com.webstore.model.UsuarioCupom;

public class UsuarioCupomDao extends GenericDao<UsuarioCupom, Integer>{

	public UsuarioCupomDao() {
		super(UsuarioCupom.class);
	}
}
//#endif