package Task18Prototype;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecommendationManager manager = new RecommendationManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Book Recommendation System!");

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. View Recommendations");
            System.out.println("2. Create New Recommendation");
            System.out.println("3. Clone and Modify Recommendation");
            System.out.println("4. Save Recommendations");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 0:
                        exit = true;
                        break;
                    case 1:
                        manager.viewRecommendations();
                        break;
                    case 2:
                        manager.createRecommendation(scanner);
                        break;
                    case 3:
                        manager.cloneAndModifyRecommendation(scanner);
                        break;
                    case 4:
                        manager.saveRecommendations();
                        break;
                    default:
                        System.out.println("Invalid input. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
