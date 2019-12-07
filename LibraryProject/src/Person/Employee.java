package Person;


/**
 * @author sjb19 Child class of parent used to store employee data.
 */

public class Employee extends Person{
	private String password;
	
	public Employee(String name, String contact, String password) {
		super(name, contact);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
