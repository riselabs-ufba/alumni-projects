//#if ${Event} == "F"
/**
 * 
 */
package br.com.webstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="UsuarioCupom")
public class UsuarioCupom {

	@Id
	@GeneratedValue
	@Column(name="idUsuarioCupom")
	private Integer id;
	
	@OneToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuario", referencedColumnName="idUsuario", nullable=false)
	private Usuario usuario;
	
	@OneToOne(targetEntity = Cupom.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idCupom", referencedColumnName="idCupom", nullable=false)
	private Cupom cupom;
	
	@Column(name="flUsado")
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
	public Usuario getIdUsuario() {
		return usuario;
	}
	/**
	 * Setter the idUsuario
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Usuario codigoUsuario) {
		this.usuario = codigoUsuario;
	}
	/**
	 * Return the idCupom 
	 * @return the idCupom
	 */
	public Cupom getIdCupom() {
		return cupom;
	}
	/**
	 * Setter the idCupom
	 * @param idCupom the idCupom to set
	 */
	public void setIdCupom(Cupom codigoCupom) {
		this.cupom = codigoCupom;
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
