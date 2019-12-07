package Person;
import Books.Book;
import Books.BookCollection;

public class Member extends Person {
	private double fees;
	private CheckedOutBooks books;
	
	/**
	 * @Specifications:Constructor that set the instance variables of the Member class
	 * @Param:gets the name, contact of the member, membership and the books
	 * @Precondition: The instance variables must exist
	 * @Postcondition: set the instance variables according to their type
	 * @Exceptions: none
	 * @Throws: none
	 */
	public Member(String name, String contact) {
		super(name, contact);
		this.books = new CheckedOutBooks();
		this.fees = 0;
	}

	public Member(String name, String contact, int member) {
		super(name, contact);
		books = new CheckedOutBooks();
		this.fees = 0;
	}

	/**
	 * @Specifications: Getters and setters of the instance variables
	 * @Param: getters don't get parameters, the Setters get one parameter of the type of the instance variable
	 * @Precondition: the instance variables must exist
	 * @Postcondition: Getters return the value of the instance variable, the setters set the value of the instance variable
	 * @Exceptions: none
	 * @Throws:none
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
	 * @Specifications: CheckOut() checks out a book and adds it to the member's linked list
	 * @Param:Book book
	 * @Precondition: none
	 * @Postcondition: book will be added to the member's Linked list
	 * @Exceptions:none
	 * @Throws: none
	 */
	public void checkOut(Book book) {
		if (book.isCheckOut() == true) {
			book.getWaitList().enque(Member.this);
		} else {
			book.setCheckOut(true);
			books.add(book);
		}
	}

	/**
	 * @Specifications: returnBook() returns a book to become available in the collection
	 * @Param:Book book
	 * @Precondition:book must be in the member's nodes
	 * @Postcondition: book will be removed from the customer linked list of books and returned to the collection
	 * @Exceptions:none
	 * @Throws:none
	 */
	public boolean returnBook(Book book) {
		if (books.remove(book)) {
			book.setCheckOut(false);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @Specifications: Charges a customer for any missing books
	 * @Param: BookCollection and the book not found
	 * @Precondition: none
	 * @Postcondition: charge $10 for the missing book 
	 * @Exceptions: none
	 * @Throws:none
	 */

	public void charge(BookCollection collection, Book book) {
		if (collection.remove(book)) {
			books.remove(book);
			fees = 10;
		}
	}

	/**
	 * @Specifications: Allows the member to pay their fines
	 * @Param: double payment
	 * @Precondition: payment cannot be more than they owe
	 * @Postcondition: payment will be taken and reduced from their fines
	 * @Exceptions:none
	 * @Throws:none
	 */
	public void payFee(double payment) {
		
	  fees=-payment;
	}

	/**
	 * @Specifications: search method that searches for a book according to the parameter entered by the member
	 * @Param: takes the book information that is used for the search
	 * @Precondition: The bookCollection must exist
	 * @Postcondition: reach the book from the book collection
	 * @Exceptions:none
	 * @Throws:none
	 */
	
	  public void search(BookCollection collection,Book book) { 
		  collection.Search(book);
		  }


	/**
	 * @Specifications: Equals method that test whether or not a new member is an instance of the Member class
	 * @Param: gets an object as parameter
	 * @Precondition: none
	 * @Postcondition: tell whether or not the new member is part of the member class
	 * @Exceptions: none
	 * @Throws:none
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
	/**
	 * @Specifications: method that returns all the books of a member
	 * @Param: none
	 * @Precondition: none
	 * @Postcondition: return the list of all the books checked out by the member
	 * @Exceptions: none
	 * @Throws: none
	 */
	public String readCheckedOut() {
		return books.readAll();
	}

	@Override
	public String toString() {
		return "Member [Name =" + super.getName() + ", Id=" + super.getId() + " fees=" + fees + "]";
	}

	
}