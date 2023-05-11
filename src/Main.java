// import java.util.List;

import library.*;

public class Main {
    public static void main(String[] args) {
        // tworzenie autorów
        Author author1 = new Author(1, "Jan", "kowalski");
        Author author2 = new Author(2, "Anna", "nowak");

        // tworzenie książek
        Book book1 = new Book(author1, "W pustyni i w puszczy", 2000, false);
        Book book2 = new Book(author1, "Pan Tadeusz", 1999, true);
        Book book3 = new Book(author2, "Mały Książę", 2010, false);

        // dodawanie autorom książek
        author1.addBook(book1);
        author1.addBook(book2);
        author2.addBook(book3);

        // tworzenie czytelników
        Reader reader1 = new Reader(12, "Adam", "Nowak");
        Reader reader2 = new Reader(32, "Ewa", "Kowalska");

        // wypożyczanie książek
        System.out.println("------Wypożyczanie------");
        book2.setBorrowed(true);
        reader1.borrowBook(book1);
        reader1.borrowBook(book3);
        reader2.borrowBook(book2);
        System.out.println();

        // zwracanie informacji o czytelnikach
        System.out.println("------Użytkownicy------");
        System.out.println("User:" + reader1);
        System.out.println("User:" + reader2);
        System.out.println();

        // zwracanie historii wypożyczeń i nieoddanych książek
        System.out.println("------Historia/Przetrzymywane------");
        System.out.println(reader1 + " Historia:" + reader1.getBorrowHistory());
        System.out.println(reader1 + " Przetrzymywane:" + reader1.getOverdueBooks());

        // dodawanie recenzji
        Review review1 = new Review(reader1, book1.getTitle(), "Bardzo dobra książka!", 5);
        Review review2 = new Review(reader2, book1.getTitle(), "Nie podobała mi się", 2);
        book1.addReview(review1);
        book1.addReview(review2);

        // wyświetlanie informacji o książkach
        System.out.println("------Info o książkach------");
        book1.displayInfo();
        System.out.println();

        book2.displayInfo();
        System.out.println();

        book3.displayInfo();
        System.out.println();

        // wyświetlanie informacji o autorach i ich książkach
        System.out.println("------Info o autorach------");
        System.out.println("Author:" + author1);
        author1.showBooks();
        System.out.println();

        System.out.println("Author:" + author2);
        author2.showBooks();
        System.out.println();

        // Wyświetlenie wszystkich recenzji dla książki book1
        System.out.println("------Recenzje książek------");
        book1.displayReviews();
        book2.displayReviews();
        book3.displayReviews();

    }
}
