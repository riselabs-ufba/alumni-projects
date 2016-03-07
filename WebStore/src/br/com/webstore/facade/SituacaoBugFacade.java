package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.SituacaoBugDao;
import br.com.webstore.model.SituacaoBug;

public class SituacaoBugFacade implements ISituacaoBugFacade {

	// @Inject
	private SituacaoBugDao situacaoBugDataProvider;
	
	@Override
	public SituacaoBug insertSituacaoBug(SituacaoBug situacaoBug) {
		return situacaoBugDataProvider.insert(situacaoBug);
	}

	@Override
	public void updateSituacaoBug(SituacaoBug situacaoBug) {
		situacaoBugDataProvider.update(situacaoBug);		
	}

	@Override
	public List<SituacaoBug> findSituacaoBug(SituacaoBug query) {
		return situacaoBugDataProvider.getList();
	}

}
