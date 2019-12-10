package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EntityService {
	
	  private static final String PERSISTENCE_UNIT_NAME = "ch.bfh.btx8081.w2019.red.git";
	  private EntityManager em;
	  //private static EntityService instance;

	  public EntityService() {
		  em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	  }
	
	/* public static EntityService getInstance() {
		if (instance == null) {
			instance = new EntityService();
			return instance;
		}
	return instance;
	}
	*/
	
	/* public static EntityManager getManager() {
		return em;

	}
	*/
	
    public void setUp() {
        // Begin a new local transaction so that we can persist a new entity
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //em.flush();
        //transaction.commit();

	}
	

    public void close() {
        // It is always good practice to close the EntityManager so that resources
        // are conserved.
        EntityTransaction transaction = em.getTransaction();
        //transaction.begin();
        // Query q = em.createNativeQuery("SHUTDOWN COMPACT");
        // q.executeUpdate();
        em.flush();
        //transaction.commit();
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
