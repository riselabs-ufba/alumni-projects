package br.com.webstore.facade;

import java.util.List;


import br.com.webstore.dao.UsuarioCupomDao;
import br.com.webstore.model.UsuarioCupom;

public class UsuarioCupomFacade implements IUsuarioCupomFacade{
	
	// @Inject
	private UsuarioCupomDao usuarioCupomDao;
	
	@Override
	public UsuarioCupom insertUsuarioCupom(UsuarioCupom usuarioCupom) {
		return usuarioCupomDao.insert(usuarioCupom);
	}

	@Override
	public void updateUsuarioCupom(UsuarioCupom usuarioCupom) {
		usuarioCupomDao.update(usuarioCupom);		
	}

	@Override
	public List<UsuarioCupom> findUsuarioCupom(UsuarioCupom usuarioCupom) {
		return usuarioCupomDao.getList();
	}
	

}
