package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.TipoMensagem;

public interface ITipoMensagemFacade {

	public TipoMensagem insertTipoMensagem(TipoMensagem tipoMensagem);

	public void updateTipoMensagem(TipoMensagem tipoMensagem);
	
	public List<TipoMensagem> findTipoMensagem(TipoMensagem query);	
	
}
