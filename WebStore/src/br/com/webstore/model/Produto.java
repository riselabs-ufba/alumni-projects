/**
 * 
 */
package br.com.webstore.model;

import java.math.BigDecimal;

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
@Table(name="Produto")
@PrimaryKeyJoinColumn(name="idProduto")
public class Produto {
	
	@Id
	@Column(name="idProduto")
	private Integer id;
	
	//ForeignKey
	private Integer idCategoria;
	
	//ForeignKey
	private Integer idUnidadeMedida;
	
	@Column(name="nrProdutoCodigo")
	private Integer numero;
	
	@Column(name="dsProduto")
	private String descricao;
	
	@Column(name="vlProduto")
	private BigDecimal valor;
	
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
	 * Return the idCategoria 
	 * @return the idCategoria
	 */
	public Integer getIdCategoria() {
		return idCategoria;
	}
	/**
	 * Setter the idCategoria
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(Integer codigoCategoria) {
		this.idCategoria = codigoCategoria;
	}
	/**
	 * Return the idUnidadeMedida 
	 * @return the idUnidadeMedida
	 */
	public Integer getIdUnidadeMedida() {
		return idUnidadeMedida;
	}
	/**
	 * Setter the idUnidadeMedida
	 * @param idUnidadeMedida the idUnidadeMedida to set
	 */
	public void setIdUnidadeMedida(Integer codigoUnidadeMedida) {
		this.idUnidadeMedida = codigoUnidadeMedida;
	}
	/**
	 * Return the numero 
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}
	/**
	 * Setter the numero
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/**
	 * Return the descricao 
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * Setter the descricao
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * Return the valor 
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}
	/**
	 * Setter the valor
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
