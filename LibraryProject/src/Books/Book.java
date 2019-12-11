package Books;

import java.io.Serializable;

import Person.WaitList;

public class Book implements Cloneable, Serializable, Comparable {

	private String author;
	private String title;
	private String picture;
	private boolean checkOut;
	private WaitList waitList;

	public Book(String author, String title, String picture) {
		super();
		this.author = author;
		this.title = title;
		this.picture = picture;
		this.checkOut = false;
		waitList = new WaitList();
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public WaitList getWaitList() {
		return waitList;
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
		return "\nTitle:" + title + "\nAuthor:"+ author+"\nAvailable: " + checkOut ;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
