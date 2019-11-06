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

	/**
	 * @Specifications: add() method used to add a function to the libraries
	 *                  collection.
	 * @Param: Book book
	 * @Precondition: book must not be null
	 * @Postcondition: book will be added to the array
	 * @throws thorws NullPointerException
	 */
	public void add(Book book) {

	}

	/**
	 * @Specifications: removed(Book book)
	 * @Param: Book book
	 * @Precondition: book must be found or will return false.
	 * @Postcondition: book will be removed from the collection
	 * @Throws: none.
	 */
	public boolean remove() {
		return true;
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