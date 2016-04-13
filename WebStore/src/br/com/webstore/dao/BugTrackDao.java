//#if ${Comunicacao} == "T"
//#if ${BugTrack} == "T"
package br.com.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.webstore.model.BugTrack;
import br.com.webstore.model.SituacaoBug;

public class BugTrackDao extends GenericDao<BugTrack, Integer>{
	public BugTrackDao(EntityManager entityManager) {
		super(entityManager, BugTrack.class);
	}
	
	public List<BugTrack> findByTitulo(String word) {
		TypedQuery<BugTrack> query = this.entityManager.createQuery("from BugTrack b where b.titulo like :titulo", BugTrack.class);
		query.setParameter("titulo", word + "%");
		return query.getResultList();
	}
	
	public List<BugTrack> findByTitulo(String word, SituacaoBug situacao) {
		TypedQuery<BugTrack> query = this.entityManager.createQuery("from BugTrack b where b.titulo like :titulo and b.situacaoBug = :situacao", BugTrack.class);
		query.setParameter("titulo", word + "%");
		query.setParameter("situacao", situacao);
		return query.getResultList();
	}
}
//#endif
//#endif