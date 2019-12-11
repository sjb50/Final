/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
package Person;

import java.io.Serializable;

import Books.Book;

/**
 * @author sjb19 BookNode class store books in a linked list that members have
 *         currently checked out. HERE
 */
public class BookNode implements Serializable{
  private Book data;
	private BookNode link;

	/**
	 * @Specifications: constructor that set the value of the instance variables
	 * @Param: Book and BookNode arguments
	 * @Precondition: they must exist
	 * @Postcondition: sets the value of the instance varible
	 * @Exceptions: none
	 * @Throws: none
	 */
	public BookNode(Book data, BookNode link) {
		super();
		this.data = data;
		this.link = link;
	}
	/**
	 * @Specifications: one argument constructor that sets the value of the instance variable data
	 * @Param: takes a Book argument
	 * @Precondition: the instance variable must exist 
	 * @Postcondition: sets the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public BookNode(Book data) {
		this.data=data;
		this.link=null;
	}
	/**
	 * @Specifications: no argument constructor that initialize the instance variables
	 * @Param: none
	 * @Precondition: the instance variables must exist
	 * @Postcondition: set the instance variables to null
	 * @Exceptions: none
	 * @Throws: none
	 */
	public BookNode() {
		this.data=null;
		this.link=null;
	}

	/**
	 * @Discription: get course data 
	 * @precondition: none
	 * @postcondition: none
	 * @throws: none
	 * @return
	 */
	public Book getData() {
		return data;
	}

	/**
	 * @Discription: set data 
	 * @precondition: set course data
	 * @postcondition: none
	 * @throws: none
	 * @param data
	 */
	public void setData(Book data) {
		this.data = data;
	}

	/**
	 * @Discription: get link of course data
	 * @precondition: none
	 * @postcondition: none
	 * @throws: none
	 * @return
	 */
	public BookNode getLink() {
		return link;
	}

	/**
	 * @Discription: set link of data 
	 * @precondition: changes link of data
	 * @postcondition: none
	 * @throws: none
	 * @param link
	 */
	public void setLink(BookNode link) {
		this.link = link;
	}

	/**
	 * @Specifications: toString method that returns the information of the class
	 * @Param: none
	 * @Precondition: the instance variables must exist
	 * @Postcondition: returns the information of each instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public String toString() {
		return "BookNode [data=" + data + ", link=" + link + "]";
	}
}
