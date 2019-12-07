/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
package Books;

/**
 * @author sjb19 Class Designed to hold a collection of books that are in a
 *         libraries collection.
 */
public class BookCollection {
	private int size;
	final int initialCapacity = 100;
	private Book[] books;

	public BookCollection() {
		size=0;
		books = new Book[initialCapacity];
	}

	/**
	 * @Specifications: add() method used to add a function to the libraries
	 *                  collection.
	 * @Param: Book book
	 * @Precondition: book must not be null
	 * @Postcondition: book will be added to the array
	 * @throws thorws NullPointerException
	 */
	public void add(Book book) {
		for (int count = 0; count < size; count++) {
			if (books[count] == null) {
				books[count] = book;
				++size;
				return;
			}
		}
		if (size >= books.length) {
			ensureCapacity();
		}

		books[size++] = book;
	}

	/**
	 * @return
	 * @Specifications: removed(Book book)
	 * @Param: Book book
	 * @Precondition: book must be found or will return false.
	 * @Postcondition: book will be removed from the collection
	 * @Throws: none.
	 */

	public boolean remove(Book book) {
		int indexOfBooks = -1;
		for (int i = 0; i < size; i++) {
			if (book.equals(books[i])) {
				books[i] = null;
				--size;
				return true;
			}
		}
		return false;

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
		Book[] expandedBooks = new Book[books.length * 2 + 1];
		for (int i = 0; i < books.length; i++) {
			expandedBooks[i] = books[i];
		}

		books = expandedBooks;
	}

/**
 *@Specifications: checks to see if the array is empty
 *@Param: none
 *@Precondition: none
 *@Postcondition: returns true if empty.
 *@Throws:
 */
public void isEmpty() {
	 if (books == null) {
            System.out.println("There are no books.");
            return;
        }
           for (int i = 0; i < books.length; i++) {
        	   if (books != null) {
        		   System.out.println( books[i]);
        	   }
		}
        
}

public Book[] getBooks() {
	return books;
}

public void setBooks(Book[] books) {
	this.books = books;
}
}