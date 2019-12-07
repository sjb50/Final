package Person;

import java.io.Serializable;

/**
 * @author sjb19 Child class of parent used to store employee data.
 */

public class Employee extends Person implements Serializable{
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

	@Override
	public String toString() {
		return (super.toString())+"\npassword:" + password+"\n";
	}
	
	
}
