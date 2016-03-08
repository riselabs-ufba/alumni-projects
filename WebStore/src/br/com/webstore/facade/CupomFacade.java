package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.CupomDao;
import br.com.webstore.model.Cupom;

public class CupomFacade implements ICupomFacade{
	// @Inject
	private CupomDao cupomDataProvider;
	@Override
	public Cupom insertCupom(Cupom cupom) {
		
		return cupomDataProvider.insert(cupom);
	}

	@Override
	public void updateCupom(Cupom cupom) {
		cupomDataProvider.update(cupom);
		
	}

	@Override
	public List<Cupom> findCupom(Cupom query) {
		return cupomDataProvider.getList();
	}

}
