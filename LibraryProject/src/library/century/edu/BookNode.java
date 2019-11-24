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
 * @author sjb19 BookNode class store books in a linked list that members have
 *         currently checked out.
 */
public class BookNode {
  private Book data;
	private BookNode link;

	/**
	 * @param data
	 * @param link
	 */
	public BookNode(Book data, BookNode link) {
		super();
		this.data = data;
		this.link = link;
	}
	
	public BookNode(Book data) {
		this.data=data;
		this.link=null;
	}
	
	public BookNode() {
		this.data=null;
		this.link=null;
	}

	/**
	 * @Discription: get course data 
	 * @precondition: none
	 * @postcondition: none
	 * @throws: none
	 * @return
	 */
	public Book getData() {
		return data;
	}

	/**
	 * @Discription: set data 
	 * @precondition: set course data
	 * @postcondition: none
	 * @throws: none
	 * @param data
	 */
	public void setData(Book data) {
		this.data = data;
	}

	/**
	 * @Discription: get link of course data
	 * @precondition: none
	 * @postcondition: none
	 * @throws: none
	 * @return
	 */
	public BookNode getLink() {
		return link;
	}

	/**
	 * @Discription: set link of data 
	 * @precondition: changes link of data
	 * @postcondition: none
	 * @throws: none
	 * @param link
	 */
	public void setLink(BookNode link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "BookNode [data=" + data + ", link=" + link + "]";
	}
}
