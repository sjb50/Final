
public class PersonCollection implements Cloneable{
	private Member[] member;
	private int manyMembers;

	public PersonCollection() {
		final int InitialCapacity = 20;
		manyMembers = 0;
		member = new Member[InitialCapacity];
	}
	
	public PersonCollection(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("InitialCapacity is negative");
		}
		else {
			manyMembers = 0;
			member = new Member[initialCapacity];
		}
	}
	
	public void ensureCapacity() {
		
	}
}
