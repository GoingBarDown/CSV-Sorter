package Exceptions;

/**
*
*This exception is thrown when a book has too many fields.
*The minimum number of fields required may be set by the program or the system.
*If a record or object has fewer fields than the required minimum, this exception is thrown.
*
* 	@author [Chandler Higgins (Student #: 40156534), Zayd-Khomayne Boucaud (Student #: 40157754)]
*	@version [1.0]
*/
public class TooManyFieldsException extends Exception {
	
	 /**
     * Constructs a new TooManyFieldsException with the specified detail message.
     *
     * @param str the detail message (which is saved for later retrieval
     *            by the `getMessage()` method).
     */
public TooManyFieldsException(String str) {
	super(str);
}
}