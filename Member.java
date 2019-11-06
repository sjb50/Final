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
 * @author sjb19 Defines what a member is. used to store their
 *         name,id,email,ect. super class of person
 */
public class Member extends Person {

	/**
	 * @Specifications: CheckOut() checks out a book and adds it to the members
	 *                  linked List.
	 * @Param: Book book
	 * @Precondition: none
	 * @Postcondition: book will be added to the members Linked list.
	 */
	public void checkOut(Book book) {

	}

	/**
	 * @Specifications: returnBook() returns a book to become availably in the
	 *                  collection.
	 * @Param: Book book
	 * @Precondition: book must be in the memebers nodes.
	 * @Postcondition: book will be removed from the customer linked list of books
	 *                 and returned to the collection.
	 * @Throws:
	 */
	public void returnBook(Book book) {

	}

	/**
	 * @Specifications:Charges a customer for any late books
	 * @Param:double fee
	 * @Precondition:
	 * @Postcondition: the amount the member owes will be increased
	 * @Throws:
	 */
	public void charge(double fee) {

	}

	/**
	 * @Specifications: allows the member to pay their fines.
	 * @Param: double payment
	 * @Precondition: payment cannot be more than they owe.
	 * @Postcondition: payment will be taken and reduced from their fines.
	 * @Throws:
	 */
	public void payFee(double payment) {

	}
}
