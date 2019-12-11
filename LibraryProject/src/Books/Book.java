package Books;

import java.io.Serializable;
import Person.WaitList;

public class Book implements Cloneable, Serializable, Comparable {

	private String author;
	private String title;
	private String picture;
	private boolean checkOut;
	private WaitList waitList;
	/**
	 * @Specifications: Constructor that set the instance variables of the Book class
	 * @Param: takes three String as parametters
	 * @Precondition: The author, title, and picture instance variables must exist
	 * @Postcondition: sets the value of the instance variables
	 * @Exceptions: none
	 * @Throws: none
	 */
	public Book(String author, String title, String picture) {
		super();
		this.author = author;
		this.title = title;
		this.picture = picture;
		this.checkOut = false;
		waitList = new WaitList();
	}
	/**
	 * @Specifications: Getter of the instance variable author
	 * @Param: none
	 * @Precondition: the instance variable must exist
	 * @Postcondition: returns the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @Specifications: setter method for the instance variable author
	 * @Param: takes a string
	 * @Precondition: the instance variable must exist
	 * @Postcondition: sets the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @Specifications: getter method for the instance variable title
	 * @Param: none
	 * @Precondition: the instance variable must exist
	 * @Postcondition: returns the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @Specifications: setter method for the instance variable title
	 * @Param: takes a string argument
	 * @Precondition: the instance variable must exist
	 * @Postcondition: sets the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @Specifications: getter method for the instance variable picture
	 * @Param: none
	 * @Precondition: the instance variable must exist
	 * @Postcondition: returns the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @Specifications: setter method for the instance variable picture
	 * @Param: takes a string argument
	 * @Precondition: the instance variable must exist
	 * @Postcondition: sets the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * @Specifications: getter method for the instance variable waitlist
	 * @Param: none
	 * @Precondition: the instance variable must exist
	 * @Postcondition: returns the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public WaitList getWaitList() {
		return waitList;
	}
	/**
	 * @Specifications: isCheckout method that returns a boolean
	 * @Param: none
	 * @Precondition: checkout must be existant
	 * @Postcondition: returns checkout
	 * @Exceptions: none
	 * @Throws: none
	 */
	public boolean isCheckOut() {
		return checkOut;
	}
	/**
	 * @Specifications: setter method for the instance variable checkout
	 * @Param: takes a boolean argument
	 * @Precondition: the instance variable must be existant
	 * @Postcondition: sets the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}
	/**
	 * @Specifications: Equals method that compares two objects 
	 * @Param: takes an Object argument
	 * @Precondition: the object must be existant
	 * @Postcondition: returns true if the two objects have the same information
	 * @Exceptions: none
	 * @Throws: none
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (checkOut != other.checkOut)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	/**
	 * @Specifications: Clone method that makes the copy of the class
	 * @Param: none
	 * @Precondition: that class must exist
	 * @Postcondition: makes the exact copy of the class
	 * @Exceptions: none
	 * @Throws: CloneNotSuppertedException
	 */
	protected Book clone() throws CloneNotSupportedException {
		return (Book) super.clone();
	}
	/**
	 * @Specifications: toString method that returns the information of the class
	 * @Param: none
	 * @Precondition: the instance variables must exist
	 * @Postcondition: returns the value of each instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public String toString() {
		return "\nTitle:" + title + "\nAuthor:"+ author+"\nAvailable: " + !checkOut ;
	}
	/**
	 * @Specifications: compareTo method that compare two objects
	 * @Param: takes an object argument
	 * @Precondition: the objects must exist
	 * @Postcondition: returns 0
	 * @Exceptions: none
	 * @Throws: none
	 */
	public int compareTo(Object o) {
		return 0;
	}
}
