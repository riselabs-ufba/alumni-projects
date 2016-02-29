/**
 * 
 */
package br.com.webstore.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="Venda")
@PrimaryKeyJoinColumn(name="idVenda")
public class Venda {

	@Id
	@Column(name="idVenda")
	private Integer id;

	//ForeignKey
	private Integer idStatusVenda;
	
	//ForeignKey
	private Integer idUsuarioVenda;
	
	//ForeignKey
	private Integer idUsuarioCupom;
	
	//ForeignKey
	private Integer idFormaPagamento;
	
	@Column(name="dtVenda")
	private Date dataVenda;
	
	@Column(name="vlVendaTotal")
	private BigDecimal valorTotal;
	
	/**
	 * Return the id 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter the id
	 * @param id the id to set
	 */
	public void setId(Integer codigo) {
		this.id = codigo;
	}
	/**
	 * Return the idStatusVenda 
	 * @return the idStatusVenda
	 */
	public Integer getIdStatusVenda() {
		return idStatusVenda;
	}
	/**
	 * Setter the idStatusVenda
	 * @param idStatusVenda the idStatusVenda to set
	 */
	public void setIdStatusVenda(Integer codigoStatusVenda) {
		this.idStatusVenda = codigoStatusVenda;
	}
	/**
	 * Return the idUsuarioVenda 
	 * @return the idUsuarioVenda
	 */
	public Integer getIdUsuarioVenda() {
		return idUsuarioVenda;
	}
	/**
	 * Setter the idUsuarioVenda
	 * @param idUsuarioVenda the idUsuarioVenda to set
	 */
	public void setIdUsuarioVenda(Integer codigoUsuarioVenda) {
		this.idUsuarioVenda = codigoUsuarioVenda;
	}
	/**
	 * Return the idUsuarioCupom 
	 * @return the idUsuarioCupom
	 */
	public Integer getIdUsuarioCupom() {
		return idUsuarioCupom;
	}
	/**
	 * Setter the idUsuarioCupom
	 * @param idUsuarioCupom the idUsuarioCupom to set
	 */
	public void setIdUsuarioCupom(Integer codigoUsuarioCupom) {
		this.idUsuarioCupom = codigoUsuarioCupom;
	}
	/**
	 * Return the idFormaPagamento 
	 * @return the idFormaPagamento
	 */
	public Integer getIdFormaPagamento() {
		return idFormaPagamento;
	}
	/**
	 * Setter the idFormaPagamento
	 * @param idFormaPagamento the idFormaPagamento to set
	 */
	public void setIdFormaPagamento(Integer codigoFormaPagamento) {
		this.idFormaPagamento = codigoFormaPagamento;
	}
	/**
	 * Return the dataVenda 
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return dataVenda;
	}
	/**
	 * Setter the dataVenda
	 * @param dataVenda the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	/**
	 * Return the valorTotal 
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	/**
	 * Setter the valorTotal
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}
