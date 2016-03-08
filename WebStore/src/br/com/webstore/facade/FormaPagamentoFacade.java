package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.FormaPagamentDao;
import br.com.webstore.model.FormaPagamento;

public class FormaPagamentoFacade implements IFormaPagamentoFacade{
	private FormaPagamentDao formaPagamentDataProvider;
	@Override
	public FormaPagamento insertFormaPagamento(FormaPagamento formaPagamento) {

		return formaPagamentDataProvider.insert(formaPagamento);
	}

	@Override
	public void updateFormaPagamento(FormaPagamento formaPagamento) {
		formaPagamentDataProvider.update(formaPagamento);
		
	}

	@Override
	public List<FormaPagamento> findFormaPagamento(FormaPagamento query) {
	
		return formaPagamentDataProvider.getList();
	}

}
