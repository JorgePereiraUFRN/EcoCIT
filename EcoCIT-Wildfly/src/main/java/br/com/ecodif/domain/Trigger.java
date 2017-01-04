package br.com.ecodif.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo de um <em>trigger</em>, elemento que dispara mensagens de notifica��o
 * com base em eventos
 * @author Bruno Costa
 */
@Entity
@Table(name = "trigger_feed")
public class Trigger {

	/** 
	 * Identificador do <em>trigger</em>, gerado automaticamente quando o 
	 * <em>trigger</em> � persistido em banco de dados
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="id")
	private int id;
	
	/** Condi��o de disparo do <em>trigger</em> */
	@Column(name = "condition_trigger")
	private String condition;
	
	@Column(name = "number_condition")
	private String numberCondition;
	
	/** 
	 * <em>E-mail</em> de notifica��o cadastrado pelo criador do 
	 * <em>trigger</em>
	 */
	@Column(name = "email_creator")
	private String email;
	
	@Column(nullable=true)
	private String gcmId;

	/**
	 * <em>Feed</em> ao qual o <em>trigger</em> est� vinculado
	 * @see br.com.ecodif.domain.Environment
	 */
	@ManyToOne
	@JoinColumn(name = "environment_idd")
	private Environment environment;

	
	/**
	 * Retorna o identificador do <em>trigger</em>
	 * @return Identificador do <em>trigger</em>
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica o identificador do <em>trigger</em>
	 * @param id Identificador para altera��o
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna a condi��o de disparo do <em>trigger</em>
	 * @return Condi��o de disparo do <em>trigger</em>
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Modifica a condi��o de disparo do <em>trigger</em>
	 * @param condition Condi��o de disparo para altera��o
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getNumberCondition() {
		return numberCondition;
	}

	public void setNumberCondition(String numberCondition) {
		this.numberCondition = numberCondition;
	}

	/**
	 * Retorna o <em>e-mail</em> de notifica��o cadastrado pelo criador do
	 * <em>trigger</em>
	 * @return <em>E-mail</em> de notifica��o cadastrado pelo criador do
	 * 			<em>trigger</em>
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Modifica o <em>e-mail</em> de notifica��o cadastrado pelo criador do
	 * <em>trigger</em>
	 * @param email <em>E-mail</em> para altera��o
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGCMId() {
		return gcmId;
	}

	public void setGCMId(String gcmId) {
		this.gcmId = gcmId;
	}

	/**
	 * Retorna o <em>feed</em> ao qual o <em>trigger</em> est� vinculado
	 * @return <em>Feed</em> ao qual o <em>trigger</em> est� vinculado
	 */
	public Environment getEnvironment() {
		if (environment == null) {
			environment = new Environment();
		}
		return environment;
	}

	/**
	 * Modifica o <em>feed</em> ao qual o <em>trigger</em> est� vinculado
	 * @param environment <em>Feed</em> para altera��o
	 */
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
