package Task18Prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {
    private String targetAudience;
    private List<Book> recommendedBooks;

    public Recommendation(String targetAudience, List<Book> recommendedBooks) {
        this.targetAudience = targetAudience;
        this.recommendedBooks = recommendedBooks;
    }

    public Recommendation clone() {
        List<Book> clonedBooks = new ArrayList<>();
        for (Book book : recommendedBooks) {
            clonedBooks.add(book.clone());
        }
        return new Recommendation(this.targetAudience, clonedBooks);
    }

    public void addBook(Book book) {
        recommendedBooks.add(book);
    }

    public void removeBook(Book book) {
        recommendedBooks.remove(book);
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Book> getRecommendedBooks() {
        return recommendedBooks;
    }

    @Override
    public String toString() {
        return "Target Audience: " + targetAudience + "\nBooks: " + recommendedBooks;
    }
}
