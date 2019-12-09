package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	
    public void setUp() {
        // Begin a new local transaction so that we can persist a new entity
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

	}
	

    public void close() {
        // It is always good practice to close the EntityManager so that resources
        // are conserved.
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
//	Query q = em.createNativeQuery("SHUTDOWN COMPACT");
//	q.executeUpdate();
        em.flush();
        transaction.commit();
        em.close();
    }
	
	public static void main(String[] args) {
		EntityService es = new EntityService();
		//EntityManager em = es.getManager();
		es.setUp();
		es.close();
		//em.getTransaction();
		//em.close();
	}
	
}
