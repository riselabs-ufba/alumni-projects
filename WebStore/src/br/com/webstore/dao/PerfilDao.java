//#if ${Event} == "T"
package br.com.webstore.dao;

import br.com.webstore.model.Perfil;

public class PerfilDao extends GenericDao<Perfil, Integer>{
	
	public PerfilDao() {
		super(Perfil.class);
	}

}
//#endif