public class TestDriver {

	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Throws:
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		PersonCollection collection = new PersonCollection();
		Member matt = new Member("matt", 0);
		Member sam = new Member("sam", 0);
		Book book1 = new Book("hello", "hello", "hello", "hello");
		Book book2 = new Book("goodbye", "goodbye", "goodbye", "goodbye");
		Book book3 = new Book("go", "gye", "gbye", "gye");
		BookCollection bookCollection = new BookCollection();
		bookCollection.add(book1);
		bookCollection.add(book2);
		bookCollection.add(book3);
		sam.checkOut(book1);
		sam.checkOut(book2);
		sam.getFees();
		sam.charge(bookCollection,book1);
		
	
		matt.checkOut(book1);
		System.out.println(book1+"\n"+book1.getWaitList().readQue());
		System.out.println(sam+"\n"+sam.readCheckedOut());
		
	}
}