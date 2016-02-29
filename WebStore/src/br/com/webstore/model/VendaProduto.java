/**
 * 
 */
package br.com.webstore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="VendaProduto")
//@PrimaryKeyJoinColumn Dupla
public class VendaProduto {
	
	//ForeignKey
	private Integer idProduto;
	//ForeignKey
	private Integer idVenda;
	
	@Column(name="nrQuantidadeProduto")
	private BigDecimal quantidade;
	
	@Column(name="vlProdutoUnitario")
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
