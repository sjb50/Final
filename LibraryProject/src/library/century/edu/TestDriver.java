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
		Member sam = new Member("sam", 0, 0, 0);
		Book book1 = new Book("hello", "hello", "hello", "hello");
		Book book2 = new Book("goodbye", "goodbye", "goodbye", "goodbye");
		Book book3 = new Book("go", "gye", "gbye", "gye");
		BookCollection bookCollection = new BookCollection();
		PersonCollection peopleCollection = new PersonCollection();
		peopleCollection.add(matt);
		peopleCollection.add(sam);
		collection.add(matt);
		matt.checkOut(book1);
		matt.checkOut(book2);
		matt.returnBook(book2);
		matt.checkOut(book3);
		System.out.println(peopleCollection.readAll());
		System.out.println(matt.readCheckedOut());
	}
}
