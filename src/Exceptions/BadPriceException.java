package Exceptions;


/**
 * The `BadPriceException` class is an exception that is thrown to indicate
 * an error related to an invalid price format.
 * 
 * This exception is typically thrown when attempting to process or validate
 * price numbers that do not conform to the expected format rules.
 * 
* 	@author [Chandler Higgins (Student #: 40156534), Zayd-Khomayne Boucaud (Student #: 40157754)]

 */
public class BadPriceException extends Exception {

	
	 /**
     * Constructs a new BadPriceException with the specified detail message.
     *
     * @param str the detail message (which is saved for later retrieval
     *            by the `getMessage()` method).
     */
	public BadPriceException(String str) {
		super(str);
	}
}
