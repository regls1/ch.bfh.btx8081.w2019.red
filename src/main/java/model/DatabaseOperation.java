package model;

/**
 * interface for database operations get, insert, update and delete
 * 
 * @author wackt2
 *
 */

public class DatabaseOperation<E extends IEntity> {

	public E getById(int id) {
		return null;
	}
	
	public void insertInto(E entity) {
	}
	
	public void updateEntry(E entity) {
	}
	
	public void deleteById(int id) {
	}
}
