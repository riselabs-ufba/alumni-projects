package br.com.webstore.dao;

import br.com.webstore.model.Mensagem;

public class MensagemFacadeDao extends GenericDao<Mensagem, Integer> {
	public MensagemFacadeDao() {
		super(Mensagem.class);
	}
}
