//#if ${Endereco} == "T"
/**
 * 
 */
package br.com.webstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author webstore
 *
 */
@Entity
@Table(name="Endereco")
public class Endereco {
	
	@Id
	@GeneratedValue
	@Column(name="idEndereco")
	private Integer id;
	
	@JoinColumn(name="idUsuario", referencedColumnName="idUsuario", nullable=false)
	private Integer idUsuario;
	
	@Column(name="nmEnderecoLogradouro")
	private String logradouro;
	
	@Column(name="nrEndereco")
	private String numero;
	
	@Column(name="dsEnderecoBairro")
	private String bairro;
	
	@Column(name="dsEnderecoCep")
	private String cep;
	
	@Column(name="dsEnderecoCidade")
	private String cidade;
	
	@Column(name="dsEnderecoUF")
	private String uf;
	
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
	 * Return the logradouro 
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}
	/**
	 * Setter the logradouro
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	/**
	 * Return the numero 
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * Setter the numero
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * Return the bairro 
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * Setter the bairro
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * Return the cep 
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * Setter the cep
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * Return the cidade 
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * Setter the cidade
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * Return the uf 
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}
	/**
	 * Setter the uf
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}
}
//#endif