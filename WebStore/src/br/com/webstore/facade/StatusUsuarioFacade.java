package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.StatusUsuarioDao;
import br.com.webstore.model.StatusUsuario;

public class StatusUsuarioFacade implements IStatusUsuarioFacade {

	// @Inject
	private StatusUsuarioDao statusUsuarioDataProvider;	
	
	@Override
	public StatusUsuario insertStatusUsuario(StatusUsuario statusUsuario) {
		return statusUsuarioDataProvider.insert(statusUsuario);
	}

	@Override
	public void updateStatusUsuario(StatusUsuario statusUsuario) {
		statusUsuarioDataProvider.update(statusUsuario);		
	}

	@Override
	public List<StatusUsuario> findStatusUsuario(StatusUsuario query) {
		return statusUsuarioDataProvider.getList();
	}

}
