package br.com.ecodif.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ecodif.dao.DriverDAO;
import br.com.ecodif.domain.Driver;

@Stateless
public class DriverService {

	@Inject
	private DriverDAO driverDAO;
	
	public void update(Driver driver){
		driverDAO.update(driver);
	}
	
	public void save(Driver driver){
		driverDAO.save(driver);
	}

}
