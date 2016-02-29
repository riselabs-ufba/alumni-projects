/**
 * 
 */
package br.com.webstore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

/**
 * @author webstore
 *
 */
@Entity
public class VendaProduto {

	private Integer idProduto;
	private Integer idVenda;
	private BigDecimal quantidade;
	private BigDecimal valorUnitario;
	
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
	public void setIdProduto(Integer codigoProduto) {
		this.idProduto = codigoProduto;
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
	public void setIdVenda(Integer codigoVenda) {
		this.idVenda = codigoVenda;
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
