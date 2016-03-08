package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.MensagemFacadeDao;
import br.com.webstore.model.Mensagem;

public class MensagemFacade implements IMensagemFacade{
	// @Inject
	private MensagemFacadeDao mensagemDataProvider;
	
	@Override
	public Mensagem insertMensagem(Mensagem mensagem) {
		
		return mensagemDataProvider.insert(mensagem);
	}

	@Override
	public void updateMensagem(Mensagem mensagem) {
		mensagemDataProvider.update(mensagem);
		
	}

	@Override
	public List<Mensagem> findMensagem(Mensagem query) {
		
		return mensagemDataProvider.getList();
	}

}
