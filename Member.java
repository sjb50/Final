
public class Member{
	private Person person;
	private double fees;
	private BookNode book;
	
	public Member(Person person, double fees, BookNode book) {
		super();
		this.person = person;
		this.fees = fees;
		this.book = book;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public BookNode getBook() {
		return book;
	}

	public void setBook(BookNode book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Member [person=" + person + ", fees=" + fees + ", book=" + book + "]";
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Member)) {
			return false;
		}
		Member newMember = (Member)obj;
		if (this.person.equals(newMember.person) && this.fees==newMember.fees 
				&& this.book.equals(newMember.book)) {
			return true;
		}
		return false;
	}
	
	

}
