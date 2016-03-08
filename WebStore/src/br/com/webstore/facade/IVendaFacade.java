/**
 * 
 */
package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.Venda;

/**
 * @author webstore
 *
 */
public interface IVendaFacade {

	/**
	 * @param venda
	 * @return
	 */
	Venda insertVenda(Venda venda);

	/**
	 * @param venda
	 */
	void updateVenda(Venda venda);

	/**
	 * @param venda
	 * @return
	 */
	List<Venda> findCategoria(Venda venda);

}
