//#if ${Event} == "F"
/**
 * 
 */
package br.com.webstore.model;

import java.math.BigDecimal;
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
@Table(name="Venda")
public class Venda {

	@Id
	@GeneratedValue
	@Column(name="idVenda")
	private Integer id;

	@OneToOne(targetEntity = StatusVenda.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idStatusVenda", referencedColumnName="idStatusVenda", nullable=false)
	private StatusVenda statusVenda;
	
	@ManyToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuarioVenda", referencedColumnName="idUsuario", nullable=false)
	private Usuario usuarioVenda;
	
	@ManyToOne(targetEntity = UsuarioCupom.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuarioCupom", referencedColumnName="idUsuarioCupom", nullable=false)
	private UsuarioCupom usuarioCupom;
	
	@ManyToOne(targetEntity = FormaPagamento.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idFormaPagamento", referencedColumnName="idFormaPagamento", nullable=false)
	private FormaPagamento formaPagamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dtVenda", nullable=false)
	private Date dataVenda;
	
	@Column(name="vlVendaTotal", nullable=false)
	private BigDecimal valorTotal;
	
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
	 * Return the statusVenda 
	 * @return the statusVenda
	 */
	public StatusVenda getStatusVenda() {
		return statusVenda;
	}
	/**
	 * Setter the statusVenda
	 * @param statusVenda the statusVenda to set
	 */
	public void setStatusVenda(StatusVenda statusVenda) {
		this.statusVenda = statusVenda;
	}
	/**
	 * Return the usuarioVenda 
	 * @return the usuarioVenda
	 */
	public Usuario getUsuarioVenda() {
		return usuarioVenda;
	}
	/**
	 * Setter the usuarioVenda
	 * @param usuarioVenda the usuarioVenda to set
	 */
	public void setUsuarioVenda(Usuario usuarioVenda) {
		this.usuarioVenda = usuarioVenda;
	}
	/**
	 * Return the usuarioCupom 
	 * @return the usuarioCupom
	 */
	public UsuarioCupom getUsuarioCupom() {
		return usuarioCupom;
	}
	/**
	 * Setter the usuarioCupom
	 * @param usuarioCupom the usuarioCupom to set
	 */
	public void setUsuarioCupom(UsuarioCupom usuarioCupom) {
		this.usuarioCupom = usuarioCupom;
	}
	/**
	 * Return the formaPagamento 
	 * @return the formaPagamento
	 */
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	/**
	 * Setter the formaPagamento
	 * @param formaPagamento the formaPagamento to set
	 */
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	/**
	 * Return the idUsuarioVenda 
	 * @return the idUsuarioVenda
	 */
	public Usuario getIdUsuarioVenda() {
		return usuarioVenda;
	}
	/**
	 * Setter the idUsuarioVenda
	 * @param idUsuarioVenda the idUsuarioVenda to set
	 */
	public void setIdUsuarioVenda(Usuario codigoUsuarioVenda) {
		this.usuarioVenda = codigoUsuarioVenda;
	}
	/**
	 * Return the idUsuarioCupom 
	 * @return the idUsuarioCupom
	 */
	public UsuarioCupom getIdUsuarioCupom() {
		return usuarioCupom;
	}
	/**
	 * Setter the idUsuarioCupom
	 * @param idUsuarioCupom the idUsuarioCupom to set
	 */
	public void setIdUsuarioCupom(UsuarioCupom codigoUsuarioCupom) {
		this.usuarioCupom = codigoUsuarioCupom;
	}
	/**
	 * Return the idFormaPagamento 
	 * @return the idFormaPagamento
	 */
	public FormaPagamento getIdFormaPagamento() {
		return formaPagamento;
	}
	/**
	 * Setter the idFormaPagamento
	 * @param idFormaPagamento the idFormaPagamento to set
	 */
	public void setIdFormaPagamento(FormaPagamento codigoFormaPagamento) {
		this.formaPagamento = codigoFormaPagamento;
	}
	/**
	 * Return the dataVenda 
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return dataVenda;
	}
	/**
	 * Setter the dataVenda
	 * @param dataVenda the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	/**
	 * Return the valorTotal 
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	/**
	 * Setter the valorTotal
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}
//#endif