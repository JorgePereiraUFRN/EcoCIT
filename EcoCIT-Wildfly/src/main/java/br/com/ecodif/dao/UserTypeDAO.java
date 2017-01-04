package br.com.ecodif.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;

import br.com.ecodif.domain.UserType;

/**
 * Classe de acesso a dados (DAO) da entidade de dom�nio UserType que abstrai as opera��es sobre a respectiva 
 * tabela de aplica��es no banco de dados
 * @author Bruno Costa
 *
 */
@Stateless
public class UserTypeDAO extends GenericDAO<UserType>{
	
	public UserTypeDAO(){
		super(UserType.class);
	}
	
	/**
	 * Recupera um objeto do tipo UserType segundo o seu tipo
	 * @param role
	 * @return objeto do tipo UserType
	 */
	public UserType findByRole(String role){
		String strQuery = "Select u From UserType u WHERE u.role = :role";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("role", role);		
		return super.findOneResult(strQuery, parameters);
		
	}
	
	/**
	 * Recupera uma lista de objetos do tipo UserType que n�o sejam de um tipo espec�fico
	 * @param userType tipo de usu�rios que n�o ser�o retornados
	 * @return lista de ojetos do tipo UserType
	 */
	public List<UserType> findWithoutSpecUserType(String userType){
		
		List<UserType> list1 = findAll();
		
		if(list1 != null && list1.size() > 0){
			List<UserType> retorno = new ArrayList<UserType>();
			
			for(UserType ut : list1){
				System.out.println("print: "+ut);
				if(!ut.getRole().equals(userType)){
					retorno.add(ut);
				}
				
			}
			
			
			return retorno;
		}else{
			return null;
		}
		
		
		/*String strQuery = "Select u From UserType u WHERE u.role != :userType";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userType", userType);		
		return super.findManyResults(strQuery, parameters);*/
		
	}

}
