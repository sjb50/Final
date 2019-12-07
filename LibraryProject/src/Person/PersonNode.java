package Person;
public class PersonNode {
	Person person;
	PersonNode link;
	
	public PersonNode(Person person) {
		this.person=person;
		link=null;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonNode getLink() {
		return link;
	}

	public void setLink(PersonNode link) {
		this.link = link;
	}
}