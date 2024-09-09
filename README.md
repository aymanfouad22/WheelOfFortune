<!DOCTYPE html>
<html lang="en">
<body>
    <header>
        <h1>Wheel of Fortune Game</h1>
    </header>
    <section id="overview">
        <h2>Overview</h2>
        <p>The <strong>Wheel of Fortune Game</strong> is a console-based Java application inspired by the classic TV game show. Players guess letters to reveal a hidden phrase, with a limited number of attempts to guess the full phrase.</p>
    </section>
    <section id="commands">
        <h2>Commands</h2>       
        <h3>1. Clone the Repository</h3>
        <p>To clone the repository to your local machine, use the following command:</p>
        <pre><code>git clone https://github.com/yourusername/WheelOfFortuneObject.git</code></pre>        
        <h3>2. Navigate to the Project Directory</h3>
        <p>Change into the project directory:</p>
        <pre><code>cd WheelOfFortuneObject</code></pre>      
        <h3>3. Compile the Code</h3>
        <p>Ensure you have Java Development Kit (JDK) installed. Compile the Java source files with:</p>
        <pre><code>javac WheelOfFortuneMain.java</code></pre> 
        <h3>4. Run the Application</h3>
        <p>Run the compiled Java program:</p>
        <pre><code>java WheelOfFortuneMain</code></pre>   
        <h3>5. Prepare the Phrases File</h3>
        <p>Make sure a file named <code>Phrases.txt</code> is present in the project directory. This file should contain phrases separated by blank lines.</p>
    </section>
    <section id="usage">
    </section>
    <section id="development">
        <h2>Development Process</h2>
       <p>During development, several key issues were addressed:</p>
    <h2>File Reading Errors</h2>
    <p>Initially, the code failed when <code>Phrases.txt</code> was missing or incorrectly specified. This was resolved by using a <code>try-catch</code> block to handle <code>IOException</code>, ensuring user-friendly error messages:</p>
    <pre><code>try {
    phraseList = Files.readAllLines(Paths.get("Phrases.txt"));
} catch (IOException e) {
    System.out.println(e);
}
    </code></pre>
    <h2>Mismatch Between Phrase and Hidden Phrase Length</h2>
    <p>To ensure the hidden phrase correctly mirrors the original phrase's length, non-letter characters were preserved and letters were replaced with asterisks:</p>
    <pre><code>for (int i = 0; i &lt; phrase.length(); i++) {
    char ch = phrase.charAt(i);
    if (Character.isLetter(ch)) {
        hiddenPhrase.append('*');
    } else {
        hiddenPhrase.append(ch);
    }
}
    </code></pre>
    <h2>Guess Processing Logic</h2>
    <p>To handle both uppercase and lowercase guesses and update the hidden phrase accordingly, the following logic was implemented:</p>
    <pre><code>for (int i = 0; i &lt; phrase.length(); i++) {
    if (guess1 == phrase.charAt(i)) {
        hiddenPhrase.setCharAt(i, guess1);
    } else if (guess2 == phrase.charAt(i)) {
        hiddenPhrase.setCharAt(i, guess2);
    }
}
    </code></pre>
    <h2>What I Learned</h2>
    <p>Through this project, I learned the difference between applying <strong>static</strong> methods and <strong>instance</strong> methods, and their different structures. Static methods belong to the class and can be called without creating an instance, whereas instance methods require an object of the class to be invoked. This distinction affects how data is managed and accessed within the class.</p>
    </section>
    <section id="description">
        <h2>Description of What Was Completed</h2>
        <ul>
            <li>Reading the phrase from a file</li>
            <li>Replacing the phrase with asterisks</li>
            <li>Checking for a match between the guess and the characters in the hidden phrase while being case in sensitive</li>
            <li>Checking if there is a mismatch between the guess and the hidden phrase characters and losing one chance</li>
            <li>Notifying the player if he typed any non alphabetic character or repeated a good guess</li>
        </ul>
    </section>
    <section id="test-plan">
        <h2>Test Plan</h2>
       <p>I ran the game multiple time to ensure that the basic logic of the rules is not violated in any step Specifically:</p>
    <h3>Counter Testing</h3>
    <p>To make sure that the counter of failed and successful attempts are counting properly I had to print their values and correct the structure of the loops whenever a logical erorr occured, in this case count variable was decremented to keep track of how many hidden character are left in the phrase so that when it reached 0 the player will be declared as a winner</p>
    <pre><code>if (hiddenPhrase.charAt(j) == guess1 && goodGuesses.toString().indexOf(guess1) == -1) {
    count--;
    System.out.println("Count decremented. Current count: " + count);
} else if (hiddenPhrase.charAt(j) == guess2 && goodGuesses.toString().indexOf(guess2) == -1) {
    count--;
    System.out.println("Count decremented. Current count: " + count);
}
    </code></pre>
    <p>This output allowed me to track how the number of remaining attempts changes as guesses are processed, helping to ensure that the loop behaves as expected.</p>
    </section>
    <footer>
        <p><strong>License:</strong> This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>
    </footer>
</body>
</html>
