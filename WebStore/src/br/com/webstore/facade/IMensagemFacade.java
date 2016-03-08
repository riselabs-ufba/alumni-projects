package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.Mensagem;

public interface IMensagemFacade {
	
	/**
	 * Inser a new message
	 * @param mensagem
	 * @return Mensagem
	 */
	public void insert(Mensagem mensagem);

	/**
	 * Update message
	 * @param mensagem
	 */
	public void update(Mensagem mensagem);
	
	/**
	 * Find message by id
	 * @param id
	 * @return Mensagem
	 */
	public Mensagem find(Integer id);
	
	/**
	 * List all messages
	 * @param query
	 * @return List<Mensagem>
	 */
	public List<Mensagem> list(Mensagem query);
}
