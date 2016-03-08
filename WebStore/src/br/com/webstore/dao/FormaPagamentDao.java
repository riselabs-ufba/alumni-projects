package br.com.webstore.dao;

import br.com.webstore.model.FormaPagamento;

public class FormaPagamentDao extends GenericDao<FormaPagamento, Integer> {
	public FormaPagamentDao() {
		super(FormaPagamento.class);
	}

}
