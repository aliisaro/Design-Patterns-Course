package Task6State;
import java.util.Scanner;
public class GameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new game character with the Novice level
        GameCharacter myCharacter = new GameCharacter("allu", new Novice(), 0, 0);

        myCharacter.displayStatus();

        // Game loop
        int turn = 1;

        // while characters level is not master, the game loop continues
        while (!(myCharacter.getLevel() instanceof Master)) {
            System.out.println("TURN " + turn);
            turn += 1;

            System.out.println("Choose an action (1: Train, 2: Meditate, 3: Fight):");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    myCharacter.train();
                    myCharacter.displayStatus();
                    break;
                case 2:
                    myCharacter.meditate();
                    myCharacter.displayStatus();
                    break;
                case 3:
                    myCharacter.fight();
                    myCharacter.displayStatus();
                default:
                    myCharacter.displayStatus();
            }
        }
        System.out.println("Game finished! You reached master level.");
    }
}
