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
		em.getTransaction();
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
	
	
	public static void main(String[] args) {
		EntityService es = new EntityService();
		EntityManager em = es.getManager();
		em.getTransaction();
		em.close();
	}
	
}
