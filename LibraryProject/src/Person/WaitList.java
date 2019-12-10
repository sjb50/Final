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

	public WaitList() {
		next = null;
		last = null;
	}

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

	public Person remove() {
		Person person = next.getPerson();
		next = next.getLink();
		return person;
	}

	public String readQue() {
		String info = "";
		PersonNode cursor = next;
		while (cursor != null) {
			info += cursor.getPerson().toString() + "\n";
			cursor = cursor.getLink();
		}
		return info;
	}

	public boolean hasNext() {
		if (next != null) {
			return true;
		} else {
			return false;
		}
	}

}
