package Person;

import java.io.Serializable;

public class PersonCollection implements Cloneable, Serializable{
	private Person[] people;
	private int manyMembers;

	/**
	 *@Specifications: no argument constructor that initialize the instance variables
	 *@Param: none
	 *@Precondition: the instance variables must exist
	 *@Postcondition: initaliazes the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public PersonCollection() {
		final int InitialCapacity = 20;
		manyMembers = 0;
		people = new Person[InitialCapacity];
	}
	/**
	 *@Specifications: getter for the instance variable people
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public Person[] getPeople() {
		return people;
	}
	/**
	 *@Specifications: setter for the instance variable people
	 *@Param: take an array argument
	 *@Precondition: The array length of the array must be convenient to the number of people
	 *@Postcondition: sets the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public void setPeople(Person[] people) {
		this.people = people;
	}
	/**
	 *@Specifications: getter of the instance variable manyMembers
	 *@Param: none
	 *@Precondition: the instance variable must exist
	 *@Postcondition: returns the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public int getManyMembers() {
		return manyMembers;
	}
	/**
	 *@Specifications: setter method for the instance variable manyMember
	 *@Param: takes an int argument
	 *@Precondition: the instance variable mnust exist
	 *@Postcondition: sets the value of the instance variable
	 *@Exceptions: none
	 *@Throws: none
	 */
	public void setManyMembers(int manyMembers) {
		this.manyMembers = manyMembers;
	}
	/**
	 *@Specifications: method that creates new array of people
	 *@Param: takes an int argument 
	 *@Precondition: the argument must be none negative
	 *@Postcondition: creates new array of people if the argument is negative
	 *@Exceptions: IllegalArgumentException
	 *@Throws: none
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
	 *@Specifications: method that add people to the array
	 *@Param: takes a Person argument
	 *@Precondition: the array and person must exist
	 *@Postcondition: adds the person into the array
	 *@Exceptions: none
	 *@Throws: none
	 */
	public void add(Person person) {
		
		if (manyMembers == people.length) {
			ensureCapacity(manyMembers*2+1);
		}
		people[manyMembers] = person;
		manyMembers ++;
	}
	/**
	 *@Specifications: ensureCapacity method that double the size of the array if it is full
	 *@Param: takes an int argument
	 *@Precondition: the argument must be none negative
	 *@Postcondition: double the size of the array when it is full
	 *@Exceptions: none
	 *@Throws: none
	 */
	public void ensureCapacity(int minimumCapacity) {
		
		Person[] biggerCollection;
		
		if (people.length < minimumCapacity) {
			biggerCollection = new Person[minimumCapacity];
			System.arraycopy(people, 0, biggerCollection, 0, manyMembers);
			people = biggerCollection;
		}
	}
	
	/**
	 *@Specifications: Clone method that makes the copy of the collection
	 *@Param: none
	 *@Precondition: the collection must exist
	 *@Postcondition: makes a copy of the collection
	 *@Exceptions: none
	 *@Throws: RuntimeException
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
	 *@Specifications: trimTosize method that clear the empty array
	 *@Param: none
	 *@Precondition: the array must exist
	 *@Postcondition: reduces the array to the exact number of elements needed
	 *@Exceptions: none
	 *@Throws: none
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
	 *@Specifications: search method searches for a member by name
	 *@Param: takes a string argument
	 *@Precondition: the collection must exist
	 *@Postcondition: returns the member's information if found
	 *@Exceptions: NullPointerException
	 *@Throws: none
	 */
	
	public Person searchByName(String name) {
		try {
			for(int i = 0; i < this.manyMembers; i++) {
				if (people[i].getName().equalsIgnoreCase(name)) {
					System.out.println("This is the member with the name " + name);
					System.out.println(people[i]);
					return people[i];
				}
			}
		}catch(NullPointerException e) {
			System.err.println("Unable to locate the member with the name " + name);
		}
		System.out.println("member not found!");
		return null;
		
	}
	
	/**
	 *@Specifications: search method that searches for a member by contact information
	 *@Param: takes a string argument
	 *@Precondition: the collection must exist
	 *@Postcondition: returns the member's information if found
	 *@Exceptions: NullPointerException
	 *@Throws: none
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
	 *@Specifications: search method that searhes for a member by id
	 *@Param: takes an int argument
	 *@Precondition: the argument must be greater than 999
	 *@Postcondition: returns the member's information if found
	 *@Exceptions: NullPointerException
	 *@Throws: none
	 */
	public Person searchByMemberId(int id) {
		try {
			for (int i = 0; i < this.manyMembers; i++) {
				if (people[i].getId() == id) {
					System.out.println("Here is the member with this memberId");
					System.out.println(people[i]);
					return people[i];
				}
			}
		}catch (NullPointerException e) {
			System.err.println("Unable to locate a member with this memberId");
		}
		return null;
	}
	
	/**
	 *@Specifications: method that read the information of the collection
	 *@Param: none
	 *@Precondition: the collection must exist
	 *@Postcondition: returns the information of the collection
	 *@Exceptions: none
	 *@Throws: none
	 */
	public String readAll() {
		String info="";
		for (int count=0;count<manyMembers;count++) {
			info+=people[count]+"\n";
		}
		return info;
	}
}
