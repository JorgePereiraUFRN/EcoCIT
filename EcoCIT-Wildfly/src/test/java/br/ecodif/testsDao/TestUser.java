package br.ecodif.testsDao;

import br.com.ecodif.dao.DeviceDAO;
import br.com.ecodif.dao.UserDAO;
import br.com.ecodif.domain.Device;
import br.com.ecodif.domain.Sensor;
import br.com.ecodif.domain.User;

public class TestUser {

	public static void main(String[] args) {
		
		
		DeviceDAO deviceDAO = new DeviceDAO();
		/*
		for(Device d : deviceDAO.findAll()){
			System.out.println(d);
		}*/
		
		for(Sensor s : deviceDAO.find(100).getSensors()){
			System.out.println(s);
		}

	}

	private static void findAllUsers() {
		UserDAO udDao = new UserDAO();
		
		for(User u : udDao.findAll()){
			
			System.out.println(u);
		}
	}

}
