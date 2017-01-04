package br.ecodif.testsDao;

import br.com.ecodif.dao.GenericDAO;
import br.com.ecodif.dao.UnitDao;
import br.com.ecodif.domain.Unit;

public class InsertUnit {

	private static UnitDao uDao = new UnitDao();
	
	public static void main(String[] args) {
		
	
		
		insertUnit("ºC", "Grau Celsius", "");
		insertUnit("m²", "Área", "");
		insertUnit("m³", "Volume", "");
		insertUnit("Kg/m³", "Densidade", "");
		insertUnit("m/s²", "Aceleração", "");
		insertUnit("W", "Potência", "Wat");
		insertUnit("J", "Energia", "Joule");

	}
	
	public static void insertUnit(String symbol, String  type,String value){
		
		
		
		Unit u = new Unit();
		u.setSymbol(symbol);
		u.setType(type);
		u.setValue(value);
		
		uDao.save(u);
	}
	
	

}
