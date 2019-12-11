/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
package Books;

import java.io.Serializable;

/**
 * @author sjb19 Class Designed to hold a collection of books that are in a
 *         libraries collection.
 */
public class BookCollection implements Serializable, Comparable {
	private int size;
	final int initialCapacity = 100;
	private Book[] books;
	private int manyBooks;

	public BookCollection() {
		size = 0;
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
				manyBooks++;
				return;
			}
		}
		if (size >= books.length) {
			ensureCapacity();
		}
		manyBooks++;
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
				t
				--size;
				manyBooks--;
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
	public Book SearchByAuthor(Book book) {
		int first = 0;
		int last = manyBooks;
		int middle = (first + last) / 2;
		while (first < last) {
			System.out.println(manyBooks);
			if (book.getAuthor().equals(books[middle].getAuthor())) {
				return book;
			}
			if (book.getAuthor().compareTo(books[middle].getAuthor()) > 0) {
				first = middle+1;
				middle = (first + last) / 2;
			} else {
				last = middle-1;
				middle = (first + last) / 2;
			}
		}
		return null;
	}
	/**
	 * @Specifications: SearchByTitle method that re
	 * @Param: takes a string argument
	 * @Precondition: none
	 * @Postcondition: returns the books if found
	 * @Exceptions: none
	 * @Throws: none
	 */
	public Book SearchByTitle(String book) {
		int first = 0;
		int last = manyBooks;
		int middle = (first + last) / 2;
		while (first < last) {
			System.out.println("here");
			if (book.equals(books[middle].getTitle())) {
				return books[middle];
			}
			if (book.compareTo(books[middle].getTitle()) > 0) {
				first = middle+1;
				middle = (first + last) / 2;
			} else {
				last = middle-1;
				middle = (first + last) / 2;
			}
		}
		return null;
	}

	public Book SearchByBook(Book book) {
		int first = 0;
		int last = manyBooks;
		int middle = (first + last) / 2;
		while (first < last) {
			System.out.println("here");
			if (book.equals(books[middle])) {
				return books[middle];
			}
			if (book.compareTo(books[middle]) > 0) {
				first = middle+1;
				middle = (first + last) / 2;
			} else {
				last = middle-1;
				middle = (first + last) / 2;
			}
		}
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
	 * @Specifications: checks to see if the array is empty
	 * @Param: none
	 * @Precondition: none
	 * @Postcondition: returns true if empty.
	 * @Throws:
	 */
	public void isEmpty() {
		if (books == null) {
			System.out.println("There are no books.");
			return;
		}
		for (int i = 0; i < books.length; i++) {
			if (books != null) {
				System.out.println(books[i]);
			}
		}
	}
	/**
	 * @Specifications: getter method for the instance variable ManyBook
	 * @Param: none
	 * @Precondition: the instance variable must exist
	 * @Postcondition: returns the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public int getManyBooks() {
		return manyBooks;
	}
	/**
	 * @Specifications: Getter method for the instance variable Books
	 * @Param: none
	 * @Precondition: the instance variable must exist
	 * @Postcondition: returns the value of the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public Book[] getBooks() {
		return books;
	}
	/**
	 * @Specifications: Setter method for the instance variable Books
	 * @Param: Takes an array of books
	 * @Precondition: the array and instance variables must exist
	 * @Postcondition: set the instance variable
	 * @Exceptions: none
	 * @Throws: none
	 */
	public void setBooks(Book[] books) {
		this.books = books;
	}
	/**
	 * @Specifications: Method that compare two objects
	 * @Param: takes an object argument
	 * @Precondition: theu must be existant
	 * @Postcondition: returns 0
	 * @Exceptions: none
	 * @Throws: none
	 */
	public int compareTo(Object book) {
		return 0;
	}
}
