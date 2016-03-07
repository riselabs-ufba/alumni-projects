package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.Mensagem;

public interface IMensagemFacade {
	public Mensagem insertMensagem(Mensagem mensagem);

	public void updateMensagem(Mensagem mensagem);
	
	public List<Mensagem> findMensagem(Mensagem query);
}
