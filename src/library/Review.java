package library;

public class Review {
    private Reader reviewAuthor;
    private String bookTitle;
    private String reviewContent;
    private int mark;

    public Review(Reader reviewAuthor, String string, String reviewContent, int mark) {
        this.reviewAuthor = reviewAuthor;
        this.bookTitle = string;
        this.reviewContent = reviewContent;
        this.mark = mark;
    }

    public Reader getReviewAuthor() {
        return reviewAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public int getMark() {
        return mark;
    }

    public void displayReview() {
        System.out.println("Recenzja książki: " + bookTitle + " autorstwa: " + reviewAuthor.getName() + " "
                + reviewAuthor.getLastName());
        System.out.println("Ocena: " + mark);
        System.out.println("Treść: " + reviewContent);
        System.out.println();
    }

}
