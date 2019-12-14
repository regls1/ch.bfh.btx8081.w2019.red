package exception;

/**
 * a class to throw exceptions when user wants to read something of the database that doesn't exist
 * 
 * @author neues4
 *
 */

@SuppressWarnings("serial")
public class ReadException extends Exception {
	
	public ReadException(String message) {
		super(message);
	}

}
