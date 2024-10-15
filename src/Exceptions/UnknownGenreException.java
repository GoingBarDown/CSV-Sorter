package Exceptions;

/**
*
*This exception is thrown when an unknown or unsupported genre is encountered.
*A genre is a classification or category used to group works of literature, art, or other media.
*If a genre is not recognized or supported by the system, this exception is thrown.
*
* 	@author [Chandler Higgins (Student #: 40156534), Zayd-Khomayne Boucaud (Student #: 40157754)]
*/
public class UnknownGenreException extends Exception{
	/**
	Constructs a new UnknownGenreException with the specified detail message.
	@param str the detail message (which is saved for later retrieval by the getMessage() method)
	*/
	public UnknownGenreException(String str){
		super(str);
	}
	
}