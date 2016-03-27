//#if ${Usuario} == "T" 

/**
 * 
 */
package br.com.webstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author webstore
 *
 */
@Entity
@Table(name="Usuario")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name="idUsuario")
	private Integer id;
	
	@ManyToOne(targetEntity = StatusUsuario.class)
	@JoinColumn(name="idStatusUsuario", referencedColumnName="idStatusUsuario", nullable=true)
	private StatusUsuario statusUsuario;
	
	@ManyToOne(targetEntity= Perfil.class)
	@JoinColumn(name="idPerfil", referencedColumnName="idPerfil", nullable=false)
	private Perfil perfil;
	
	@Column(name="dsNome")
	private String nome;
	
	@Column(name="dsEmail", nullable=false)
	private String email;
	
	@Column(name="dsSenha", nullable=false)
	private String senha;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dtNascimento")
	private Date dataNascimento;
	
	@Column(name="nrUsuarioTelefone")
	private String telefone;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dtUsuarioInclusao", nullable=false)
	private Date dataInclusao;
	
	@Column (name="dsLogin", nullable=false)
	private String login;
	

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
		if(dataInclusao != null){
			return (Date) dataNascimento.clone();
		}
		return null;
	}
	/**
	 * Setter the dataNascimento
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		if(dataNascimento != null){
			this.dataNascimento = (Date) dataNascimento.clone();
		}
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
		if(dataInclusao != null){
			return (Date) dataInclusao.clone();
		}
		return null;
	}
	/**
	 * Setter the dataInclusao
	 * @param dataInclusao the dataInclusao to set
	 */
	public void setDataInclusao(Date dataInclusao) {
		if(dataInclusao != null){
			this.dataInclusao = (Date) dataInclusao.clone();
		}
	}
	/**
	 * Return the statusUsuario 
	 * @return the statusUsuario
	 */
	public StatusUsuario getStatusUsuario() {
		return statusUsuario;
	}
	/**
	 * Setter the statusUsuario
	 * @param statusUsuario the statusUsuario to set
	 */
	public void setStatusUsuario(StatusUsuario statusUsuario) {
		this.statusUsuario = statusUsuario;
	}
	//#if ${Perfil} == "T"
	
	/**
	 * Return the perfil 
	 * @return the perfil
	 */
	public Perfil getPerfil() {
		return perfil;
	}
	/**
	 * Setter the perfil
	 * @param perfil the perfil to set
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}	
	
	/**
	 * Return the login 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Setter the login
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	//#endif
}
//#endif