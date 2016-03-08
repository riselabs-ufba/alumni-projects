package br.com.webstore.facade;


import java.util.List;

import br.com.webstore.model.UnidadeMedida;;

public interface IUnidadeMedidaFacade {
	
	public UnidadeMedida insertUnidadeMedida(UnidadeMedida unidadeMedida);

	public void updateUnidadeMedida(UnidadeMedida unidadeMedida);
	
	public List<UnidadeMedida> findUnidadeMedida(UnidadeMedida unidadeMedida);

}
