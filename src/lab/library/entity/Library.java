package lab.library.entity;

import java.util.*;

public class Library {
	private List<Book> books;
	private String name;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
	    System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
	}
	
	// �������� �˻�
	public Book findBookByTitle(String title) {
	    for (Book book : books) {
	        if (book.getTitle().equalsIgnoreCase(title)) {  // ��ҹ��� ���� ���� ��
	            return book;
	        }
	    }
	    return null;  // �ش� ������ å�� ���� ���
	}

	// ���ڷ� �˻�
	public List<Book> findBooksByAuthor(String author) {
	    List<Book> results = new ArrayList<>();
	    for (Book book : books) {
	        if (book.getAuthor().equalsIgnoreCase(author)) {
	            results.add(book);
	        }
	    }
	    return results;
	}

	// ISBN���� �˻�
	public Book findBookByISBN(String isbn) {
	    for (Book book : books) {
	        if (book.getIsbn().equalsIgnoreCase(isbn)) {
	            return book;
	        }
	    }
	    return null; // �ش� ISBN�� å�� ���� ���
	}
	
	public boolean checkOutBook(String isbn) {
	    for (Book book : books) {
	        if (book.getIsbn().equals(isbn)) {  // ISBN���� å ã��
	            if (book.isAvailable()) {       // ���� ���� ���� Ȯ��
	                book.checkOut();            // ���� ó��
	                System.out.println("���� ����: " + book.getTitle());
	                return true;                // ���� ����
	            } else {
	                System.out.println("���� ����: �̹� ����� å�Դϴ�.");
	                return false;               // ���� ����
	            }
	        }
	    }
	    System.out.println("���� ����: �ش� ISBN�� å�� �����ϴ�.");
	    return false; // å�� ���� ��
	}
	
	public boolean returnBook(String isbn) {
	    for (Book book : books) {
	        if (book.getIsbn().equals(isbn)) {
	            if (!book.isAvailable()) {       // ���� �������� Ȯ��
	                book.returnBook();           // �ݳ� ó��
	                System.out.println("�ݳ� ����: " + book.getTitle());
	                return true;                 // �ݳ� ����
	            } else {
	                System.out.println("�ݳ� ����: �̹� �ݳ��� �����Դϴ�.");
	                return false;                // �ݳ� ����
	            }
	        }
	    }
	    System.out.println("�ݳ� ����: �ش� ISBN�� å�� �����ϴ�.");
	    return false; // å�� ���� ��
	}
	
	public List<Book> getAvailableBooks() {
	    List<Book> availableBooks = new ArrayList<>();
	    for (Book book : books) {
	        if (book.isAvailable()) {  // ���� ������ å���� Ȯ��
	            availableBooks.add(book);
	        }
	    }
	    return availableBooks;
	}
	
	public List<Book> getAllBooks() {
	    return new ArrayList<>(books); // ��ü ����Ʈ ���� �� ��ȯ
	}
	
	public int getTotalBooks() {
	    return books.size();
	}
	
	public int getAvailableBooksCount() {
	    int count = 0;
	    for (Book book : books) {
	        if (book.isAvailable()) {
	            count++;
	        }
	    }
	    return count;
	}
	
	public int getBorrowedBooksCount() {
	    return getTotalBooks() - getAvailableBooksCount();
	}
}
