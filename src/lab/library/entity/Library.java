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
	    System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}
	
	// 제목으로 검색
	public Book findBookByTitle(String title) {
	    for (Book book : books) {
	        if (book.getTitle().equalsIgnoreCase(title)) {  // 대소문자 구분 없이 비교
	            return book;
	        }
	    }
	    return null;  // 해당 제목의 책이 없는 경우
	}

	// 저자로 검색
	public List<Book> findBooksByAuthor(String author) {
	    List<Book> results = new ArrayList<>();
	    for (Book book : books) {
	        if (book.getAuthor().equalsIgnoreCase(author)) {
	            results.add(book);
	        }
	    }
	    return results;
	}

	// ISBN으로 검색
	public Book findBookByISBN(String isbn) {
	    for (Book book : books) {
	        if (book.getIsbn().equalsIgnoreCase(isbn)) {
	            return book;
	        }
	    }
	    return null; // 해당 ISBN의 책이 없는 경우
	}
	
	public boolean checkOutBook(String isbn) {
	    for (Book book : books) {
	        if (book.getIsbn().equals(isbn)) {  // ISBN으로 책 찾기
	            if (book.isAvailable()) {       // 대출 가능 여부 확인
	                book.checkOut();            // 대출 처리
	                System.out.println("대출 성공: " + book.getTitle());
	                return true;                // 대출 성공
	            } else {
	                System.out.println("대출 실패: 이미 대출된 책입니다.");
	                return false;               // 대출 실패
	            }
	        }
	    }
	    System.out.println("대출 실패: 해당 ISBN의 책이 없습니다.");
	    return false; // 책이 없을 때
	}
	
	public boolean returnBook(String isbn) {
	    for (Book book : books) {
	        if (book.getIsbn().equals(isbn)) {
	            if (!book.isAvailable()) {       // 대출 상태인지 확인
	                book.returnBook();           // 반납 처리
	                System.out.println("반납 성공: " + book.getTitle());
	                return true;                 // 반납 성공
	            } else {
	                System.out.println("반납 실패: 이미 반납된 상태입니다.");
	                return false;                // 반납 실패
	            }
	        }
	    }
	    System.out.println("반납 실패: 해당 ISBN의 책이 없습니다.");
	    return false; // 책이 없을 때
	}
	
	public List<Book> getAvailableBooks() {
	    List<Book> availableBooks = new ArrayList<>();
	    for (Book book : books) {
	        if (book.isAvailable()) {  // 대출 가능한 책인지 확인
	            availableBooks.add(book);
	        }
	    }
	    return availableBooks;
	}
	
	public List<Book> getAllBooks() {
	    return new ArrayList<>(books); // 전체 리스트 복사 후 반환
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
