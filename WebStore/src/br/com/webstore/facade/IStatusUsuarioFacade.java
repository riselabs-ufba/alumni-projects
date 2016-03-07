package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.StatusUsuario;

public interface IStatusUsuarioFacade {

	public StatusUsuario insertStatusUsuario(StatusUsuario statusUsuario);

	public void updateStatusUsuario(StatusUsuario statusUsuario);
	
	public List<StatusUsuario> findStatusUsuario(StatusUsuario query);	
	
}
