/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
package library.century.edu;

/**
 * @author sjb19 Class Designed to hold a collection of books that are in a
 *         libraries collection.
 */
public class BookCollection {
	private Book books;
	private Book_Node head;
	private int size;

	public Book getBooks() {
		return books;
	}

	public void setBooks(Book books) {
		this.books = books;
	}

	/**
	 * @Specifications: add() method used to add a function to the libraries
	 *                  collection.
	 * @Param: Book book
	 * @Precondition: book must not be null
	 * @Postcondition: book will be added to the array
	 * @throws thorws NullPointerException
	 */
	public void add(Book books) {
		Book_Node newNode = new Book_Node(books, head);
		head = newNode;
	}
	

	/**
	 * @Specifications: removed(Book book)
	 * @Param: Book book
	 * @Precondition: book must be found or will return false.
	 * @Postcondition: book will be removed from the collection
	 * @Throws: none.
	 */

	public void remove(Book books) {
        if (head != null){
          if (books.equals(head.getData())){
              head = head.getLink();
          }
          else {
            Book_Node current = head.getLink();
            Book_Node previous = head;
            while(current != null){
              if (current.getData().equals(books)) {
                previous.setLink(current.getLink());
                previous = current;
                current = current.getLink();
                return;
              }
            }
          }
        }
	}

	

	/**
	 * @Specifications: search the collection for a book
	 * @Param: T book using a generic method to search by any of the books data.
	 * @Precondition: collection must not be null
	 * @Postcondition: returns the book if found.
	 * @Throws: none
	 */
	public <T> Book Search(T book) {
		return null;
	}

	/**
	 * @Specifications: Increased the capacity of the array where the collection is
	 *                  stored.
	 * @Param: none
	 * @Precondition:
	 * @Postcondition: increases the size of the array.
	 * @Throws:
	 */
	public void ensureCapacity() {

	}

/**
 *@Specifications: checks to see if the array is empty
 *@Param: none
 *@Precondition: none
 *@Postcondition: returns true if empty.
 *@Throws:
 */
public void isEmpty() {
	
}
}
