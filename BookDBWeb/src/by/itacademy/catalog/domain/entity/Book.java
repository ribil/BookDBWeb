package by.itacademy.catalog.domain.entity;

import java.io.Serializable;

public class Book  implements Serializable{
	
	private static final long serialVersionUID = 7792577571399598002L;
	private int id;
	private String title;
	private int pages;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Book(int id, String title, int pages) {
		super();
		this.id = id;
		this.title = title;
		this.pages = pages;
	}
	public Book() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + pages;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
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
		if (id != other.id)
			return false;
		if (pages != other.pages)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book id=" + id + ", title=" + title + ", pages=" + pages;
	}
	
	

}
