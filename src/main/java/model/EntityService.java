package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 
 * @author Patricia
 *
 */
public class EntityService {
	
	  private static final String PERSISTENCE_UNIT_NAME = "ch.bfh.btx8081.w2019.red.git";
	  protected static EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	  private static EntityService instance;

	 /**
	  * 
	  */
	  public EntityService() {
		 // em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	  }
	
	 
	   //EntityService as Singleton
	    public static EntityService getInstance() {
		if (instance == null) {
			instance = new EntityService();
			return instance;
		}
	return instance;
	}
	
	
	
	  /**
	   * 
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
        @SuppressWarnings("unused")
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
		/*
		ContactServiceClass csc = new ContactServiceClass();
		Contact contact1 = new Contact();
		City city1 = new City();
		city1.setName("Bern");
		city1.setZip(2555);
		contact1.setCityId(city1.getId());
		csc.addContact(contact1);
		System.out.println(csc.addContact(contact1));
		*/
		//em.getTransaction();
		//em.close();
	}
	
}
