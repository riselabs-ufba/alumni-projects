package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.SituacaoBug;

public interface ISituacaoBugFacade {

	public SituacaoBug insertSituacaoBug(SituacaoBug situacaoBug);

	public void updateSituacaoBug(SituacaoBug situacaoBug);
	
	public List<SituacaoBug> findSituacaoBug(SituacaoBug query);	
	
}
