package Task18Prototype;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecommendationManager {
    private List<Recommendation> recommendations;

    public RecommendationManager() {
        this.recommendations = new ArrayList<>();
    }

    public void viewRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
        } else {
            for (int i = 0; i < recommendations.size(); i++) {
                System.out.println((i + 1) + ". " + recommendations.get(i));
            }
        }
    }

    public void createRecommendation(Scanner scanner) {
        System.out.print("Enter target audience: ");
        String audience = scanner.nextLine();

        List<Book> books = new ArrayList<>();
        String addMore;
        do {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();
            System.out.print("Enter publication year: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            books.add(new Book(title, author, genre, year));

            System.out.print("Add another book? (yes/no): ");
            addMore = scanner.nextLine();
        } while (addMore.equalsIgnoreCase("yes"));

        recommendations.add(new Recommendation(audience, books));
        System.out.println("Recommendation created.");
    }

    public void cloneAndModifyRecommendation(Scanner scanner) {
        viewRecommendations();
        if (recommendations.isEmpty()) {
            return;
        }

        System.out.print("Enter the number of the recommendation to clone: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < recommendations.size()) {
            Recommendation cloned = recommendations.get(index).clone();
            System.out.println("Cloned recommendation: " + cloned);

            System.out.print("Do you want to update the target audience? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Enter new target audience: ");
                cloned.setTargetAudience(scanner.nextLine());
            }

            System.out.println("Do you want to add or remove books?");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("0. Done");
            int modifyChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (modifyChoice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    cloned.addBook(new Book(title, author, genre, year));
                    break;
                case 2:
                    System.out.println("Books in the recommendation:");
                    for (int i = 0; i < cloned.getRecommendedBooks().size(); i++) {
                        System.out.println((i + 1) + ". " + cloned.getRecommendedBooks().get(i));
                    }
                    System.out.print("Enter the number of the book to remove: ");
                    int bookIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    if (bookIndex >= 0 && bookIndex < cloned.getRecommendedBooks().size()) {
                        cloned.removeBook(cloned.getRecommendedBooks().get(bookIndex));
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
            }

            recommendations.add(cloned);
            System.out.println("Cloned and modified recommendation added.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void saveRecommendations() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("recommendations.txt"))) {
            for (Recommendation recommendation : recommendations) {
                writer.write(recommendation.toString());
                writer.newLine();
            }
            System.out.println("Recommendations saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving recommendations: " + e.getMessage());
        }
    }

}
