package Person;

import java.io.Serializable;

public class PersonCollection implements Cloneable, Serializable{
	private Person[] people;
	private int manyMembers;

	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public PersonCollection() {
		final int InitialCapacity = 20;
		manyMembers = 0;
		people = new Person[InitialCapacity];
	}
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	
	public PersonCollection(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("InitialCapacity is negative");
		}
		else {
			manyMembers = 0;
			people = new Member[initialCapacity];
		}
	}
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public void add(Person person) {
		
		if (manyMembers == people.length) {
			ensureCapacity(manyMembers*2+1);
		}
		people[manyMembers] = person;
		manyMembers ++;
	}
	public void ensureCapacity(int minimumCapacity) {
		
		Person[] biggerCollection;
		
		if (people.length < minimumCapacity) {
			biggerCollection = new Person[minimumCapacity];
			System.arraycopy(people, 0, biggerCollection, 0, manyMembers);
			people = biggerCollection;
		}
	}
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public PersonCollection clone() {
		PersonCollection result;
		try {
			result = (PersonCollection)super.clone();
		}catch(CloneNotSupportedException e) {
			throw new RuntimeException("This does not implement Cloneable");
		}
		result.people = people.clone();
		return result;
	}
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	public void trimToSize() {
		Member[] trimedMembers;
		if(people.length != manyMembers) {
			trimedMembers = new Member[manyMembers];
			System.arraycopy(people, 0, trimedMembers, 0, manyMembers);
			people = trimedMembers;
		}
	}
	
	
	/**
	 *@Specifications:
	 *@Param:
	 *@Precondition:
	 *@Postcondition:
	 *@Exceptions:
	 *@Throws:
	 */
	
	public boolean searchByName(String name) {
		try {
			for(int i = 0; i < people.length; i++) {
				if (people[i].getName().equalsIgnoreCase(name)) {
					System.out.println("This is the member with the name " + name);
					System.out.println(people[i]);
					return true;
				}
			}
		}catch(NullPointerException e) {
			System.err.println("Unable to locate the member with the name " + name);
		}
		System.out.println("member not found!");
		
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
	public boolean searchByContact(String contact) {
		try {
			for (int i = 0; i <people.length; i++) {
				if (people[i].getContact() == contact) {
					System.out.println("Here is the member with this contact");
					System.out.println(people[i]);
					return true;
				}
			}
		}catch(NullPointerException e) {
			System.err.println("Unable to locate a member with this contact information");
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
	public boolean searchByMemberId(int id) {
		try {
			for (int i = 0; i < people.length; i++) {
				if (people[i].getId() == id) {
					System.out.println("Here is the member with this memberId");
					System.out.println(people[i]);
					return true;
				}
			}
		}catch (NullPointerException e) {
			System.err.println("Unable to locate a member with this memberId");
		}
		return false;
	}
	
	public Person[] getPeople() {
		return people;
	}
	public void setPeople(Person[] people) {
		this.people = people;
	}
	public int getManyMembers() {
		return manyMembers;
	}
	public void setManyMembers(int manyMembers) {
		this.manyMembers = manyMembers;
	}
	public String readAll() {
		String info="";
		for (int count=0;count<manyMembers;count++) {
			info+=people[count]+"\n";
		}
		return info;
	}
}