package library;

import java.util.ArrayList;
import java.util.Comparator;

public class Author extends Person {
    private ArrayList<Book> books;

    public Author(int id, String name, String secName) {
        super(id, name, secName);
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        ArrayList<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparing(Book::getTitle));
        return sortedBooks;
    }

    public void showBooks() {
        ArrayList<Book> sortedBooks = new ArrayList<>(books);
        sortedBooks.sort(Comparator.comparing(Book::getTitle));

        for (Book book : sortedBooks) {
            System.out.println("Tytuł: " + book.getTitle());
            System.out.println("Rok wydania: " + book.getYearOfPublication());
            System.out.println("Liczba ocen: " + book.getMarkCounter());
            System.out.println("Średnia ocen: " + book.getAvgMark());
            System.out.println();
        }
        System.out.println("Liczba książek: " + sortedBooks.size());
    }
}
