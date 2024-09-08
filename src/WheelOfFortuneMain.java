import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java .util.Scanner;

import static java.lang.System.*;

public class WheelOfFortuneMain {
    public static void main(String[] args) {
        int n = 5;
        out.println("******Hello and Welcome to the Wheel of Fortune!******");
        out.println("Instructions : A hidden phrase will be prompted and you will have to guess the characters of this phrase\n Only type 1 character at a time\n  You have "+n+" failed attempts possible");
        List<String> phraseList = null;
        int count = 0;
        StringBuilder goodGuesses = new StringBuilder();
        // Get the phrase from a file of phrases
        try {
            phraseList = Files.readAllLines(Paths.get("Phrases.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Get a random phrase from the list
        Random rand = new Random();
        int r = rand.nextInt(3); // gets 0, 1, or 2
        assert phraseList != null;
        String phrase = phraseList.get(r);

        //turn the phrase characters to asterisks
        StringBuilder hiddenPhrase = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (Character.isLetter(ch)) {
                hiddenPhrase.append('*');
                count++;
            } else {
                hiddenPhrase.append(ch);
            }

        }
        System.out.println(hiddenPhrase);

        //Get the players guesses and prompt answers
        Scanner in = new Scanner(System.in);


        while (n > 0 && count > 0) {
            boolean found = false;
            char guess1 = in.next().charAt(0);
            char guess2 = ' ';
            if (Character.isUpperCase(guess1)) {
                guess2 = Character.toLowerCase(guess1);
            } else {
                guess2 = Character.toUpperCase(guess1);
            }
            for (int i = 0; i < phrase.length(); i++) {
                if (guess1 == phrase.charAt(i)) {
                    hiddenPhrase.setCharAt(i, guess1);
                    found = true;

                }else if(guess2 == phrase.charAt(i)){
                    hiddenPhrase.setCharAt(i, guess2);
                    found = true;
                }

            }
            if (found) {
                out.println(hiddenPhrase);
            }
            if (Character.isLetter(guess1) && !found) {
                n--;
                out.println("Chances left :" + n);
            }
            if (!Character.isLetter(guess1)) {
                out.println("Warning the character should be a letter");
            }
            if (goodGuesses.toString().indexOf(guess1) != -1 && goodGuesses.toString().indexOf(guess2) != -1) {
                System.out.println("Warning you have already made this guess!");
            }
            for (int j = 0; j < hiddenPhrase.length(); j++) {
                if (hiddenPhrase.charAt(j) == guess1 && goodGuesses.toString().indexOf(guess1) == -1) {
                    count--;
                } else if (hiddenPhrase.charAt(j) == guess2 && goodGuesses.toString().indexOf(guess2) == -1) {

                    count--;
                }


            }
            goodGuesses.append(guess1);
            goodGuesses.append(guess2);


        }
        if(n==0){
        System.out.println("You lost");
        }else {
         System.out.println("Congratulations you won the game!");
        }
        }
    }


