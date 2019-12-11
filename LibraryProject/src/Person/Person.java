package Person;

import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private String contact;
	private static int idCounter=2000;
	private int Id;
	/**
	 *@Specifications: Two arguments constructor that sets and saves the value of the instance variables
	 *@Param: takes two string arguments
	 *@Precondition: the instance variables must exist
	 *@Postcondition: sets and saves the value of the instance variables
	 *@Exceptions: none
	 *@Throws: none
	 */	
	public Person(String name, String contact) {
		this.name = name;
		this.contact = contact;
		Id = idCounter;
		idCounter += 10;
	}
	/**
	 *@Specifications: getter method for the instance variable idCounter
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */	
	public static int getIdCounter() {
		return idCounter;
	}
	/**
	 *@Specifications: setter method for the instance variable idCounter
	 *@Param: takes an int parameter
	 *@Precondition: the parameter must be greater than zero
	 *@Postcondition: sets the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */	
	public static void setIdCounter(int idCounter) {
		Person.idCounter = idCounter;
	}
	/**
	 *@Specifications: getter method for the instance variable name
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance varible
	 *@Exceptions: none
	 *@Throws: none
	 */	
	public String getName() {
		return name;
	}
	/**
	 *@Specifications: setter method for the instance variable name
	 *@Param: takes a string parameter
	 *@Precondition: the instance variable must exist
	 *@Postcondition: sets the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 *@Specifications: getter method for the instance variable contact
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */	
	public String getContact() {
		return contact;
	}
	/**
	 *@Specifications: Setter method for the instance variable contact
	 *@Param: takes a string argument
	 *@Precondition: the instance variable must exist
	 *@Postcondition: sets the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */	
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 *@Specifications: getter method for the instance variable id
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */	
	
	public int getId() {
		return Id;
	}
	/**
	 *@Specifications: setter method for the instance variable id
	 *@Param: gets an int argument
	 *@Precondition: the argument must be greater or equal to 1000
	 *@Postcondition: sets the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */	
	public void setId(int id) {
		Id = id;
	}
	/**
	 *@Specifications: toString method that returns the value of the person instance variables
	 *@Param: none
	 *@Precondition: the instnace variables must exist
	 *@Postcondition: returns the value of the instance variables
	 *@Exceptions: none
	 *@Throws: none
	 */	
	public String toString() {
		return "Name" + name + ",\ncontact:" + contact + "\nId:"+Id;
	}
	/**
	 *@Specifications: Clone method that makes a copy of the person class
	 *@Param: none
	 *@Precondition: the class must exist
	 *@Postcondition: makes the copy of the class
	 *@Exceptions: CloneNotSupported Exception
	 *@Throws: none
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
	 *@Specifications: equals method that compare two objects
	 *@Param: takes an object argument
	 *@Precondition: the objects must exist
	 *@Postcondition: returns true if the objects are the same
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
		if (this.name.equals(newPerson.name) && this.contact == newPerson.contact && this.Id == newPerson.Id
		   		&& this.idCounter == newPerson.idCounter) {
			return true;
		}
		return false;
	}
}
