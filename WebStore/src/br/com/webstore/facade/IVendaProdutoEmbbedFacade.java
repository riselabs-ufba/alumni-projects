/**
 * 
 */
package br.com.webstore.facade;

import java.util.List;

import br.com.webstore.model.VendaProdutoEmbbed;

/**
 * @author webstore
 *
 */
public interface IVendaProdutoEmbbedFacade {

	/**
	 * @param vendaProdutoEmbbed
	 * @return
	 */
	public VendaProdutoEmbbed insertVendaProdutoEmbbed(
			VendaProdutoEmbbed vendaProdutoEmbbed);

	/**
	 * @param vendaProdutoEmbbed
	 */
	public void updateVendaProdutoEmbbed(VendaProdutoEmbbed vendaProdutoEmbbed);

	/**
	 * @param vendaProdutoEmbbed
	 * @return
	 */
	public List<VendaProdutoEmbbed> findVendaProdutoEmbbed(
			VendaProdutoEmbbed vendaProdutoEmbbed);

}
