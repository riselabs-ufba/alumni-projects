/**
 * 
 */
package br.com.webstore.model;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author webstore
 *
 */
@Entity
public class Cupom {

	private Integer id;
	private String descricao;
	private Date dataValidade;
	
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
	 * Return the dataValidade 
	 * @return the dataValidade
	 */
	public Date getDataValidade() {
		if(dataValidade != null){
			return (Date) dataValidade.clone();
		}
		return null;
	}
	/**
	 * Setter the dataValidade
	 * @param dataValidade the dataValidade to set
	 */
	public void setDataValidade(Date dataValidade) {
		if(dataValidade != null){
			this.dataValidade = (Date) dataValidade.clone();
		}
	}
}
