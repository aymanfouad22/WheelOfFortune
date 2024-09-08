import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java .util.Scanner;

import static java.lang.System.*;

public class WheelOfFortuneMain {
    public static void main(String[] args) {

        out.println("******Hello and Welcome to the Wheel of Fortune!****");
        out.println("Instruction : A hidden phrase will be prompted and you will have to guess the characters of this phrase");
        List<String> phraseList = null;
        int count = 0;
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
        out.println(phrase);

        //turn the phrase characters to asterisks
        StringBuilder hiddenPhrase = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
         char   ch = phrase.charAt(i);
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
        int n = 5;

        while (n > 0 && count > 0) {
            boolean found = false;
           char guess = in.next().charAt(0);
            for (int i = 0; i < phrase.length(); i++) {
                if (guess == phrase.charAt(i)) {
                    hiddenPhrase.setCharAt(i, guess);
                    found = true;

                }

            }
            if (found) {
                out.println(hiddenPhrase);
            }
            if (Character.isLetter(guess) && !found) {
                n--;
                out.println("Chances left :" + n);
            }
            if (!Character.isLetter(guess)) {
                out.println("Warning the character should be a letter");
            }
            for (int j = 0; j < hiddenPhrase.length(); j++) {
                if (hiddenPhrase.charAt(j) == guess) {
                    count--;
                    System.out.println(count);
                }
            }




        }
        out.println("Game is finished!");
    }
}
