package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.FormaPagamento;

public interface IFormaPagamentoFacade {
	public FormaPagamento insertFormaPagamento(FormaPagamento formaPagamento);

	public void updateFormaPagamento(FormaPagamento formaPagamento);
	
	public List<FormaPagamento> findFormaPagamento(FormaPagamento query);
}
