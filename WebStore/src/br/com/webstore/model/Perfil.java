//#if ${Perfil} == "T"
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
@Table(name="Perfil")
public class Perfil {

	@Id
	@GeneratedValue
	@Column(name="idPerfil")
	private Integer id;
	
	@Column(name="dsPerfil")
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
	
	public String toString() {
		return this.descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj instanceof Perfil) {
			Perfil other = (Perfil) obj;
			return other.id == this.id;
		}
		return super.equals(obj);
	}	
}
//#endif