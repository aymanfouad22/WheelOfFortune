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
        <h3>Key Concepts</h3>
        <ul>
            <li><strong>String Manipulation:</strong> Utilized <code>StringBuilder</code> for efficient string operations.</li>
            <li><strong>Random Phrase Selection:</strong> Used <code>Random</code> to select a phrase from the list.</li>
            <li><strong>Character Checking:</strong> Handled case insensitivity and updated the hidden phrase.</li>
        </ul>
        <h3>Challenges and Solutions</h3>
        <ul>
            <li><strong>File Handling:</strong> Managed I/O operations with try-catch blocks.</li>
            <li><strong>Guess Tracking:</strong> Implemented logic to handle correct and incorrect guesses.</li>
        </ul>
        <h3>Algorithm Overview</h3>
        <ul>
            <li><strong>Initialization:</strong> Hidden phrase initialized with asterisks.</li>
            <li><strong>Processing Guesses:</strong> Updated hidden phrase based on user guesses.</li>
        </ul>
    </section>
    <section id="description">
        <h2>Description of What Was Completed</h2>
        <ul>
            <li>Implemented phrase reading and hidden phrase generation.</li>
            <li>Managed user guesses and attempts.</li>
            <li>Provided feedback and tracked previous guesses.</li>
        </ul>
    </section>
    <section id="test-plan">
        <h2>Test Plan</h2>
        <ul>
            <li><strong>File Reading:</strong> Verify correct phrase reading and selection.</li>
            <li><strong>Hidden Phrase Generation:</strong> Ensure accurate initialization with asterisks.</li>
            <li><strong>Guess Processing:</strong> Test correct and incorrect guesses.</li>
        </ul>
    </section>
    <footer>
        <p><strong>License:</strong> This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>
    </footer>
</body>
</html>
