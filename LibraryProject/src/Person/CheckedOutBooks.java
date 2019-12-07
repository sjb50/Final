/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
package Person;

import Books.Book;

/**
 * @author sjb19
 *
 */
public class CheckedOutBooks {
	private BookNode head;
	
	public CheckedOutBooks(){
		head=new BookNode();
	}
	
	protected void add(Book book) {
		if (head==null) {
			head = new BookNode(book);
		}
		else {
			BookNode newBook = new BookNode(book);
			newBook.setLink(head);
			head=newBook;
		}
	}
	
	protected boolean remove(Book book) {
		BookNode preCursor = head;
		BookNode cursor = head.getLink();
		if (head.getData().equals(book)) {
			head=head.getLink();
			return true;
		}
		while (cursor.getLink()!=null) {
			if (cursor.getData().equals(book)) {
				preCursor.setLink(cursor.getLink());
				return true;
			}
			preCursor=cursor;
			cursor=cursor.getLink();
		}
		return false;
	}
	
	public String readAll() {
		String read = "";
		BookNode cursor = head;
		while (cursor.getLink()!=null) {
			read+=cursor.getData()+"\n";
			cursor=cursor.getLink();
		}
		return read;
	}
}
