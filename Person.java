/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
public class Person {
	private String name;
	private int contact;
	private int memberId;
	private double fees;
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public Person(String name, int contact, int member, double fees) {
		this.name = name;
		this.contact = contact;
		this.memberId = member;
		this.fees = fees;
	}
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int member) {
		this.memberId = member;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}

	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public String toString() {
		return "Person [name=" + name + ", contact=" + contact + ", member=" + memberId + ", fees=" + fees + "]";
	}
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	protected Object clone() {
		Person newPerson = null;
		try {
			newPerson = (Person) super.clone();
		}catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return newPerson;
	}
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person newPerson = (Person) obj;
		if (this.name.equals(newPerson.name) && this.contact == newPerson.contact
				&& this.memberId == newPerson.memberId && this.fees == newPerson.fees) {
			return true;
		}
		return false;
	}
}
