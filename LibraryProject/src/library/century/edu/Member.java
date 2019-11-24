package library.century.edu;

/**
 * @Specifications:
 * @Param:
 * @Precondition:
 * @Postcondition:
 * @Exceptions:
 * @Throws:
 */
public class Member extends Person {
	private double fees;
	private CheckedOutBooks books;

	/**
	 * @Specifications:
	 * @Param:
	 * @Precondition:
	 * @Postcondition:
	 * @Exceptions:
	 * @Throws:
	 */
	public Member(String name, int contact, int member, double fees, CheckedOutBooks books) {
		super(name, contact, member, fees);
		this.books = books;
	}

	public Member(String name, int contact, int member, double fees) {
		super(name, contact, member, fees);
		books = new CheckedOutBooks();
	}

	/**
	 * @Specifications:
	 * @Param:
	 * @Precondition:
	 * @Postcondition:
	 * @Exceptions:
	 * @Throws:
	 */
	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public CheckedOutBooks getBook() {
		return books;
	}

	public void setBook(CheckedOutBooks book) {
		this.books = book;
	}

	/**
	 * @Specifications: CheckOut() checks out a book and adds it to the members
	 *                  linked List.
	 * @Param: Book book
	 * @Precondition: none
	 * @Postcondition: book will be added to the members Linked list.
	 */
	public void checkOut(Book book) {
		if (book.isCheckOut() == true) {
			book.getWaitList().enque(Member.this);
		} else {
			books.add(book);
		}
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
	public boolean returnBook(Book book) {
		if (books.remove(book)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * @Specifications:Charges a customer for any late books
	 * @Param:double fee
	 * @Precondition:
	 * @Postcondition: the amount the member owes will be increased
	 * @Throws:
	 */
	public void charge() {
		this.fees += 10.00;
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

	/**
	 * @Specifications:
	 * @Param:
	 * @Precondition:
	 * @Postcondition:
	 * @Exceptions:
	 * @Throws:
	 */
	/**
	 * public void search(Book book) { books.Search(book); }
	 */

	/**
	 * @Specifications:
	 * @Param:
	 * @Precondition:
	 * @Postcondition:
	 * @Exceptions:
	 * @Throws:
	 */
	@Override
	public String toString() {
		return "Member [fees=" + fees + ", book=" + books + "]";
	}

	/**
	 * @Specifications:
	 * @Param:
	 * @Precondition:
	 * @Postcondition:
	 * @Exceptions:
	 * @Throws:
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Member)) {
			return false;
		}
		Member newMember = (Member) obj;
		if (this.fees == newMember.fees && this.books.equals(newMember.books)) {
			return true;
		}
		return false;
	}
	
	public String readCheckedOut() {
		return books.readAll();
	}
}