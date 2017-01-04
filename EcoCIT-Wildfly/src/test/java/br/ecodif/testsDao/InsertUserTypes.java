package br.ecodif.testsDao;



import br.com.ecodif.dao.UserTypeDAO;
import br.com.ecodif.domain.UserType;

public class InsertUserTypes {
	
	private static UserTypeDAO utDao = new UserTypeDAO();

	
	public static void insertUserType(String description, String role ){
		UserType ut = new UserType();
		
		ut.setDescription(description);
		ut.setRole(role);
		
		utDao.save(ut);
	}
	
	public static void main(String args[]){
		insertUserType("Fabricante de dispositivo", "FAB_DISP");
		insertUserType( "Provedor de dados", "PROV_DADOS");
		insertUserType("Desenvolvedor de aplicações", "DEV_APP");
	}

}
