
public class Employee {
	private Person person;
	private int id;
	private String password;
	
	public Employee(Person person, int id, String password) {
		super();
		this.person = person;
		this.id = id;
		this.password = password;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
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
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if(!(obj instanceof Employee)) {
			return false;
		}
		Employee newEmployee = (Employee) obj;
		if (this.password.equals(newEmployee.password)&& this.id == newEmployee.id
				&& this.person.equals(newEmployee.person)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Employee [person=" + person + ", id=" + id + ", password=" + password + "]";
	}
 }
