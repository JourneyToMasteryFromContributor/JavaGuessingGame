import java.util.Scanner;
import java.io.*;
import java.util.*;

public class GuessingGame {

    private int response;
    private int secretNumber;

    private int maxGuesses = 10;
    private int lowerBound = 0;
    private int upperBound = 100;

    private Scanner scan;

    public static void main(String[] args) throws IOException {
        GuessingGame hiLo = new GuessingGame();
        hiLo.start();
    }

    private void start() {
        String input;
        scan = new Scanner(System.in);

        System.out.println("Do you want to play a game (y/n)?");
        input = scan.nextLine();

        // Only proceed if the user inputs "y"
        if (input.equals("y")) {
            // Start
            playGame();
        } else {
            System.out.println("Maybe next time!");
        }
    }

    private void playGame() { 
        secretNumber = generateSecretNumber();

        // Allow the user up to maxGuesses to guess the number
        for (int i = 1; i <= maxGuesses; i++) {
            System.out.println("Attempt " + i + " of " + maxGuesses);
            System.out.println("Guess the number (between " + lowerBound + " and " + (upperBound - 1) + "):");

            response = scan.nextInt();
            scan.nextLine();

            if (response == secretNumber) {
                System.out.println("Congratulations! The number was " + secretNumber);
                display();
                break;  // Exit the loop if the guess is correct
            } else {
                System.out.println("Incorrect guess. Try again.");
            }
        }

        if (response != secretNumber) {
            System.out.println("Sorry, you've run out of attempts. The secret number was " + secretNumber);
            display();
        }

        System.out.println("Do you want to play again (y/n)?");
        String input = scan.nextLine();
        if (input.equals("y")) {
            playGame();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    private int generateSecretNumber() {
        Random rand = new Random();
        secretNumber = rand.nextInt(upperBound);  // Random number between 0 and 99
        System.out.println("Secret number generated: " + secretNumber);
        return secretNumber;
    }

    private void display() {
        System.out.println("Constants in the game:");
        System.out.println("UPPER_BOUND: " + upperBound);
        System.out.println("LOWER_BOUND: " + lowerBound);
        System.out.println("MAX_GUESSES: " + maxGuesses);
    }
}


