/**
 * 
 */
package br.com.webstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * @author webstore
 *
 */
@Entity
@Table(name="Usuario")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name="Usuario")
	private Integer id;
	
	@ManyToOne(targetEntity = StatusUsuario.class)
	private Integer idStatusUsuario;
	
	@ManyToOne(targetEntity= Perfil.class)
	private Integer idPerfil;
	
	@Column(name="dsNome")
	private String nome;
	
	@Column(name="dsEmail")
	private String email;
	
	@Column(name="dsSenha")
	private String senha;
	
	@Column(name="dtNascimento")
	private Date dataNascimento;
	
	@Column(name="nrUsuarioTelefone")
	private String telefone;
	
	@Column(name="dtUsuarioInclusao")
	private Date dataInclusao;
	
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
	 * Return the nome 
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Setter the nome
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Return the email 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter the email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Return the senha 
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Setter the senha
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * Return the dataNascimento 
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * Setter the dataNascimento
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * Return the telefone 
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * Setter the telefone
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * Return the dataInclusao 
	 * @return the dataInclusao
	 */
	public Date getDataInclusao() {
		return dataInclusao;
	}
	/**
	 * Setter the dataInclusao
	 * @param dataInclusao the dataInclusao to set
	 */
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	/**
	 * Return the idStatusUsuario 
	 * @return the idStatusUsuario
	 */
	public Integer getIdStatusUsuario() {
		return idStatusUsuario;
	}
	/**
	 * Setter the idStatusUsuario
	 * @param idStatusUsuario the idStatusUsuario to set
	 */
	public void setIdStatusUsuario(Integer codigoStatusUsuario) {
		this.idStatusUsuario = codigoStatusUsuario;
	}
	/**
	 * Return the idPerfil 
	 * @return the idPerfil
	 */
	public Integer getIdPerfil() {
		return idPerfil;
	}
	/**
	 * Setter the idPerfil
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(Integer codigoPerfil) {
		this.idPerfil = codigoPerfil;
	}
}
