package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.dao.EnderecoDao;
import br.com.webstore.model.Endereco;

public class EnderecoFacade implements IEnderecoFacade{
	// @Inject
	private EnderecoDao enderecoDataProvider;
	@Override
	public Endereco insertEndereco(Endereco endereco) {	
		return enderecoDataProvider.insert(endereco);
	}

	@Override
	public void updateEndereco(Endereco endereco) {
		enderecoDataProvider.update(endereco);
		
	}

	@Override
	public List<Endereco> findEndereco(Endereco query) {
		
		return enderecoDataProvider.getList();
	}

}
