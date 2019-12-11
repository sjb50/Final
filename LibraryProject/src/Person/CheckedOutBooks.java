
package Person;

import java.io.Serializable;

import Books.Book;
import Books.BookCollection;
import helpers.Sorting;

/**
 * @author sjb19
 *
 */
public class CheckedOutBooks implements Serializable{
	private BookNode head;
	private int numCheckedOut;
	/**
	 * @Specifications: Constructor that sets the value of the instance variable
	 * @Param: none
	 * @Precondition: the instance variable must exist
	 * @Postcondition: set the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public CheckedOutBooks(){
		head=new BookNode();
		numCheckedOut=0;
	}
	/**
	 * @Specifications: method that adds a book to the books the member checks out
	 * @Param: takes a Book argument
	 * @Precondition: the member and book must exist
	 * @Postcondition: adds the book of the collection of the member
	 * @Exceptions: none
	 * @Throws: none
	 */
	protected void add(Book book) {
		if (head==null) {
			head = new BookNode(book);
			head.setLink(null);
			numCheckedOut++;
		}
		else {
			BookNode newBook = new BookNode(book);
			newBook.setLink(head);
			head=newBook;
			numCheckedOut++;
		}
	}
	/**
	 * @Specifications: method that removes a book from the collection of the member
	 * @Param: takes a book argument
	 * @Precondition: the member and book must exist
	 * @Postcondition: removes the book from the collection of the member
	 * @Exceptions: none
	 * @Throws: none
	 */
	protected boolean remove(BookCollection collection,Book book) {
		Sorting.bookMergeSort(collection.getBooks(),0,collection.getManyBooks());
		Book bookInCollection = collection.SearchByBook(book);
		if (bookInCollection!=null) {
		BookNode preCursor = head;
		BookNode cursor = head.getLink();
		if (head.getData().equals(book)) {
			head=head.getLink();
			numCheckedOut--;
			bookInCollection.setCheckOut(false);
			return true;
		}
		while (cursor.getLink()!=null) {
			if (cursor.getData().equals(book)) {
				preCursor.setLink(cursor.getLink());
				numCheckedOut--;
				bookInCollection.setCheckOut(false);
				return true;
			}
			preCursor=cursor;
			cursor=cursor.getLink();
		}
		}
		return false;
	}
	/**
	 *@Specifications: method that returns the list of books checked out by a member
	 *@Param: none
	 *@Precondition: the member must exist
	 *@Postcondition: returns the list of books checked out by the member
	 *@Exceptions: none
	 *@Throws: none
	 */
	public Book[] popToArray() {
		Book[] list =new Book[numCheckedOut];
		BookNode cursor = head;
		int count=0;
		while (cursor.getData()!=null) {
			list[count]=cursor.getData();
			cursor=cursor.getLink();
			count++;
		}
		return list;
	}
	/**
	 *@Specifications: Getter method for the NumCheckOut instance variable
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public int getNumCheckedOut() {
		return numCheckedOut;
	}
	/**
	 *@Specifications: Setter method for the instance variable numCheckOut
	 *@Param: takes an interger argument
	 *@Precondition: The instance variable must be existant
	 *@Postcondition: Sets the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public void setNumCheckedOut(int numCheckedOut) {
		this.numCheckedOut = numCheckedOut;
	}
	
	/**
	 * @Specifications: method that reads all the books contain in the collection of a specific member
	 * @Param: none
	 * @Precondition: the member must exist
	 * @Postcondition: reads the book in the collection of the member
	 * @Exceptions: none
	 * @Throws: none
	 */
	public String readAll() {
		String read = "";
		BookNode cursor = head;
		while (cursor.getLink()!=null) {
			read+=cursor.getData().toString()+"\n\n";
			cursor=cursor.getLink();
		}
		return read;
	}
}
