import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    //Create a 3x3 array that represents tic tac toe board
		char [][] board = new char[3][3];

    //set every spot in the array to empty ('-')
    for(int i = 0; i < 3; i++) {
			  for(int j = 0; j < 3; j++) {
				  board[i][j] = '-';
			  }
		  }

    //Welcome players to game
    Scanner myObj = new Scanner(System.in);
    System.out.println("Welcome to Tic Tac Toe");

    //get each player's name
    String player1 = "";
    String player2 = "";
    System.out.println("Player 1, enter name: ");
    player1 = myObj.next();

    System.out.println("Player 2, enter name: ");
    player2 = myObj.next();

    //initialize variables that will determine end of game
    boolean playerHasWon = false;
    //initialize variables that will determine turns
    boolean player1Turn = true;

    //initialize varibale that will help locate the spot on the board the user has chosen
    int rowChosen = 0;
    int columnChosen = 0;

    //Initialize while loop to run until there is a winner
    while (playerHasWon == false) {
      //print adaptive board as well as reference board used to pinpoint a location on the board
      System.out.println();
      System.out.println("Current Board:");
      displayBoard(board);
      System.out.println();
      System.out.println("Reference Board:");
      referenceBoard();
      System.out.println();


      //state whose turn it is
      if (player1Turn == true) {
        System.out.println(player1 + "'s turn (x)");
      } else {
        System.out.println(player2 + "'s turn (o)");
      }

      //prompt the user to input which spot they want to take - ensure they input a valid location
      while(true){
        System.out.println("Which spot would you like to place your marker on? (0-8)");
        int placeChosen = myObj.nextInt();

        //Determine the row and column they chose 
        rowChosen = placeChosen / 3;
        columnChosen = placeChosen % 3;

        //Ensure the input is valid or else stay in the while loop to enter another input
        if (placeChosen < 0 || placeChosen > 8) {
          System.out.println("This spot is off the board, try again");
        } else if (board[rowChosen][columnChosen] != '-'){
          System.out.println("This spot has already been chosen");
          
        } else if (placeChosen > -1 || placeChosen < 9) {
          break;
        } else {
          System.out.println("This is not a valid input, try again");
        }

      }

      //add the players symbol to the spot they selected
      if (player1Turn == true) {
        board[rowChosen][columnChosen] = 'x';
        player1Turn = false;
      } else {
        board[rowChosen][columnChosen] = 'o';
        player1Turn = true;
      }

      //check to see if someone has won using function, if yes, display the final board and end the game
      if(playerWon(board) == 'x') {
				System.out.println(player1 + " has won!");
        displayBoard(board);

				playerHasWon = true;
			} else if(playerWon(board) == 'o') {
				System.out.println(player2 + " has won!");
        displayBoard(board);
				playerHasWon = true;  

    }
      boolean status = fullBoard(board);
      //check to see if the board is full, if yes, display the final board and end it as a tie
      if (status == true) {
        System.out.println("It's a tie");
        displayBoard(board);
        playerHasWon = true;
      }
  }
    //thank the user for playing
    System.out.println("Thanks for playing!");

    }
    
  

  //create a method that loops through every element within the board array and prints it
  public static void displayBoard (char[][] board) {
    for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
      System.out.println();
		  }
  }
  //create a method to print the static reference board
  public static void referenceBoard() {
    //intialize the variable that will increase for every spot on the reference board
    int placeVar = 0;
    //initialize the empty reference board array
    int [][] refBoard = new int[3][3];

		
		//add numbers to the board
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				refBoard[i][j] = placeVar;
        placeVar++;
        System.out.print(refBoard[i][j]);
			}
      System.out.println();

		}
  }

  //create a method that checks if any player has won, returns the player's marker if they won and nothing if nobody has won yet
  public static char playerWon(char[][] board) {
    //first it checks the rows to see if there is a row of the same markers
    for(int i = 0; i < 3; i++) {
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
				return board[i][0];
			}
		}

		//then check each column for the same markers
		for(int j = 0; j < 3; j++) {
			if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
				return board[0][j];
			}
		}

		//then check the diagonals
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
			return board[0][0];
		}
		if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
			return board[2][0];
		}

		//Otherwise nobody has not won yet
		return ' ';

  }


  //create a method to check if the board is full
  public static boolean fullBoard(char[][] board) {
    //checks to see if there are any blank spaces on the board
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == '-') {
          //if there are blank spots, return the board is not full
					return false;
				}
			}
		}
    //if no blank spots, return the board is full
		return true;
	}
       }
