package lab.library.control;
import lab.library.entity.Book;
import lab.library.entity.Library;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // a. ������ ��ü ����
        Library library = new Library("�߾� ������");

        // b. ���� ������ �߰�
        addSampleBooks(library);

        // c. ������ ������ ���
        System.out.println("===== �߾� ������ =====");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());

        // d. �� ��� �׽�Ʈ �޼��� ȣ��
        testFindBook(library);
        testCheckOut(library);
        testReturn(library);

        // e. ���� ������ ���� ����� ���
        displayAvailableBooks(library);
    }

    /**
     * b. ���� ������ �߰��ϴ� �޼���
     */
    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }

    /**
     * ����� ���ڷ� ������ �˻��ϴ� ����� �׽�Ʈ�ϴ� �޼���
     */
    private static void testFindBook(Library library) {
        System.out.println("\n===== ���� �˻� �׽�Ʈ =====");
        
     // �������� �˻�
        System.out.println("�������� �˻� ���:");
        Book foundByTitle = library.findBookByTitle("�ڹ��� ����");
        if (foundByTitle != null) {
            System.out.println(foundByTitle);
        } else {
            System.out.println("�ش� ������ å�� ã�� �� �����ϴ�.");
        }

        System.out.println("\n���ڷ� �˻� ���:");
        for (Book book : library.findBooksByAuthor("Robert C. Martin")) {
            System.out.println(book);
        }
    }

    /**
     * ���� ���� ����� �׽�Ʈ�ϴ� �޼���
     */
    private static void testCheckOut(Library library) {
        System.out.println("\n===== ���� ���� �׽�Ʈ =====");
        
        // ���� ������ å ���� �õ�
        boolean success = library.checkOutBook("978-89-01-14077-4");
        if (success) {
            System.out.println("���� ���� ����!");
            Book borrowedBook = library.findBookByISBN("978-89-01-14077-4");
            System.out.println("����� ���� ����:");
            System.out.println(borrowedBook);
        }

        // ������ ���� ���� ���
        System.out.println("\n������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
    }

    /**
     * ���� �ݳ� ����� �׽�Ʈ�ϴ� �޼���
     */
    private static void testReturn(Library library) {
        System.out.println("\n===== ���� �ݳ� �׽�Ʈ =====");
        
        // �ݳ� ó��
        boolean success = library.returnBook("978-89-01-14077-4");
        if (success) {
            System.out.println("���� �ݳ� ����!");
            Book returnedBook = library.findBookByISBN("978-89-01-14077-4");
            System.out.println("�ݳ��� ���� ����:");
            System.out.println(returnedBook);
        }

        // ������ ���� ���� ���
        System.out.println("\n������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
    }

    /**
     * ���� ������ ������ ����ϴ� �޼���
     */
    private static void displayAvailableBooks(Library library) {
        System.out.println("\n===== ���� ������ ���� ��� =====");

        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}