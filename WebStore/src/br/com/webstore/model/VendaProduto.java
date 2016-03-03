//#if ${Event} == "F"
/**
 * 
 */
package br.com.webstore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="VendaProduto")
public class VendaProduto {
	
	@EmbeddedId
	private VendaProdutoEmbbed vendaProdutoEmbbed;
	
	@Column(name="nrQuantidadeProduto", nullable=false)
	private BigDecimal quantidade;
	
	@Column(name="vlProdutoUnitario", nullable=false)
	private BigDecimal valorUnitario;
	
	/**
	 * Return the vendaProdutoEmbbed 
	 * @return the vendaProdutoEmbbed
	 */
	public VendaProdutoEmbbed getVendaProdutoEmbbed() {
		return vendaProdutoEmbbed;
	}
	/**
	 * Setter the vendaProdutoEmbbed
	 * @param vendaProdutoEmbbed the vendaProdutoEmbbed to set
	 */
	public void setVendaProdutoEmbbed(VendaProdutoEmbbed vendaProdutoEmbbed) {
		this.vendaProdutoEmbbed = vendaProdutoEmbbed;
	}
	/**
	 * Return the quantidade 
	 * @return the quantidade
	 */
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	/**
	 * Setter the quantidade
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	/**
	 * Return the valorUnitario 
	 * @return the valorUnitario
	 */
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	/**
	 * Setter the valorUnitario
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}
//#endif