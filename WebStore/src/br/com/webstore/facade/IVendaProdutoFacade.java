/**
 * 
 */
package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.VendaProduto;

/**
 * @author webstore
 *
 */
public interface IVendaProdutoFacade {

	/**
	 * @param vendaProduto
	 * @return
	 */
	public VendaProduto insertVendaProduto(VendaProduto vendaProduto);

	/**
	 * @param vendaProduto
	 */
	public void updateVendaProduto(VendaProduto vendaProduto);

	/**
	 * @param vendaProduto
	 * @return
	 */
	public List<VendaProduto> findVendaProduto(VendaProduto vendaProduto);

}
