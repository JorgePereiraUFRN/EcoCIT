package br.com.ecodif.dao;

import java.util.HashMap;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.ecodif.domain.Driver;
import br.com.ecodif.domain.Platform;

/**
 * Classe de acesso a dados (DAO) da entidade de dom�nio Driver que abstrai as opera��es sobre a respectiva 
 * tabela de aplica��es no banco de dados
 * @author Bruno Costa
 *
 */
@Stateless
public class DriverDAO extends GenericDAO<Driver> {

	@EJB
	PlatformDAO platformDAO;
	
	public DriverDAO() {
		super(Driver.class);
	}

	/**
	 * Recupera um driver segundo o identificador da plataforma associada
	 * @param idPlatform
	 * @return objeto do tipo <i>Driver</i>
	 * @throws NoResultException
	 */
	public Driver findDriverByPlatform(int idPlatform) throws NoResultException{
		
		Platform p = platformDAO.find(idPlatform);
		
		if(p != null){
			return p.getDriver();
		}
			/*String strQuery = "Select d From Driver d left join d.platforms p WHERE p.id = :idPlatform";
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("idPlatform", idPlatform);		
			return super.findOneResult(strQuery, parameters);*/
		
		
		return null;
	}
	
	/**
	 * Recupera um driver e as plataformas associadas pelo seu identificador
	 * @param id
	 * @return objeto do tipo <i>Driver</i>
	 * @throws NoResultException
	 */
	public Driver findDriverWithPlatform(int id) throws NoResultException{
		String strQuery = "Select d From Driver d left join fetch d.platforms p WHERE d.id = :id";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);		
		return super.findOneResult(strQuery, parameters);
	}
	
	/**
	 * Recupera um driver pelo identificador do dispositivo associado
	 * @param id
	 * @return objeto do tipo <i>Driver</i>
	 * @throws NoResultException
	 */
	public Driver findDriverByDevice(int id) throws NoResultException{
		String strQuery = "select d from Driver d inner join d.platforms p inner join p.devices de where de.id =:id";
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);		
		return super.findOneResult(strQuery, parameters);
	}
}
