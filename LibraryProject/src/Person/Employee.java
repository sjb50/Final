/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */


/**
 * @author sjb19 Child class of parent used to store employee data.
 */

public class Employee extends Person{
	private String password;
	
	public Employee(String name, int contact) {
		super(name, contact);
		this.password = " ";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
