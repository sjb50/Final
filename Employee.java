/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
public class Employee extends Person{
	private int id;
	private String password;
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public Employee(String name, int contact, int member,double fees, int id, String password) {
		super(name, contact, member, fees);
		this.id = id;
		this.password = password;
	}
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if(!(obj instanceof Employee)) {
			return false;
		}
		Employee newEmployee = (Employee) obj;
		if (this.password.equals(newEmployee.password)&& this.id == newEmployee.id) {
			return true;
		}
		return false;
	}
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", password=" + password + "]";
	}
 }
