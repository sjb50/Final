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
	private BookNode head;
	private int size;
	final int initialCapacity = 100;
        private Book[] books;


	/**
	 * @Specifications: add() method used to add a function to the libraries
	 *                  collection.
	 * @Param: Book book
	 * @Precondition: book must not be null
	 * @Postcondition: book will be added to the array
	 * @throws thorws NullPointerException
	 */
	public void add(Book books) {
		BookNode newNode = new BookNode(books, head);
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
            BookNode current = head.getLink();
            BookNode previous = head;
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
	Book[] expandedBooks = new Book[books.length * 2];
      	for (int i = 0; i < books.length; i++) {
       	 expandedBooks[i] = books[i];
      }
      
      	books = expandedbooks;
    }
	}

/**
 *@Specifications: checks to see if the array is empty
 *@Param: none
 *@Precondition: none
 *@Postcondition: returns true if empty.
 *@Throws:
 */
public void isEmpty() {
	Book_Node current = head;
        if (current == null) {
            System.out.println("No checkout books");
            return;
        }
        while (current != null) {
            System.out.println(current.getData());
            current = current.getLink();
        }
}
}

