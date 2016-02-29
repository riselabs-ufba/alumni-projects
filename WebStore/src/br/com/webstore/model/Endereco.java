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
public class Endereco {
	
	private Integer id;
	private Integer idUsuario;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
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
