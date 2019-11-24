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
		bookCollection.add(book1);
		bookCollection.add(book2);
		bookCollection.add(book3);
		sam.checkOut(book1);
		System.out.println(book1.isCheckOut());
		matt.checkOut(book1);
		System.out.println(sam+"\n"+sam.readCheckedOut());
		System.out.println(book1+"\n"+book1.getWaitList().readQue());
	}
}
