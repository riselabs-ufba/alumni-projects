//#if ${Categoria} == "T"
/**
 * 
 */
package br.com.webstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="Categoria")
public class Categoria {
	
	@Id
	//replace @GeneratedValue
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name = "idCategoria")
	private Integer id;
	
	@Column(name = "dsCategoria" )
	private String descricao;
	
	/**
	 * Return the id 
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
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
		return this.descricao;
	}
	/**
	 * Setter the descricao
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/*
	@Override
	public String toString() {
		return this.descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj instanceof Categoria) {
			Categoria other = (Categoria) obj;
			return other.id == this.id;
		}
		return super.equals(obj);
	}	
	*/
}
//#endif