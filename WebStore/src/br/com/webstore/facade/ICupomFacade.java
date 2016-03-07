package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.Cupom;

public interface ICupomFacade {
	public Cupom insertCupom(Cupom cupom);

	public void updateCupom(Cupom cupom);
	
	public List<Cupom> findCupom(Cupom query);

}
