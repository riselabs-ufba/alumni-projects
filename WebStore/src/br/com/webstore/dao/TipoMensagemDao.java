
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.TipoMensagem;

public class TipoMensagemDao extends GenericDao<TipoMensagem, Integer>{
	
	public TipoMensagemDao(EntityManager entityManager) {
		super(entityManager, TipoMensagem.class);
	}

}
