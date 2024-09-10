import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WheelOfFortuneBotPlayer {
    private String phrase;
    private StringBuilder hiddenPhrase;
    private StringBuilder previousGuesses;
    private int count;
    int increment = 0;
public WheelOfFortuneBotPlayer() {
this.count = 0 ;
previousGuesses = new StringBuilder();
}
// Get random phrase from phrase file
    public String randomPhrase() {
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
// Turn the phrase to asterisks and store it on a variable
    public  String generateHiddenPhrase(String phrase) {
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
// Take the input of the guess
    public  char getGuess() {
        Scanner in = new Scanner(System.in);
        return in.next().charAt(0);
    }
// Make the guessed character visible (case in sensitive)
    public  String processGuess(StringBuilder hiddenPhrase, String phrase, char guess1, char guess2) {
        for (int i = 0; i < phrase.length(); i++) {
            char currentChar = phrase.charAt(i);
            if (currentChar == guess1 || currentChar == guess2) {
                hiddenPhrase.setCharAt(i, currentChar);
            }
        }
        return hiddenPhrase.toString();
    }

     public char botPlayer(){
     Random random = new Random();
     int r = 65+random.nextInt(57);
return (char)r;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("******Hello and Welcome to the Wheel of Fortune!******");
        System.out.println("Instructions: A hidden phrase will be prompted and you will have to guess the characters of this phrase.\nOnly type 1 character at a time.\nYou have " + n + " failed attempts possible.");

        WheelOfFortuneBotPlayer object = new WheelOfFortuneBotPlayer();
        String phrase= object.randomPhrase();
        StringBuilder hiddenPhrase = new StringBuilder(object.generateHiddenPhrase(phrase));

        boolean gameOver = false;

        while (n > 0 && object.count > 0) {
            int i=0;
            char guess1 = object.BotPlayer(1);
            i++;
            char guess2 = (Character.isUpperCase(guess1)) ? Character.toLowerCase(guess1) : Character.toUpperCase(guess1);

            String updatedHiddenPhrase = object.processGuess(hiddenPhrase, phrase, guess1, guess2);
            System.out.println(guess1);
            // Print the updated hidden phrase
            System.out.println("Current Hidden Phrase: " + updatedHiddenPhrase);

            // Check if guess was found
            for (int j = 0; j < hiddenPhrase.length(); j++) {
                if (hiddenPhrase.charAt(j) == guess1 && object.previousGuesses.toString().indexOf(guess1) == -1) {
                    object.count--;
                } else if (hiddenPhrase.charAt(j) == guess2 && object.previousGuesses.toString().indexOf(guess2) == -1) {

                    object.count--;
                }

            }
            if (Character.isLetter(guess1) && hiddenPhrase.toString().indexOf(guess1) == -1 && Character.isLetter(guess2) && hiddenPhrase.toString().indexOf(guess2) == -1 ) {
                n--;
                System.out.println("You have "+n+" attempts left!");
            }

            if (!Character.isLetter(guess1)) {
                System.out.println("Warning: The character should be a letter.");
            }

            if (object.previousGuesses.toString().indexOf(guess1) != -1 || object.previousGuesses.toString().indexOf(guess2) != -1) {
                System.out.println("Warning: You have already made this guess!");
            }

            object.previousGuesses.append(guess1);
            object.previousGuesses.append(guess2);

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
