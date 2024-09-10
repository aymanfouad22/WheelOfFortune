import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WheelOfFortuneMethods {
    private static int count = 0;

    public static String randomPhrase() {
        List<String> phraseList;
        try {
            phraseList = Files.readAllLines(Paths.get("Phrases.txt"));
        } catch (IOException e) {
            System.out.println(e);
            return "";
        }
        Random rand = new Random();
        int r = rand.nextInt(phraseList.size()); // Updated to handle any list size
        return phraseList.get(r);
    }

    public static String generateHiddenPhrase(String phrase) {
        StringBuilder hiddenPhrase = new StringBuilder();
        count = 0; // Reset count
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (Character.isLetter(ch)) {
                hiddenPhrase.append('*');
                count++;
            } else {
                hiddenPhrase.append(ch);
            }
        }
        return hiddenPhrase.toString();
    }

    public static char getGuess() {
        Scanner in = new Scanner(System.in);
        return in.next().charAt(0);
    }

    public static String processGuess(StringBuilder hiddenPhrase, String phrase, char guess1, char guess2) {
        for (int i = 0; i < phrase.length(); i++) {
            char currentChar = phrase.charAt(i);
            if (currentChar == guess1 || currentChar == guess2) {
                hiddenPhrase.setCharAt(i, currentChar);
            }
        }
        return hiddenPhrase.toString();
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("******Hello and Welcome to the Wheel of Fortune!******");
        System.out.println("Instructions: A hidden phrase will be prompted and you will have to guess the characters of this phrase.\nOnly type 1 character at a time.\nYou have " + n + " failed attempts possible.");

        String phrase = randomPhrase();
        StringBuilder hiddenPhrase = new StringBuilder(generateHiddenPhrase(phrase));

        StringBuilder goodGuesses = new StringBuilder();
        boolean gameOver = false;

        while (n > 0 && count > 0) {
            char guess1 = getGuess();
            char guess2 = (Character.isUpperCase(guess1)) ? Character.toLowerCase(guess1) : Character.toUpperCase(guess1);

            String updatedHiddenPhrase = processGuess(hiddenPhrase, phrase, guess1, guess2);

            // Print the updated hidden phrase
            System.out.println("Current Hidden Phrase: " + updatedHiddenPhrase);

            // Check if guess was found
            for (int j = 0; j < hiddenPhrase.length(); j++) {
                if (hiddenPhrase.charAt(j) == guess1 && goodGuesses.toString().indexOf(guess1) == -1) {
                    count--;
                } else if (hiddenPhrase.charAt(j) == guess2 && goodGuesses.toString().indexOf(guess2) == -1) {

                    count--;
                }

            }
            if (Character.isLetter(guess1) && hiddenPhrase.toString().indexOf(guess1) == -1 && Character.isLetter(guess2) && hiddenPhrase.toString().indexOf(guess2) == -1 ) {
                n--;
                System.out.println("You have "+n+" attempts left!");
            }

            if (!Character.isLetter(guess1)) {
                System.out.println("Warning: The character should be a letter.");
            }

            if (goodGuesses.toString().indexOf(guess1) != -1 || goodGuesses.toString().indexOf(guess2) != -1) {
                System.out.println("Warning: You have already made this guess!");
            }

            goodGuesses.append(guess1);
            goodGuesses.append(guess2);

            if (n == 0) {
                System.out.println("You lost! The phrase was: " + phrase);
                gameOver = true;
            } else if (hiddenPhrase.indexOf("*") == -1) {
                System.out.println("Congratulations! You won the game!");
                gameOver = true;
            }
        }

        if (!gameOver) {
            System.out.println("Game Over!");
        }
    }
}
