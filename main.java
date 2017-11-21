import java.io.File;


import java.io.IOException;
 import java.util.Scanner;

 public class Assignment3

 {
 public static void main(String args[]) throws IOException
 {

 // Constants
 final int NUM_QUESTIONS = 10;
 final int NUM_PLAYERS = 2;


 // Variables
 int playerTurn = 1; // The current player
 int questionNum; // The current question number
 int playerAnswer; // The player's chosen answer
 int player1points = 0; // Player 1's points
 int player2points = 0; // Player 2's points


 // Create an array of Player objects for player #1 and player #2.
 player[] players = new player[NUM_PLAYERS];

 for (int i = 0; i < NUM_PLAYERS; i++)

 {

 players[i] = new player(i+1);

 }


 // Create an array to hold Question objects.
 questions[] questions = new questions [NUM_QUESTIONS];


 // Initialize the array with data.
 intQuestion(questions);


 // Play the game.
 for (int i = 0; i < NUM_QUESTIONS; i++)

 {
 // Display the question.
 Assignment3.displayQuestion(qArray[i], playerTurn);


 // Get the player's answer.
 players[playerTurn - 1].chooseAnswer();


 // See if the correct answer was chosen.
 if (qArray[i].getCorrectAnswerNumber() == players[playerTurn - 1].getCurrentAnswer())

 {

 players[playerTurn -1].incrementPoints();

 }


 // See if the the player chose the wrong answer.
 // do nothing
 // Switch players for the next iteration.

 if (playerTurn == 1)

 playerTurn = 2;

 else

 playerTurn = 1;

 }

 // Show the game results.
 showGameResults(players);
 }

 /**

 * The initQuestions method uses the contents of the trivia.txt file to

 * populate the qArray parameter with Question objects.

 */

 public static void initQuestions(questions qArray[]) throws IOException
 {

 // Open the trivia.txt file.

 File file = new File("trivia.txt");

 Scanner inputFile = new Scanner(file);


 // Populate the qArray with data from the file.
 for (int i = 0; i < qArray.length; i++)

 {

 // Create a Question object in the array.
 qArray[i] = new questions();


 // Get the question text from the file.
 qArray[i].setQuestion(inputFile.nextLine());


 // Get the possible answers.
 for (int j = 1; j <= 4; j++)

 {

 qArray[i].setPossibleAnswer(inputFile.nextLine(), j);

 }

 // Get the correct answer.
 qArray[i].setCorrectAnswerNumber(Integer.parseInt(inputFile.nextLine()));

 }
 }


 public static void displayQuestion(questions q, int playerNum)

 {

 // Display the player number.
 System.out.println("Question for player #" + playerNum);

 System.out.println("------------------------");


 // Display the question.
 System.out.println(q.getQuestionText());

 for (int i = 1; i <= 4; i++)

 {
 System.out.println(i + ". " + q.getPossibleAnswer(i));

 }

 }

 public static void showGameResults(player[] players)

 {

 // Display the stats.
 System.out.println("Game Over!");

 System.out.println("---------------------");

 System.out.println("Player 1's points: " + players[0].getPoints());

 System.out.println("Player 2's points: " + players[1].getPoints());


 // Declare the winner.
 if (players[0].getPoints() > players[1].getPoints())

 System.out.println("Player 1 wins!");

 else if (players[1].getPoints() > players[0].getPoints())

 System.out.println("Player 2 wins!");

 else

 System.out.println("It's a TIE!");
 }
 }
This is my player class

