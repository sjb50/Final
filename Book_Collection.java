
public class Book_Collection {

	private Book books;
	private Book_Node head;
	private int size;

	public Book getBooks() {
		return books;
	}

	public void setBooks(Book books) {
		this.books = books;
	}

	public void add(Book books) {
		Book_Node newNode = new Book_Node(books, head);
		head = newNode;
	}
 
	public void addMany(Book... books) {
		for (int i = 0; i < books.length; i++) {
			add(books[i]);
		}
	}

	public void remove(Book books) {
        if (head != null){
          if (books.equals(head.getData())){
              head = head.getLink();
          }
          else {
            Book_Node current = head.getLink();
            Book_Node previous = head;
            while(current != null){
              if (current.getData().equals(books)) {
                previous.setLink(current.getLink());
                previous = current;
                current = current.getLink();
                return;
              }
            }
          }
        }
	}

	public void display() {
		Book_Node current = head;
		if (current == null) {
			System.out.println("You have no books in your checked out list.");
			return;
		}
		while (current != null) {
			System.out.println(current.getData());
			current = current.getLink();
		}
	}

	public Book searchByAutherName(String author) {
		Book_Node current = head;
		while (current != null) {
			Book currentauthor = current.getData();

			if (current.getData().getAuthor().equalsIgnoreCase(author)) {
				return current.getData();
			}

			current = current.getLink();
		}
		return null;
	}

	public <T> Book searchByBookTitle(T book) {
		Book_Node current = head;
		while (current != null) {
			Book currentTitle = current.getData();

			if (current.getData().getTitle().equalsIgnoreCase(title)) {
				return current.getData();
			}

			current = current.getLink();
		}
		return null;
	}

	@Override
	protected Book_Collection clone() throws CloneNotSupportedException {
		return (Book_Collection) super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book_Collection other = (Book_Collection) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String bookList = "";
		Book_Node current;
		for (current = head; current != null; current = current.getLink()) {
			bookList += current.getData();
		}
		return bookList;
	}

	

}
