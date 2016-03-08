package br.com.webstore.dao;

import br.com.webstore.model.Endereco;

public class EnderecoFacadeDao extends GenericDao<Endereco, Integer>{
	public EnderecoFacadeDao() {
		super(Endereco.class);
	}
}
