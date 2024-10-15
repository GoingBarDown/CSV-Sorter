package Exceptions;


/**
 * The `MissingFieldException` class is an exception that is thrown to indicate
 * an error related to missing fields in a book record.
 * 
 * This exception is typically thrown when attempting to process data records
 * with missing or empty required fields.
 * 
 * 	@author [Chandler Higgins (Student #: 40156534), Zayd-Khomayne Boucaud (Student #: 40157754)]
 */
public class MissingFieldException extends Exception {
	
	 /**
     * Constructs a new MissingFieldException with the specified detail message.
     *
     * @param str the detail message (which is saved for later retrieval
     *            by the `getMessage()` method).
     */
	public MissingFieldException(String str) {
		super(str);
	}
}
