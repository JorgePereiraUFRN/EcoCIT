package br.com.ecodif.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modelo de um grupo de usu�rios na EcoDiF
 * @author Bruno Costa
 */
@Entity
@Table(name = "user_group")
public class UserGroup {

	/** 
	 * Identificador do grupo de usu�rios, gerado automaticamente quando o 
	 * grupo � persistido em banco de dados
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="user_group_id")
	private int id;
	
	/** Nome do grupo de usu�rios */
	private String name;
	
	/** Nome do criador do grupo de usu�rios */
	private String creator;
	
	/** 
	 * Refer�ncia para o <em>feed</em> que pode ser acessado pelos usu�rios
	 * pertencentes ao grupo em quest�o
	 * @see br.com.ecodif.domain.Environment
	 */
	@ManyToOne
	private Environment environment;
	
	/**
	 * Conjunto de usu�rios pertencentes ao grupo em quest�o.<br/>
	 * @see br.com.ecodif.domain.User
	 */
	//@ManyToMany(fetch=FetchType.EAGER)
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_user_group", 
	   joinColumns={@JoinColumn(name="user_group_id")}, 
	   inverseJoinColumns={@JoinColumn(name="user_id")})
	private Set<User> users;

	
	/**
	 * Retorna o identificador do grupo de usu�rios
	 * @return Identificador do grupo de usu�rios
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica o identificador do grupo de usu�rios
	 * @param id Identificador para altera��o
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna o nome do grupo de usu�rios
	 * @return Nome do grupo de usu�rios
	 */
	public String getName() {
		return name;
	}

	/**
	 * Modifica o nome do grupo de usu�rios
	 * @param name Nome para altera��o
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna a refer�ncia para o <em>feed</em> que pode ser acessado pelos 
	 * usu�rios pertencentes ao grupo em quest�o
	 * @return Refer�ncia para o <em>feed</em>
	 */
	public Environment getEnvironment() {
		return environment;
	}

	/**
	 * Modifica a refer�ncia para o <em>feed</em> que pode ser acessado pelos 
	 * usu�rios pertencentes ao grupo em quest�o
	 * @param environment Refer�ncia para altera��o
	 */
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	/**
	 * Retorna o nome do criador do grupo de usu�rios
	 * @return Nome do criador do grupo de usu�rios
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * Modifica o nome do criador do grupo de usu�rios
	 * @param creator Nome para altera��o
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * Retorna a lista de usu�rios pertencentes ao grupo de usu�rios em quest�o
	 * @return Lista de usu�rios pertencentes ao grupo de usu�rios em quest�o
	 */
	public Set<User> getUsers() {
		if (users == null) {
			users = new HashSet<User>();
		}
		return users;
	}

	/**
	 * Modifica a lista de usu�rios pertencentes ao grupo de usu�rios em quest�o
	 * @param users Lista de usu�rios para altera��o
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/**
	 * Verifica se dois grupos de usu�rios s�o iguais com base nos seus 
	 * identificadores
	 * @param other Grupo de usu�rios a ser comparado com o grupo de usu�rios 
	 * 			em quest�o
	 * @return <code>true</code> (verdadeiro) se os identificadores dos grupos 
	 * 		   	de usu�rios s�o iguais, e <code>falso</code> (falso) em caso 
	 * 			contr�rio
	 */
	@Override
	public boolean equals(Object other) {
		return other instanceof UserGroup && (id != 0) ? 
				id == (((UserGroup) other).id) : (other == this);
	}
	
	/**
	 * Retorna um c�digo <em>hash</em> para o objeto
	 * @return C�digo <em>hash</em> para o objeto
	 */
	@Override
	public int hashCode() {
		return getId() * 8;
	}
}
