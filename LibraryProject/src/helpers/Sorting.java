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
public class Sorting implements Comparable{
	
	public static Book[] bookSortByTitle(BookCollection array) {
		Book[] sortedBooks =array.getBooks();
		boolean sorted=false;
		while (!sorted) {
			int count=0;
			sorted=true;
			if (sortedBooks[count].getTitle().compareTo(sortedBooks[count+1].getTitle())>0) {
				Book temp = sortedBooks[count];
				sortedBooks[count]=sortedBooks[count+1];
				sortedBooks[count+1]=temp;
				sorted=false;
				count++;
			}
		}
		return sortedBooks;
	}
	
	/**public static Book[] bookSortByAuthor(BookCollection array) {
		
	}*/

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
