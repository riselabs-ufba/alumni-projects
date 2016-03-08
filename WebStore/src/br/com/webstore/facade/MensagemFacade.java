
/**
 * 
 */
package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.MensagemDao;
import br.com.webstore.model.Mensagem;

/**
 * @author webstore
 *
 */
public class MensagemFacade implements IMensagemFacade {

	private MensagemDao mensagemDao = new MensagemDao();
	
	@Override
	public void insert(Mensagem mensagem) {
		this.mensagemDao.insert(mensagem);
	}

	@Override
	public void update(Mensagem mensagem) {
		this.mensagemDao.update(mensagem);
	}

	@Override
	public Mensagem find(Integer id) {
		return this.mensagemDao.find(id);
	}

	@Override
	public List<Mensagem> list(Mensagem query) {
		return this.mensagemDao.getList();
	}
}

