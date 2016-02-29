/**
 * 
 */
package br.com.webstore.model;

import javax.persistence.Entity;

/**
 * @author webstore
 *
 */
@Entity
public class UsuarioCupom {

	private Integer id;
	private Integer idUsuario;
	private Integer idCupom;
	private Boolean disponivel;
	
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
	 * Return the idUsuario 
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Setter the idUsuario
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer codigoUsuario) {
		this.idUsuario = codigoUsuario;
	}
	/**
	 * Return the idCupom 
	 * @return the idCupom
	 */
	public Integer getIdCupom() {
		return idCupom;
	}
	/**
	 * Setter the idCupom
	 * @param idCupom the idCupom to set
	 */
	public void setIdCupom(Integer codigoCupom) {
		this.idCupom = codigoCupom;
	}
	/**
	 * Return the disponivel 
	 * @return the disponivel
	 */
	public Boolean getDisponivel() {
		return disponivel;
	}
	/**
	 * Setter the disponivel
	 * @param disponivel the disponivel to set
	 */
	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
}
