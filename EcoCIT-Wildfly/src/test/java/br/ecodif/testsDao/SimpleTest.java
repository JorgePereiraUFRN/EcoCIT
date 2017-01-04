package br.ecodif.testsDao;

import br.com.ecodif.dao.UserDAO;
import br.com.ecodif.dao.UserGroupDAO;
import br.com.ecodif.dao.UserTypeDAO;
import br.com.ecodif.domain.User;
import br.com.ecodif.domain.UserGroup;
import br.com.ecodif.domain.UserType;

public class SimpleTest {
	
	public static void main(String args[]){
		
		
		UserType ut = new UserType();
		
		ut.setDescription("description");
		//ut.setId(1);
		ut.setRole("amdin");
		
		UserTypeDAO utDao = new UserTypeDAO();
		//utDao.save(ut);
		
		/*User user = new User();
		user.setCompanyName("ufrn");
		user.setEmail("mail");
		user.setId(1);
		user.setLogin("login");
		user.setName("name");
		user.setPassword("password");
		user.setUserType(ut);
		
		UserDAO udao = new UserDAO();
		udao.save(user);
		
		UserGroup ug = new UserGroup();
		ug.setCreator("jorge");
		ug.setId(1);
		ug.setName("name");
		ug.getUsers().add(user);
		
		UserGroupDAO ugDao = new UserGroupDAO();
		
		ugDao.save(ug);
		*/
		
		System.out.println(utDao.findAll());
		
		System.out.println("fim");
		
	}

}
