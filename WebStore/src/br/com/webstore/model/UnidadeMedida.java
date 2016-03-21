//#if ${UnidadeMedida} == "T"
/**
 * 
 */
package br.com.webstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="UnidadeMedida")
public class UnidadeMedida {

	@Id
	@GeneratedValue
	@Column(name="idUnidadeMedida")
	private Integer id;
	
	@Column(name="dsUnidadeMedida")
	private String descricao;
	
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
	
	@Override
	public String toString() {
		return this.descricao;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj instanceof UnidadeMedida) {
			UnidadeMedida other = (UnidadeMedida) obj;
			return other.id == this.id;
		}
		return super.equals(obj);
	}
	
}
//#endif