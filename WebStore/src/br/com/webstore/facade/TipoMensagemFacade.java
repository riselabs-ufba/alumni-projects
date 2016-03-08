package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.TipoMensagemDao;
import br.com.webstore.model.TipoMensagem;

public class TipoMensagemFacade implements ITipoMensagemFacade {
	
	private TipoMensagemDao tipoMensagemDataProvider = new TipoMensagemDao();
	
	@Override
	public TipoMensagem find(Integer id) {
		return tipoMensagemDataProvider.find(id);		
	}
	
	@Override
	public List<TipoMensagem> list() {
		return tipoMensagemDataProvider.getList();
	}
}
