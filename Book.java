
public class Book implements Cloneable {

	private String author;
	private String title;
	private image picture;
	private String book;
	private boolean checkOut;
	
	public Book(String author, String title, image picture, String book, boolean checkOut) {
		super();
		this.author = author;
		this.title = title;
		this.picture = picture;
		this.book = book;
		this.checkOut = checkOut;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public image getPicture() {
		return picture;
	}

	public void setPicture(image picture) {
		this.picture = picture;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public boolean isCheckOut() {
		return checkOut;
	}

	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (checkOut != other.checkOut)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	

	@Override
	protected Book clone() throws CloneNotSupportedException {
		return (Book) super.clone();
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", picture=" + picture + ", book=" + book + ", checkOut="
				+ checkOut + "]";
	}
	
	
	
}
