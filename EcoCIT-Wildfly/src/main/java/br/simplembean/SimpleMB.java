package br.simplembean;



import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.ecodif.dao.UserDAO;
import br.com.ecodif.dao.UserTypeDAO;
import br.com.ecodif.domain.User;
import br.com.ecodif.domain.UserType;



//import br.testes.simpleEjb.SimpleEJB;




@ManagedBean
public class SimpleMB {


	
	@EJB
	private UserTypeDAO dao;

	
	public void managedbean(){
		System.out.println("managedbean");
		
		UserType ut = new UserType();
		
		ut.setDescription("user type teste");
		ut.setRole("teste");
		
		dao.save(ut);

		
		System.out.println("salvando objeto via ejb dao");
		
		

	}
	
	
	public static void main(String args[]){
		
		
		SimpleMB mb = new SimpleMB();
		
		mb.managedbean();
	}
	
	
}
