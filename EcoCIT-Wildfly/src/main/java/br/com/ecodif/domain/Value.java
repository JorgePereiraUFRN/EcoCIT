package br.com.ecodif.domain;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo de um valor em um instante de tempo.<br/> 
 * Classe gerada com base no XML Schema da linguagem EEML: 
 * {@link http://eeml.org/xsd/0.5.1/0.5.1.xsd}
 * 
 * @see {@link http://eeml.org/xml/0.5.1/complete.xml}
 * 
 * @author Bruno Costa
 */
@Entity
@Table(name = "value")
public class Value {

	/** 
	 * Identificador do valor, gerado automaticamente quando o valor � 
	 * persistido em banco de dados
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id")
	private int iddb;
	
	/** Valor propriamente dito */
	private String value;
	
	/** Data/hora de mensura��o do valor */
	private GregorianCalendar at;
	
	
	/**
	 * Retorna o identificador do valor
	 * @return id Identificador do valor
	 */
	public int getIddb() {
		return iddb;
	}
	
	/**
	 * Modifica o identificador do valor
	 * @param iddb Identificador para altera��o
	 */
	public void setIddb(int iddb) {
		this.iddb = iddb;
	}
	
	/**
	 * Retorna o valor propriamente dito
	 * @return Valor propriamente dito
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Modifica o valor propriamente dito
	 * @param value Valor para altera��o
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Retorna a data/hora de mensura��o do valor
	 * @return Data/hora de mensura��o do valor
	 */
	public GregorianCalendar getAt() {
		return at;
	}
	
	/**
	 * Modifica a data/hora de mensura��o do valor
	 * @param at Data/hora para altera��o
	 */
	public void setAt(GregorianCalendar at) {
		this.at = at;
	}
}
