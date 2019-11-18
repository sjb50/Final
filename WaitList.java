/**
 *@Specifications:
 *@Param:
 *@Precondition:
 *@Postcondition:
 *@Exceptions:
 *@Throws:
 */
package library.century.edu;

/**
 * @author sjb19
 *
 */
public class WaitList {
	PersonNode next;
	PersonNode last;
	
	public WaitList() {
		next=null;
		last=null;	
	}
	
	public void enque(Person person) {
		PersonNode newPerson = new PersonNode(person);
		if (next==null) {
			next=newPerson;
			last=next;
		}
		else {
			last.setLink(newPerson);
			last=newPerson;
		}
	}
	
	public Person remove() {
		Person person = next.getPerson();
		next=next.getLink();
		return person;
		
	}
	
	public String readQue() {
		String info="";
		PersonNode cursor = next;
		while (cursor!=null) {
			info+=cursor.getPerson().toString()+"\n";
			cursor=cursor.getLink();
		}
		return info;
	}
	
	public static void main(String[] args){
		Person sam = new Person("Sam");
		Person sam1 = new Person("john");
		Person sam2 = new Person("amir");
		WaitList list = new WaitList();
		list.enque(sam);
		list.enque(sam1);
		list.enque(sam2);
		list.remove();
		System.out.println(list.readQue());
		}
}
