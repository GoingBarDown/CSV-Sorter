package Driver;

import java.io.Serializable;

/**
*
*This class represents a book, with attributes such as title, author(s), price, ISBN number, genre, and publication year.
*Each attribute can be accessed and modified through getter and setter methods.
*The class also provides a toString() method for printing the book's information in a formatted string.
** 	@author [Chandler Higgins (Student #: 40156534), Zayd-Khomayne Boucaud (Student #: 40157754)]
*/
public class Book implements Serializable {
	
	
	private String title;
	private String author;
	private double price;
	private long ISBN;
	private String genre;
	private int year;
	
	/**
	Returns the title of the book.
	@return title the title of the book.
	*/
	
	public String getTitle() {
		return title;
	}
	
	/**
	Sets the title of the book.
	@param title the new title of the book.
	*/
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	Returns the author(s) of the book.
	@return authors the author(s) of the book.
	*/
	
	public String getAuthors() {
		return author;
	}
	
	/**
	Sets the author(s) of the book.
	@param author the new author(s) of the book.
	*/
	
	public void setAuthors(String author) {
		this.author = author;
	}
	
	/**
	Returns the price of the book.
	@return price the price of the book.
	*/
	
	public double getPrice() {
		return price;
	}
	
	/**
	Sets the price of the book.
	@param price the new price of the book.
	*/
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	Returns the ISBN number of the book.
	@return isbn the ISBN number of the book.
	*/
	
	public long getIsbn() {
		return ISBN;
	}
	
	/**
	Sets the ISBN number of the book.
	@param isbn the new ISBN number of the book.
	*/
	
	public void setIsbn(long isbn) {
		this.ISBN = isbn;
	}
	
	/**
	Returns the genre of the book.
	@return genre the genre of the book.
	*/
	
	public String getGenre() {
		return genre;
	}
	
	/**
	Sets the genre of the book.
	@param genre the new genre of the book.
	*/
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	Returns the publication year of the book.
	@return year the publication year of the book.
	*/
	
	public int getYear() {
		return year;
	}
	
	/**
	Sets the publication year of the book.
	@param year the new publication year of the book.
	*/
	
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	Returns a string representation of the book, including its title, author(s), price, ISBN number, genre, and publication year.
	@return string a string representation of the book.
	*/
	public String toString() {
		return "Title: " + title + "\nAuthor: " + author + "\nPrice: " + price + "\nISBN: " + ISBN + "\nGenre: " + genre + "\nYear: " + year;
	}
}
