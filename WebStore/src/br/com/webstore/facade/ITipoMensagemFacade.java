package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.TipoMensagem;

public interface ITipoMensagemFacade {

	/**
	 * Find TipoMensagem by id
	 * @param id
	 * @return TipoMensagem
	 */
	public TipoMensagem find(Integer id);
	
	/**
	 * List all TipoMensagem
	 * @return List<TipoMensagem>
	 */
	public List<TipoMensagem> list();	
	
}
