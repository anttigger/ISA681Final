import java.util.Scanner;
 public class player

 {

 private int playerNumber; // The player number
 private int points; // Player's points
 private int currentAnswer; // Current chosen answer


 //Constructor
 public player(int playerNum)

 {

 playerNumber = playerNum;

 points = 0;

 }

 public void chooseAnswer()

 {
 // Create a Scanner object for keyboard input.
 // Get the user's chosen answer.


 Scanner keyboard = new Scanner(System.in);

 System.out.print("Please enter your Answer"); //Asks user for a number

 this.currentAnswer = keyboard.nextInt();

 }

 public int getCurrentAnswer()

 {

 return this.currentAnswer; //Returns Current Answer

 }

 public void incrementPoints()

 {

 this.points++; //Increments the points

 }

 public int getPoints()

 {

 return this.points; //Returns the points

 }
 } 