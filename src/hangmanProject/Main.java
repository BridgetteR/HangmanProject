package hangmanProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 1. methods from current code
		// 2. display options (word or letter)
		// 3. simplify code, use strings rather than arrays, remove any redundant or reused code
		// 4. ask if user wants to play again
		
		// allow for full word
		// prompt to enter letter
		// maybe clear after each guess?
		// ask if letter or word, figure out how to do this
		// create new instance of hangman, hard code incorrect guess to 0
		
		// think about working with strings rather than arrays, maybe using .charAt?
		
		// nested while loop
		// while playagain is true (default true) play game
		// while playagain is false, say "Bye!"
		
		
		
		String[] selectedWord = Hangman.splitWord;
		String[] blankWord = Hangman.setBlank(Hangman.splitWord2);
		
		ArrayList<String> listWord = new ArrayList<String>();
		Collections.addAll(listWord, selectedWord);
		
		ArrayList<String> blankListWord = new ArrayList<String>();
		Collections.addAll(blankListWord, blankWord);
		
		ArrayList<String> guessedLetters = new ArrayList<String>();
		
		System.out.println(listWord);
		System.out.println(blankListWord);
		
		
		
		Scanner s = new Scanner(System.in);
		

		int guessedIncorrectLetter = 0;
		
		while(guessedIncorrectLetter < 7) {
			String guess = s.next();
			int wordLength = listWord.size();
			
			// this can be a method
			for(int i = 0; i < wordLength; i++) {
				if(listWord.contains(guess)) {
					int test = listWord.indexOf(guess);
					blankListWord.set(test, guess);
					listWord.set(test, "_");
					guessedLetters.add(guess);
					System.out.println("That was correct!");
					System.out.println(blankListWord);
					break;
				} else {
					guessedIncorrectLetter++;
					break;
				}
			}
			
			if(!blankListWord.contains("_")) {
				System.out.println("You Win!");
				System.out.println("The answer was: " + Hangman.selectedWord);
			}
			
			
			
			// move switch to hangman.java, call as method here
			switch(guessedIncorrectLetter) {
			case 1:
				System.out.println("That was incorrect!");
				System.out.println("_|_");
				System.out.println(blankListWord);
				break;
			case 2: 
				System.out.println("That was incorrect!");
				System.out.println(" |");
				System.out.println("_|_");
				System.out.println(blankListWord);
				break;
			case 3:
				System.out.println("That was incorrect!");
				System.out.println(" |");
				System.out.println(" |");
				System.out.println("_|_");
				System.out.println(blankListWord);
				break;
			case 4:
				System.out.println("That was incorrect!");
				System.out.println(" |");
				System.out.println(" |");
				System.out.println(" |");
				System.out.println("_|_");
				System.out.println(blankListWord);
				break;
			case 5:
				System.out.println("That was incorrect!");
				System.out.println("_________");
				System.out.println(" |");
				System.out.println(" |");
				System.out.println(" |");
				System.out.println(" |");
				System.out.println("_|_");
				System.out.println(blankListWord);
				break;
			case 6:
				System.out.println("That was incorrect! This is your final attempt, please enter a full word!");
				System.out.println("_________");
				System.out.println(" |      |");
				System.out.println(" |");
				System.out.println(" |");
				System.out.println(" |");
				System.out.println("_|_");
				System.out.println(blankListWord);
				break;
			case 7:
				System.out.println("You Lose!");
				System.out.println("_________");
				System.out.println(" |      |");
				System.out.println(" |      O");
				System.out.println(" |     /|\\");
				System.out.println(" |     / \\");
				System.out.println("_|_");
				System.out.println("The answer was: " + Hangman.selectedWord);
			}
		}

	}

}
