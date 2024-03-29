package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * EntityService creates only one EntityManager by using the Singleton pattern.
 * 
 * @author romap1
 *
 */
public class EntityService {

	private static final String PERSISTENCE_UNIT_NAME = "ch.bfh.btx8081.w2019.red.git";
	protected static EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityService instance;

	/**
	 * Constructor
	 */
	public EntityService() {	
	}

	/**
	 * Creates EntityService Instance if there is no Instance.
	 * @return EntryServise instance
	 */
	public static EntityService getInstance() {
		if (instance == null) {
			instance = new EntityService();
			return instance;
		}
		return instance;
	}

	/**
	 * Begin a new local transaction so that  a new entity can persist.
	 */
	public void setUp() {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
	}

	/**
	 * Closes the EntityManager so that resources are conserved.
	 */
	public void close() {
		@SuppressWarnings("unused")
		EntityTransaction transaction = em.getTransaction();
		em.flush();
		em.close();
	}

	/**
	 * For Testing EntityService class
	 * @param args
	 */
	/**
	public static void main(String[] args) {
		EntityService es = new EntityService();
		es.setUp();
		es.close();
		

	}
**/
}
