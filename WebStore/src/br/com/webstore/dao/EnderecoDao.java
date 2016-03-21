//#if ${Endereco} == "T"
package br.com.webstore.dao;

import br.com.webstore.model.Endereco;

public class EnderecoDao extends GenericDao<Endereco, Integer>{
	public EnderecoDao() {
		super(Endereco.class);
	}
}
//#endif