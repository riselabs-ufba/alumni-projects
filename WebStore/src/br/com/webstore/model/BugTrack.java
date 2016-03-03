//#if ${Event} == "F"
/**
 * 
 */
package br.com.webstore.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="BugTrack")
public class BugTrack {

	@Id 
	@GeneratedValue
	@Column(name="idBugTrack")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuarioResponde", referencedColumnName="idUsuario", nullable=false)
	private Usuario usuarioResponde;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuarioRegistro", referencedColumnName="idUsuario", nullable=false)
	private Usuario usuarioRegistro;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idSituacaoBug", referencedColumnName="idSituacaoBug", nullable=false)
	private SituacaoBug situacaoBug;
	
	@Column(name="dsBUG")
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dtMensagemRegistro", nullable=false)
	private Date dataRegistro;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dtResposta")
	private Date dataResposta;
	
	@Column(name="dsResposta")
	private String descricaoResposta;
	
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
	 * Return the usuarioResponde 
	 * @return the usuarioResponde
	 */
	public Usuario getUsuarioResponde() {
		return usuarioResponde;
	}
	/**
	 * Setter the usuarioResponde
	 * @param usuarioResponde the usuarioResponde to set
	 */
	public void setUsuarioResponde(Usuario usuarioResponde) {
		this.usuarioResponde = usuarioResponde;
	}
	/**
	 * Return the usuarioRegistro 
	 * @return the usuarioRegistro
	 */
	public Usuario getUsuarioRegistro() {
		return usuarioRegistro;
	}
	/**
	 * Setter the usuarioRegistro
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(Usuario usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
	/**
	 * Return the situacaoBug 
	 * @return the situacaoBug
	 */
	public SituacaoBug getSituacaoBug() {
		return situacaoBug;
	}
	/**
	 * Setter the situacaoBug
	 * @param situacaoBug the situacaoBug to set
	 */
	public void setSituacaoBug(SituacaoBug situacaoBug) {
		this.situacaoBug = situacaoBug;
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
	 * Return the dataRegistro 
	 * @return the dataRegistro
	 */
	public Date getDataRegistro() {
		return dataRegistro;
	}
	/**
	 * Setter the dataRegistro
	 * @param dataRegistro the dataRegistro to set
	 */
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	/**
	 * Return the dataResposta 
	 * @return the dataResposta
	 */
	public Date getDataResposta() {
		return dataResposta;
	}
	/**
	 * Setter the dataResposta
	 * @param dataResposta the dataResposta to set
	 */
	public void setDataResposta(Date dataResposta) {
		this.dataResposta = dataResposta;
	}
	/**
	 * Return the descricaoResposta 
	 * @return the descricaoResposta
	 */
	public String getDescricaoResposta() {
		return descricaoResposta;
	}
	/**
	 * Setter the descricaoResposta
	 * @param descricaoResposta the descricaoResposta to set
	 */
	public void setDescricaoResposta(String descricaoResposta) {
		this.descricaoResposta = descricaoResposta;
	}
}
//#endif