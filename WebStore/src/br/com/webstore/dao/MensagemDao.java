//#if ${Mensagem} == "T"
/**
 * 
 */
package br.com.webstore.dao;

import javax.persistence.EntityManager;

import br.com.webstore.model.Mensagem;

/**
 * @author webstore
 *
 */
public class MensagemDao extends GenericDao<Mensagem, Integer>{

	public MensagemDao(EntityManager entityManager) {
		super(entityManager, Mensagem.class);
	}
}
//#endif