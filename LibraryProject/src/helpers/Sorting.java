/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
package helpers;

import Books.Book;
import Books.BookCollection;

/**
 * @author sjb19
 *
 */
public class Sorting implements Comparable {

	public static void bookMergeSortByTitle(Book[] array, int first, int n) {
		int n1;
		int n2;
		if (n > 1) {
			n1 = n / 2;
			n2 = n - n1;
			bookMergeSortByTitle(array, first, n1);
			bookMergeSortByTitle(array, first + n1, n2);
			titleMerge(array, first, n1, n2);
		}
	}

	public static void titleMerge(Book[] data, int first, int n1, int n2) {
		Book[] temp = new Book[n1 + n2];
		int copied = 0;
		int copied1 = 0;
		int copied2 = 0;
		while ((copied1 < n1) && (copied2 < n2)) {
			if (data[first + copied1].getTitle().compareTo(data[first + n1 + copied2].getTitle()) < 0) {
				temp[copied++] = data[first + (copied1++)];
			} else {
				temp[copied++] = data[first + n1 + (copied2++)];
			}
		}
		while (copied1 < n1)
			temp[copied++] = data[first + (copied1++)];
		for (int count = 0; count < copied; count++) {
			data[first + count] = temp[count];
		}
	}
	

		public static void bookMergeSortByAuthor(Book[] array, int first, int n) {
			int n1;
			int n2;
			if (n > 1) {
				n1 = n / 2;
				n2 = n - n1;
				bookMergeSortByAuthor(array, first, n1);
				bookMergeSortByAuthor(array, first + n1, n2);
				AuthorMerge(array, first, n1, n2);
			}
		}

		public static void AuthorMerge(Book[] data, int first, int n1, int n2) {
			Book[] temp = new Book[n1 + n2];
			int copied = 0;
			int copied1 = 0;
			int copied2 = 0;
			while ((copied1 < n1) && (copied2 < n2)) {
				if (data[first + copied1].getAuthor().compareTo(data[first + n1 + copied2].getAuthor()) < 0) {
					temp[copied++] = data[first + (copied1++)];
				} else {
					temp[copied++] = data[first + n1 + (copied2++)];
				}
			}
			while (copied1 < n1)
				temp[copied++] = data[first + (copied1++)];
			for (int count = 0; count < copied; count++) {
				data[first + count] = temp[count];
			}
		}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
