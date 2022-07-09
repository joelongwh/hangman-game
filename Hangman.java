package com.fdmgroup.HangmanAssessment;

// Imports
import java.util.ArrayList; 
import java.util.Scanner;
import java.util.Random;

public class Hangman {
	
	

	public static void main(String[] args) {
		
		// Print welcome message
		System.out.println("Welcome to Hangman!");
		
		// Generate random value from 0-10 
		Random rand = new Random();
		int upperbound = 10;
		int randomInt = rand.nextInt(upperbound);
		
		// Initialize and present guess word
		String words[] = {"BADMINTON", "TENNIS", "BASKETBALL", "SOCCER", "FOOTBALL", "VOLLEYBALL", "BOWLING", "SNOWBOARDING", "SWIMMING", "CYCLING"};
		String randomWord = words[randomInt];
		char[] randomWordLetters = randomWord.toCharArray();
		String hiddenWord = "";
		for (char letter : randomWordLetters) {
			hiddenWord = hiddenWord + "-";
		}
		System.out.println("The word now looks like this: " + hiddenWord);
		
		// MAIN LOOP
		int remainingGuesses = 8;
		
		ArrayList<Character> correctGuessedLetters = new ArrayList<>();
		ArrayList<Character> incorrectGuessedLetters = new ArrayList<>();
				
		while (remainingGuesses > 0) {
			
			// Print remaining guesses left
			System.out.println("You have " + remainingGuesses + " guess(es) left.");
			
			// Display list of previously guessed letters
			System.out.println("Correctly guessed letters: " + correctGuessedLetters);
			System.out.println("Incorrectly guessed letters: " + incorrectGuessedLetters);

			// Prompt user for input 
			Scanner userInput = new Scanner(System.in);
			System.out.print("Your guess: ");
			char guessedLetter = userInput.next().charAt(0);
			guessedLetter = Character.toUpperCase(guessedLetter);
			
			// Previous guess letter check and alert
			if (correctGuessedLetters.contains(guessedLetter) || incorrectGuessedLetters.contains(guessedLetter)) {
				System.out.println("Letter entered has already been used, guess again.");
				continue;
			}
			
			// Check if guessed letter is correct or incorrect
			boolean isGuessCorrect = false; 
			for (char letter : randomWordLetters) {
				
				// Guessed letter is correct
				if (guessedLetter == letter) {
					correctGuessedLetters.add(guessedLetter);
					isGuessCorrect = true;
					System.out.println("That guess is correct.");
					break;
				
				}
			}
			
			// Guessed letter is incorrect
			if (! isGuessCorrect) {
				incorrectGuessedLetters.add(guessedLetter);
				System.out.println("There are no " + guessedLetter + "'s in the word.");
				remainingGuesses--;
			}
			
			// Check if won and display winning message else print how the word looks like after guess
			boolean hasWon = true;
			
			for (char letter : randomWordLetters) {
				
				if (! correctGuessedLetters.contains(letter)) {
					hasWon = false;
				}
			}
			
			if (hasWon) {
				System.out.println("You guessed the word: " + randomWord);
				System.out.println("You win!");
				break;
			} else {
				System.out.print("The word now looks like this: ");
				for (char letter : randomWordLetters) {
					if (correctGuessedLetters.contains(letter)) {
						System.out.print(letter);
					} else {
						System.out.print("-");
					}
				}		
				System.out.println(" ");
			}
			
		}
		
		// Losing message
		if (remainingGuesses == 0) {
			System.out.println("You're completely hung.");
			System.out.println("The word was: " + randomWord);
			System.out.println("You lose!");
		}
		
	}

}
