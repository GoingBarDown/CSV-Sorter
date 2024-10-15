package Exceptions;


/**
 * The `BadIsbn10Exception` class is an exception that is thrown to indicate
 * an error related to an invalid ISBN-10 format.
 * 
 * This exception is typically thrown when attempting to process or validate
 * ISBN-10 numbers that do not conform to the expected format rules.
 * 
* 	@author [Chandler Higgins (Student #: 40156534), Zayd-Khomayne Boucaud (Student #: 40157754)]
 */
public class BadIsbn10Exception extends Exception {

	
	 /**
     * Constructs a new BadIsbn10Exception with the specified detail message.
     *
     * @param str the detail message (which is saved for later retrieval
     *            by the `getMessage()` method).
     */
	public BadIsbn10Exception(String str) {
		super(str);
	}
}
