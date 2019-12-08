package Person;
import Books.Book;
import Books.BookCollection;
import helpers.Sorting;

public class TestDriver {

	public static void main(String[] args) {
		Book book1 = new Book("abe", "erer", "hello");
		Book book2 = new Book("bob", "deer", "goodbye");
		Book book3 = new Book("cat", "cow", "gbye");
		Book book4 = new Book("dog", "bat", "gbye");
		Book book5 = new Book("ele", "ana", "gbye");
		BookCollection bookCollection = new BookCollection();
		bookCollection.add(book1);
		bookCollection.add(book2);
		bookCollection.add(book3);
		bookCollection.add(book4);
		Sorting.bookMergeSortByTitle(bookCollection.getBooks(),0,bookCollection.getManyBooks());
		System.out.println(bookCollection.SearchByTitle(book2));
	}
}
