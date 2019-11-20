
package library.century.edu;

/**
 * @author sjb19
 *
 */
public class Search {

	public static <T> int searchCollection(T[] collection, T value, String type) throws Exception {
		if (value instanceof Book) {
			return searchForBook(collection, value, type);
		}
		if (value instanceof Person) {
			return searchForPerson(collection, value, type);
		} else
			throw new Exception("Collection must be of books or people");
	}

	public static <T> int searchForBook(T[] collection, T value, String type) {
		switch (type) {
		case "title": {
			return 0;
		}
		case "author": {
			return 0;
		}
		case "bookId": {
			return 0;
		}
		}
		return 0;
	}

	public static <T> int searchForPerson(T[] collection, T value, String type) {
		switch (type) {
		case "first": {
			return 0;
		}
		case "last": {
			return 0;
		}
		case "phoneNumber": {
			return 0;
		}
		case "memberId": {
			return 0;
		}
		}
		return 0;
	}

}
