/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
package Person;

import java.io.Serializable;

/**
 * @author sjb19
 *
 */
public class WaitList implements Serializable{
	PersonNode next;
	PersonNode last;
	/**
	 *@Specifications: no argument constructor that initializes the instance variables
	 *@Param: none
	 *@Precondition: the instance variables must exist
	 *@Postcondition: sets the instance variables to null
	 *@Exceptions: none
	 *@Throws: none
	 */
	public WaitList() {
		next = null;
		last = null;
	}
	/**
	 *@Specifications: Method that adds a member to the queue
	 *@Param: takes a Person argument
	 *@Precondition: the person must exist
	 *@Postcondition: sets the person to the first place if the waitlist is empty
	 *@Exceptions: none
	 *@Throws: none
	 */
	public void enque(Person person) {
		PersonNode newPerson = new PersonNode(person);
		if (next == null) {
			next = newPerson;
			last = next;
		} else {
			last.setLink(newPerson);
			last = newPerson;
		}
	}
	/**
	 *@Specifications: method that removes a person from the waitlist
	 *@Param: none
	 *@Precondition: the person must be present in the waitlist
	 *@Postcondition: retruns the person's information
	 *@Exceptions: none
	 *@Throws: none
	 */
	public Person remove() {
		Person person = next.getPerson();
		next = next.getLink();
		return person;
	}
	/**
	 *@Specifications: method that reads the members in the waitlist
	 *@Param: none
	 *@Precondition: the list must exist
	 *@Postcondition: returns the information of the list
	 *@Exceptions: none
	 *@Throws: none
	 */
	public String readQue() {
		String info = "";
		PersonNode cursor = next;
		while (cursor != null) {
			info += cursor.getPerson().toString() + "\n";
			cursor = cursor.getLink();
		}
		return info;
	}
	/**
	 *@Specifications: method that makes sure the waitlist is not empty before it searches through
	 *@Param: none
	 *@Precondition: the list must exist
	 *@Postcondition: returns true if the list is not empty
	 *@Exceptions: none
	 *@Throws: none
	 */
	public boolean hasNext() {
		if (next != null) {
			return true;
		} else {
			return false;
		}
	}
}
