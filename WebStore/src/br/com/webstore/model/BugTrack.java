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
public class BugTrack {

	private Integer id;
	private Integer idUsuarioResponde;
	private Integer idUsuarioRegistro;
	private Integer idSituacaoBug;
	private String descricao;
	private Date dataRegistro;
	private Date dataResposta;
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
	 * Return the idUsuarioResponde 
	 * @return the idUsuarioResponde
	 */
	public Integer getIdUsuarioResponde() {
		return idUsuarioResponde;
	}
	/**
	 * Setter the idUsuarioResponde
	 * @param idUsuarioResponde the idUsuarioResponde to set
	 */
	public void setIdUsuarioResponde(Integer codigoUsuarioResponde) {
		this.idUsuarioResponde = codigoUsuarioResponde;
	}
	/**
	 * Return the idUsuarioRegistro 
	 * @return the idUsuarioRegistro
	 */
	public Integer getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}
	/**
	 * Setter the idUsuarioRegistro
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(Integer codigoUsuarioRegistro) {
		this.idUsuarioRegistro = codigoUsuarioRegistro;
	}
	/**
	 * Return the idSituacaoBug 
	 * @return the idSituacaoBug
	 */
	public Integer getIdSituacaoBug() {
		return idSituacaoBug;
	}
	/**
	 * Setter the idSituacaoBug
	 * @param idSituacaoBug the idSituacaoBug to set
	 */
	public void setIdSituacaoBug(Integer codigoSituacaoBug) {
		this.idSituacaoBug = codigoSituacaoBug;
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
