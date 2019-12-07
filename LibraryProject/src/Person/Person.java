package Person;

import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private String contact;
	private static int idCounter=1000;
	private int Id;
	
	public Person(String name, String contact) {
		this.name = name;
		this.contact = contact;
		Id = idCounter;
		idCounter += 10;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String toString() {
		return "Person:" + name + ",\ncontact:" + contact + "\nId:"+Id;
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
		if (this.name.equals(newPerson.name) && this.contact == newPerson.contact && this.Id == newPerson.Id) {
			return true;
		}
		return false;
	}
}