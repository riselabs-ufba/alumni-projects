//#if ${Mensagem} == "T"
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="Mensagem")
public class Mensagem {

	@Id
	@GeneratedValue
	@Column(name="idMensagem")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuarioResposta", referencedColumnName="idUsuario", nullable=true)
	private Usuario usuarioResposta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuarioRegistro", referencedColumnName="idUsuario", nullable=false)
	private Usuario usuarioRegistro;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idTipoMensagem", referencedColumnName="idTipoMensagem", nullable=false)
	private TipoMensagem tipoMensagem;
	
	@Column(name="dsMensagem")
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dtMensagemRegistro", nullable=false)
	private Date dataRegistro;
	
	@Temporal(TemporalType.DATE)
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
	 * Return the usuarioResposta 
	 * @return the usuarioResposta
	 */
	public Usuario getUsuarioResposta() {
		return usuarioResposta;
	}
	/**
	 * Setter the usuarioResposta
	 * @param usuarioResposta the usuarioResposta to set
	 */
	public void setUsuarioResposta(Usuario usuarioResposta) {
		this.usuarioResposta = usuarioResposta;
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
	 * Return the tipoMensagem 
	 * @return the tipoMensagem
	 */
	public TipoMensagem getTipoMensagem() {
		return tipoMensagem;
	}
	/**
	 * Setter the tipoMensagem
	 * @param tipoMensagem the tipoMensagem to set
	 */
	public void setTipoMensagem(TipoMensagem tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
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