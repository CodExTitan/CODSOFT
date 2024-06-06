package InternshipCodes;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean hasGuessedCorrectly = false;

            System.out.println("\n\t\t\t******** Welcome to the Number Guessing Game! ********");
            System.out.println("Rule : I have selected a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("\nEnter your guess: \n");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    hasGuessedCorrectly = true;
                    System.out.println("\nCongratulations! You've guessed the correct number.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("\nSorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.println("\t\t\t\tYou used " + attempts + " attempts.");

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

            System.out.println();
        }

        System.out.println("\t\t\t\tThank you for playing the Number Guessing Game!");
        scanner.close();
    }
}
