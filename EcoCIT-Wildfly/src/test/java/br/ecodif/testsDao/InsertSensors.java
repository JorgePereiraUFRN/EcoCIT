package br.ecodif.testsDao;

import br.com.ecodif.dao.SensorDAO;
import br.com.ecodif.domain.Sensor;

public class InsertSensors {

	private static SensorDAO sDao = new SensorDAO();
	
	public static void main(String args[]){
		insertSensor("Sensor de Temperatura", "NTC", "10K", "");
		insertSensor("Sensor de Localizacao", "GPS", "", "");
		insertSensor("Sensor de Corrente Eletrica", "1500V", "10K", "");

	}
	
	public static void insertSensor(String description, String name, String precisionSensor, String technicalSpecifications){
		
		Sensor s = new Sensor();
		s.setDescription(description);
		s.setName(name);
		s.setPrecision(precisionSensor);
		s.setTechnicalSpecifications(technicalSpecifications);
		
		sDao.save(s);
	}

}
