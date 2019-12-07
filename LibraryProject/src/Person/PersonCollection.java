package Person;
/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */

public class PersonCollection implements Cloneable{
	private Member[] members;
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
		members = new Member[InitialCapacity];
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
			members = new Member[initialCapacity];
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
	public void add(Member member) {
		
		if (manyMembers == members.length) {
			ensureCapacity(manyMembers*2+1);
		}
		members[manyMembers] = member;
		manyMembers ++;
	}
	public void ensureCapacity(int minimumCapacity) {
		
		Member[] biggerCollection;
		
		if (members.length < minimumCapacity) {
			biggerCollection = new Member[minimumCapacity];
			System.arraycopy(members, 0, biggerCollection, 0, manyMembers);
			members = biggerCollection;
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
		result.members = members.clone();
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
		if(members.length != manyMembers) {
			trimedMembers = new Member[manyMembers];
			System.arraycopy(members, 0, trimedMembers, 0, manyMembers);
			members = trimedMembers;
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
			for(int i = 0; i < members.length; i++) {
				if (members[i].getName().equalsIgnoreCase(name)) {
					System.out.println("This is the member with the name " + name);
					System.out.println(members[i]);
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
	public boolean searchByContact(int contact) {
		try {
			for (int i = 0; i <members.length; i++) {
				if (members[i].getContact() == contact) {
					System.out.println("Here is the member with this contact");
					System.out.println(members[i]);
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
			for (int i = 0; i < members.length; i++) {
				if (members[i].getMemberId() == id) {
					System.out.println("Here is the member with this memberId");
					System.out.println(members[i]);
					return true;
				}
			}
		}catch (NullPointerException e) {
			System.err.println("Unable to locate a member with this memberId");
		}
		return false;
	}
	
	public String readAll() {
		String info="";
		for (int count=0;count<manyMembers;count++) {
			info+=members[count]+"\n";
		}
		return info;
	}
}