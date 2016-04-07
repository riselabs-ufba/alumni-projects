//#if ${FAQ} == "T"
/**
 *
 */
package br.com.webstore.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

/**
 * @author webstore
 *
 */
@Entity
@Table(name = "Faq")
public class Faq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFaq")
	private Integer id;

	
	@Column(name = "dsFaq")
	private String descricao;

	@Column(name = "dsFaqResposta")
	private String resposta;


	
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer codigo) {
		this.id = codigo;
	}
	

	public String getDescricao() {
		return this.descricao;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getResposta() {
		return this.resposta;
	}
	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
}
//#endif