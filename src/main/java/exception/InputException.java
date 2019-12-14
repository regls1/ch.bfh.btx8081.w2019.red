package exception;

/**
 * a class to throw exceptions when user gives false input
 * 
 * @author neues4
 *
 */

@SuppressWarnings("serial")
public class InputException extends IllegalArgumentException {
	
	public InputException(String message) {
		super(message);
	}
}
