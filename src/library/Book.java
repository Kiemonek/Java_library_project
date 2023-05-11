package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private Author author;
    private String title;
    private int yearOfPublication;
    private List<Review> reviews;
    private boolean status;
    private boolean borrowed;
    private int borrowDurationDays;
    private LocalDate borrowDate;

    public Book(Author author, String title, int yearOfPublication, boolean status) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.status = status;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public boolean getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public double getAvgMark() {
        if (reviews.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Review r : reviews) {
            sum += r.getMark();
        }
        return sum / reviews.size();
    }

    public int getMarkCounter() {
        return reviews.size();
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
        if (borrowed) {
            this.borrowDate = LocalDate.now();
        } else {
            this.borrowDate = null;
        }
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public boolean isOverdue() {
        if (borrowed) {
            LocalDate dueDate = borrowDate.plusDays(borrowDurationDays);
            LocalDate currentDate = LocalDate.now();
            return currentDate.isAfter(dueDate);
        } else {
            return false;
        }
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void displayReviews() {
        System.out.println("Recenzje książki \"" + title + "\":");
        for (Review r : reviews) {
            System.out.println(
                    "Autor recenzji: " + r.getReviewAuthor().getName() + " " + r.getReviewAuthor().getLastName());
            System.out.println("Ocena: " + r.getMark());
            System.out.println("Treść recenzji: " + r.getReviewContent());
            System.out.println();
        }
    }

    public void displayInfo() {
        System.out.println("Tytuł: " + title);
        System.out.println("Autor: " + author.getName() + " " + author.getLastName());
        System.out.println("Rok wydania: " + yearOfPublication);
        System.out.println("Liczba ocen: " + getMarkCounter());
        System.out.println("Średnia ocena: " + getAvgMark());
    }
}
