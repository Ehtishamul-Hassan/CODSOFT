package CodSoftInternship;

import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Random num generates within range 1 to 100
        int minRange = 1;
        int maxRange = 100;
        int maxGuesses = 5;
        int roundWon = 0;

        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Number Game");
        System.out.println("You have " + maxGuesses + " guesses to crack the game");

        while (playAgain) {
            int randomNum = random.nextInt(maxRange - minRange + 1) + 1;

            String userGuess;
            int guess = 0;
            int guessCounter = 0;

            while (guess != randomNum && guessCounter <= maxGuesses) {

                // prompt from user
                System.out.println("Enter your Guess");
                guess = sc.nextInt();
                guessCounter++;

                if (guess == randomNum) {
                    userGuess = "Correct";
                } else if (guess > randomNum) {
                    userGuess = "Too High";
                } else {
                    userGuess = "Too Low";
                }

                System.out.println(userGuess);

            }

            System.out.println();

            if (guess == randomNum) {
                System.out.println("Bravo! You've cracked the code!");
                roundWon++;
            } else {
                System.out.println("Sorry you reach the maximum limit of guesses ");
            }

            // Display number of round won by user
            System.out.println("Rounds Won :" + " " + roundWon);

            // Ask user if want to play again
            System.out.println();
            System.out.println("Do you want to paly again ? (yes/no) :");
            String playAgainInp = sc.next().toLowerCase();

            if (!playAgainInp.equals("yes")) {
                playAgain = false;
                System.out.println("Thanku for playing Number Game");

            }

        }
    }

}
