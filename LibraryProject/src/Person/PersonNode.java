package Person;
public class PersonNode {
	Person person;
	PersonNode link;
	/**
	 *@Specifications: One argument constructor that sets the value of the instance variables
	 *@Param: takes a Person argument
	 *@Precondition: the person must exist
	 *@Postcondition: sets the person's inforamtion and initializes the link instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public PersonNode(Person person) {
		this.person=person;
		link=null;
	}
	/**
	 *@Specifications: getter method for the instance variable person
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 *@Specifications: setter method for the instance variable person
	 *@Param: takes a Person argument
	 *@Precondition: the person must exist
	 *@Postcondition: sets the information of the person instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 *@Specifications: getter method for the instance variable link
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public PersonNode getLink() {
		return link;
	}
	/**
	 *@Specifications: setter method for the instance variable link
	 *@Param: takes a PersonNode argument
	 *@Precondition: the Node must exist
	 *@Postcondition: sets the information of the link instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public void setLink(PersonNode link) {
		this.link = link;
	}
}
