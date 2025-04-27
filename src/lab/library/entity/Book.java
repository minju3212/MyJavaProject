package lab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book() {
		isAvailable = true;
	}

	public Book(String title, String author, String isbn, int publishYear) {
		isAvailable = true;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean checkOut() {
		isAvailable = false;
		return true;
	}
	
	public void returnBook() {
		isAvailable = true;
	}
	
	@Override
	public String toString() {
		String truefalse;
		if(isAvailable == true) {
			truefalse = "����";
		}else {
			truefalse = "�Ұ���";
		}
		return "å ���� : " + title + "\t���� : " + author + "\tISBN : " + isbn + "\t���ǳ⵵ : " + publishYear + "\t���� ���� ���� : " + truefalse;
	}
	
	
}
