package Person;

import java.io.Serializable;

/**
 * @author sjb19 Child class of parent used to store employee data.
 */

public class Employee extends Person implements Serializable{
	private String password;
	/**
	 *@Specifications: Constructor that contain the value of the instance variable
	 *@Param: takes three string arguments
	 *@Precondition: the instance variable must exist
	 *@Postcondition: receive and save the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public Employee(String name, String contact, String password) {
		super(name, contact);
		this.password = password;
	}
	/**
	 *@Specifications: getter method for the instance variable password
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *@Specifications: Setter method for the instance variable password
	 *@Param: takes a string argument
	 *@Precondition: the instance variable must exist
	 *@Postcondition: sets the value of the instance variable password
	 *@Exceptions: none
	 *@Throws: none
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 *@Specifications: toString method that return the information of the employee class
	 *@Param: none
	 *@Precondition: the class and instance variable must exist
	 *@Postcondition: returns the information of the employee class
	 *@Exceptions: none
	 *@Throws: none
	 */
	public String toString() {
		return (super.toString())+"\npassword:" + password+"\n";
	}
}
