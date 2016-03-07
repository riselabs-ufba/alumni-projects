package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.PerfilDao;
import br.com.webstore.model.Perfil;

public class PerfilFacade implements IPerfilFacade {

	// @Inject
	private PerfilDao perfilDataProvider;
	
	
	@Override
	public Perfil insertPerfil(Perfil perfil) {
		return perfilDataProvider.insert(perfil);
	}

	@Override
	public void savePerfil(Perfil perfil) {
		perfilDataProvider.update(perfil);
		
	}

	@Override
	public List<Perfil> findPerfil(Perfil query) {
		return perfilDataProvider.getList();
	}

	
	
}
