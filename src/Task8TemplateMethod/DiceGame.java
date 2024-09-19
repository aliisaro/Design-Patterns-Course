package Task8TemplateMethod;

import java.util.ArrayList;
import java.util.Random;

//Every player throws a dice during a turn. The diceroll gets added to the players score.
// The player that gets 50 points first, wins.
public class DiceGame extends Game {
    Random rand = new Random();
    private int diceroll;
    private boolean gameEnded = false; // Flag to track game status
    ArrayList<Integer> scores = new ArrayList<>(); // Array to keep track of each players score

    //Implement methods
    @Override
    public void initializeGame(int numberOfPlayers) {
        // Array size depends on the number of players
        for (int i = 0; i < numberOfPlayers; i++) {
            scores.add(0); // each player starts which 0 points
        }
        gameEnded = false; // gameEnded status is false
    }

    @Override
    public boolean endOfGame() {
        return gameEnded; // Check if the game has ended
    }

    @Override
    public void playSingleTurn(int player) {
        // Game continues if game hasn't ended
        if (gameEnded) {
            return;
        }

        diceroll = rand.nextInt(6) + 1; // Roll dice

        // Update the score for the player
        int newScore = scores.get(player) + diceroll;
        scores.set(player, newScore);

        // Output the result of the turn
        System.out.println("Player " + (player + 1) + " rolled: " + diceroll + ". Total score: " + newScore);

        // If player has score of 50+, gameEnded is set to true
        if (newScore >= 50) {
            System.out.println("Player " + (player + 1) + " wins!");
            gameEnded = true;
        }
    }

    @Override
    public void displayWinner() {
        if (gameEnded) {
            System.out.println("Game Over.");
        }
    }
}
