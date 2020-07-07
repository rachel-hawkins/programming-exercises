package basic;

import java.util.Random;
import java.util.Scanner;

/**
 * Write a guessing game where the user has to guess a secret number. After
 * every guess the program tells the user whether their number was too large or
 * too small. At the end the number of tries needed should be printed. It counts
 * only as one try if they input the same number multiple times consecutively.
 * 
 * @author Rachel Hawkins
 */
public class SimpleGuessingGame {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// program chooses the secret number.
		Random random = new Random();
		int secret = random.nextInt(100);

		// initialize the program.
		Scanner scanner = new Scanner(System.in);
		int guess = -1;
		int tries = 0;
		System.out.print("Guess the secret number:");

		while (guess != secret) {
			// if the user goes above or below the bound.
			if (guess > 100) {
				System.out.println("Hint the integer is between 0 and 100.");
				break;
			}

			// inform user of position of guess.
			if (0 < guess && guess < secret) {
				System.out.println("That integer was incorrect.");
				System.out.println("Too low! Guess again:");
			} else if (guess > secret) {
				System.out.println("That integer was incorrect.");
				System.out.println("Too high! Guess again:");
			}
			System.out.println();

			// retrieve the next guess.
			guess = scanner.nextInt();
			tries++;
		}
		// close the scanner to prevent leaks.
		scanner.close();

		// end game.
		System.out.println("Correct! Secret number is " + guess + ". \nIt took " + tries + " tries!");
	}

}
