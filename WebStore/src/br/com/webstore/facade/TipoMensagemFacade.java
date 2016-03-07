package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.TipoMensagemDao;
import br.com.webstore.model.TipoMensagem;

public class TipoMensagemFacade implements ITipoMensagemFacade {

	// @Inject
	private TipoMensagemDao tipoMensagemDataProvider;
	
	@Override
	public TipoMensagem insertTipoMensagem(TipoMensagem tipoMensagem) {
		return tipoMensagemDataProvider.insert(tipoMensagem);
	}

	@Override
	public void updateTipoMensagem(TipoMensagem tipoMensagem) {
		tipoMensagemDataProvider.update(tipoMensagem);		
	}

	@Override
	public List<TipoMensagem> findTipoMensagem(TipoMensagem tipoMensagem) {
		return tipoMensagemDataProvider.getList();
	}
		
	
}
