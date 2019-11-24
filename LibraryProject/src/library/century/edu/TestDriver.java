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
 * @author sjb19
 *
 */
public class TestDriver {

	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Throws:
	 */
	public static void main(String[] args) {
		PersonCollection collection = new PersonCollection();
		Member matt = new Member("matt", 0, 0, 0);
		Book book1 = new Book("hello", "hello", "hello", "hello");
		Book book2 = new Book("goodbye", "goodbye", "goodbye", "goodbye");
		Book book3 = new Book("go", "gye", "gbye", "gye");
		BookCollection bookCollection = new BookCollection();
		collection.add(matt);
		matt.checkOut(book1);
		matt.checkOut(book2);
		matt.returnBook(book2);
		matt.checkOut(book3);
		System.out.println(matt.readCheckedOut());
	}
}
