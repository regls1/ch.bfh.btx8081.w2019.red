package model;



/**
 * This class will be not used //romap1
 * Generic Class for database operations get, insert, update and delete
 * 
 * @author wackt2
 *
 */

public class DatabaseOperation<E> implements IEntity {

	public E get(int id) {
		return null;
	}
	
	public void insert(E entity) {
	}
	
	public void update(E entity) {
	}
	
	public void delete(int id) {
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
/**
	@Override
	public ArrayList<?> getArrayList() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
