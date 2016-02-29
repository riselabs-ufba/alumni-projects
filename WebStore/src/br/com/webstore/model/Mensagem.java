/**
 * 
 */
package br.com.webstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="Mensagem")
@PrimaryKeyJoinColumn(name="idMensagem ")
public class Mensagem {

	@Id
	@Column(name="idMensagem")
	private Integer id;
	
	//ForeignKey
	private Integer idUsuarioResposta;
	
	//ForeignKey
	private Integer idUsuarioRegistro;
	
	//ForeignKey
	private Integer idTipoMensagem;
	
	@Column(name="dsMensagem")
	private String descricao;
	
	@Column(name="dtMensagemRegistro")
	private Date dataRegistro;
	
	@Column(name="dsMensagemResposta")
	private Date dataResposta;
	
	@Column(name="dtMensagemResposta")
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
	 * Return the idUsuarioResposta 
	 * @return the idUsuarioResposta
	 */
	public Integer getIdUsuarioResposta() {
		return idUsuarioResposta;
	}
	/**
	 * Setter the idUsuarioResposta
	 * @param idUsuarioResposta the idUsuarioResposta to set
	 */
	public void setIdUsuarioResposta(Integer codigoUsuarioResposta) {
		this.idUsuarioResposta = codigoUsuarioResposta;
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
	 * Return the idTipoMensagem 
	 * @return the idTipoMensagem
	 */
	public Integer getIdTipoMensagem() {
		return idTipoMensagem;
	}
	/**
	 * Setter the idTipoMensagem
	 * @param idTipoMensagem the idTipoMensagem to set
	 */
	public void setIdTipoMensagem(Integer codigoTipoMensagem) {
		this.idTipoMensagem = codigoTipoMensagem;
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
