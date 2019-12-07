
package Person;

/**
 * Parent class to both member and employee.
 * used to store similar data.
 *test
 */

public class Person {
	private String name;
	private int contact;
	private int member;
	private double fees;
	
	public Person(String name, int contact, int member, double fees) {
		this.name = name;
		this.contact = contact;
		this.member = member;
		this.fees = fees;
	}
	
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
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}

	public String toString() {
		return "Person [name=" + name + ", contact=" + contact + ", member=" + member + ", fees=" + fees + "]";
	}
	
	protected Object clone() {
		Person newPerson = null;
		try {
			newPerson = (Person) super.clone();
		}catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return newPerson;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person newPerson = (Person) obj;
		if (this.name.equals(newPerson.name) && this.contact == newPerson.contact
				&& this.member == newPerson.member && this.fees == newPerson.fees) {
			return true;
		}
		return false;
	}
}
