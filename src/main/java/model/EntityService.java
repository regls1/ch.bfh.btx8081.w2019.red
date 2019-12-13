package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * EntityService creates only one EntityManager by using the Singleton pattern.
 * 
 * @author Patricia
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
	 * Sets up Transaction
	 */
	public void setUp() {
		// Begin a new local transaction so that we can persist a new entity
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		// em.flush();
		// transaction.commit();

	}

	/**
	 * closes Transaction
	 */
	public void close() {
		// It is always good practice to close the EntityManager so that resources
		// are conserved.
		@SuppressWarnings("unused")
		EntityTransaction transaction = em.getTransaction();
		// transaction.begin();
		// Query q = em.createNativeQuery("SHUTDOWN COMPACT");
		// q.executeUpdate();
		em.flush();
		// transaction.commit();
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
