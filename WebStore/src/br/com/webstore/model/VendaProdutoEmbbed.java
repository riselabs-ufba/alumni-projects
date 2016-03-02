/**
 * 
 */
package br.com.webstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author webstore
 *
 */
@Embeddable
public class VendaProdutoEmbbed implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="idProduto", nullable=false)
	private Integer idProduto;
	
	@Column(name="idVenda", nullable=false)
	private Integer idVenda;

	/**
	 * Return the idProduto 
	 * @return the idProduto
	 */
	public Integer getIdProduto() {
		return idProduto;
	}

	/**
	 * Setter the idProduto
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * Return the idVenda 
	 * @return the idVenda
	 */
	public Integer getIdVenda() {
		return idVenda;
	}

	/**
	 * Setter the idVenda
	 * @param idVenda the idVenda to set
	 */
	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}
}
