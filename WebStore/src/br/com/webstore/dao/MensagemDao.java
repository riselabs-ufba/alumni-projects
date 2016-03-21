//#if ${Mensagem} == "T"
/**
 * 
 */
package br.com.webstore.dao;

import br.com.webstore.model.Mensagem;

/**
 * @author webstore
 *
 */
public class MensagemDao extends GenericDao<Mensagem, Integer>{

	public MensagemDao() {
		super(Mensagem.class);
	}
}
//#endif