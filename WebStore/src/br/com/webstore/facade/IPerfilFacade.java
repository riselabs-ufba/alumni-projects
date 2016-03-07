package br.com.webstore.facade;

import java.util.List;
import br.com.webstore.model.Perfil;

public interface IPerfilFacade {

	public Perfil insertPerfil(Perfil perfil);

	public void savePerfil(Perfil perfil);
	
	public List<Perfil> findPerfil(Perfil query);	
	
	
}
