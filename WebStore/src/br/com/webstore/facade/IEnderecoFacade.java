package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.Endereco;

public interface IEnderecoFacade {
	public Endereco insertEndereco(Endereco endereco);

	public void updateEndereco(Endereco endereco);
	
	public List<Endereco> findEndereco(Endereco query);
}
