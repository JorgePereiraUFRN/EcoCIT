package br.ecodif.testsDao;

import br.com.ecodif.dao.PlatformDAO;
import br.com.ecodif.domain.Platform;

public class InsertPlatform {
	
	private static PlatformDAO pDao = new PlatformDAO();

	public static void main(String[] args) {
		insertPlatform("Embarcado (Arduino)", "1.0.0");
		insertPlatform("Embarcado (Dialog 3G)", "1");
		insertPlatform("FroYo (Android)", "2.2");
		insertPlatform("Gingerbread (Android)", "2.3");
		insertPlatform("Honeycomb (Android)", "3.0");
		insertPlatform("Ice Cream Sandwich (Android)", "4.0");
		insertPlatform("Jelly Bean (Android)", "4.2");

	}
	
	public static void insertPlatform(String description, String platformVersion){
		Platform p = new Platform();
		
		p.setDescription(description);
		p.setVersion(platformVersion);
		
		pDao.save(p);
	}

}
