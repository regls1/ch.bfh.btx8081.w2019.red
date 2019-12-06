package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityService {

	
	private static EntityManager em;
	private static EntityService instance;
	
	private EntityService() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ch.bfh.btx8081.w2019.red.git");
		EntityManager em =   factory.createEntityManager();
		this.em= em;
	}
	
	public static EntityService getInctance() {
		if (instance == null) {
			instance = new EntityService();
			return instance;
		}
	return instance;
	}
	
	public static EntityManager getManager() {
		return em;
	}
	
	
}
