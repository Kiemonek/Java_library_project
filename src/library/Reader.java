package library;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {

    private ArrayList<Book> borrowedBooks;
    private ArrayList<Review> reviews;

    public Reader(int id, String name, String secName) {
        super(id, name, secName);
        borrowedBooks = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.isBorrowed()) {
            System.out.println("Nie można wypożyczyć książki " + book.getTitle() + ", jest już wypożyczona.");
        } else {
            book.setBorrowed(true);
            borrowedBooks.add(book);
            System.out.println("Książka " + book.getTitle() + " została wypożyczona.");
        }
    }

    public List<String> getBorrowHistory() {
        List<String> history = new ArrayList<>();
        for (Book book : borrowedBooks) {
            history.add(book.getTitle() + " (" + book.getYearOfPublication() + ")");
        }
        return history;
    }

    public List<String> getOverdueBooks() {
        List<String> overdueBooks = new ArrayList<>();
        for (Book book : borrowedBooks) {
            if (book.isOverdue()) {
                overdueBooks.add(book.getTitle());
            }
        }
        return overdueBooks;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void addReview(Reader reviewAuthor, Book book, String reviewContent, int mark) {
        Review review = new Review(reviewAuthor, book.getTitle(), reviewContent, mark);
        book.addReview(review);
        reviews.add(review);
        System.out.println("Dziękuję za recenzję");
    }

}
