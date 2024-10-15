package Exceptions;


/**
 * The `BadIsbn13Exception` class is an exception that is thrown to indicate
 * an error related to an invalid ISBN-13 format.
 * 
 * This exception is typically thrown when attempting to process or validate
 * ISBN-13 numbers that do not conform to the expected format rules.
 * 
* 	@author [Chandler Higgins (Student #: 40156534), Zayd-Khomayne Boucaud (Student #: 40157754)]

 */
public class BadIsbn13Exception extends Exception {

	 /**
     * Constructs a new BadIsbn13Exception with the specified detail message.
     *
     * @param str the detail message (which is saved for later retrieval
     *            by the `getMessage()` method).
     */
	public BadIsbn13Exception(String str) {
		super(str);
	}
}
