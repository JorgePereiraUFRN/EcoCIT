package br.com.ecodif.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.ecodif.domain.User;
import br.com.ecodif.domain.UserGroup;

/**
 * Classe de acesso a dados (DAO) da entidade de dom�nio User que abstrai as opera��es sobre a respectiva 
 * tabela de aplica��es no banco de dados
 * @author Bruno Costa
 *
 */
@Stateless
public class UserDAO extends GenericDAO<User> {
	
	@EJB
	private UserGroupDAO userGroupDAO;
	
	public UserDAO(){
		super(User.class);
	}
	
	/**
	 * Verifica se um login j� � utilizado
	 * @param login 
	 * @return <true> se a string enviada j� � utilizada, <false> se n�o.
	 */
	public boolean isUsedLogin(String login){
		String strQuery = "Select u From User u WHERE u.login = :login";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);		
		return !super.findManyResults(strQuery, parameters).isEmpty();
		
	}
	
	/**
	 * Verifica se um e-mail j� � utilizado
	 * @param email
	 * @return <true> se o e-mail j� � utilizado, <false> se n�o for utilizado.
	 */
	public boolean isUsedEmail(String email){
		String strQuery = "Select u From User u WHERE u.email = :email";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);		
		return !super.findManyResults(strQuery, parameters).isEmpty();
		
	}
	
	/**
	 * Recupera um usu�rio segundo o login
	 * @param login
	 * @return objeto do tipo User
	 */
	public User findByLogin(String login){
		String strQuery = "Select u From User u WHERE u.login = :login";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);		
		return super.findOneResult(strQuery, parameters);
		
	}
	
	/**
	 * Recupera uma lista de usu�rios com base no tipo de usu�rio
	 * @param role
	 * @return lista de usu�rios
	 */
	public List<User> findByUserType(String role){
		String strQuery = "Select u From User u inner join u.userType t WHERE t.role = :role";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("role", role);		
		return super.findManyResults(strQuery, parameters);
		
	}
	
	/**
	 * Recupera uma lista de usu�rios com base no nome e tipo.
	 * @param name
	 * @param role
	 * @param loginCreator os usu�rios retornados n�o dever�o ter o login igual ao argumento enviado no loginCreator 
	 * @return lista de usu�rios
	 */
	public List<User> findByLoginAndRole(String name, String role, String loginCreator){
		String strQuery = "Select u From User u  WHERE u.role = :role AND u.name LIKE :name AND u.login != :loginCreator";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("role", role);
		parameters.put("name", "%" + name + "%");
		parameters.put("loginCreator", loginCreator);
		return super.findManyResults(strQuery, parameters);
		
	}
	
	/**
	 * Recupera uma lista de usu�rios com base no nome do grupo associado
	 * @param userGroupName
	 * @param loginCreator os usu�rios retornados n�o dever�o ter o login igual ao argumento enviado no loginCreator
	 * @return
	 */
	public List<User> findByUserGroup(String userGroupName, String loginCreator){
		//Select u From UserGroup ug inner join ug.users u WHERE ug.name = :userGroupName AND u.login != :loginCreator
		String strQuery = "Select ug From UserGroup ug WHERE ug.name = :userGroupName";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userGroupName", userGroupName);
		
		UserGroup ug = userGroupDAO.findOneResult(strQuery, parameters);
		
		if(ug!= null && ug.getUsers().size() > 0){
			
			List<User> users = new ArrayList<User>();
			
			for(User u : ug.getUsers()){
				if(!u.getLogin().equals(loginCreator)){
					users.add(u);
				}
			}
			
			return users;
			
		}
		
		return null;
	}

}

