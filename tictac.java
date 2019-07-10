package freshtictacs;

import java.util.Scanner;

public class tictac {
	public static Scanner input= new Scanner(System.in);
	public static String[][] grid= new String [3][3];
	public static int row;
	public static int column;
	public static String placement = "x";
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int y = 0; y < 3; y++) {
				grid[i][y] = "_" ;
			}
		}
		
		Game();
		//displayGame();
		
	}
			
		//starts with title and game than instructions. than sends input to endGame
		 public static void Game() {
			 boolean active = true; //were playing the game TRUTH
			 while (active) {
				 System.out.println("TicTacToe:");
				 displayGame();
				 System.out.println("enter your row # (1,2,3)");
				 row = input.nextInt() -1; // lets set this -1 cus array starts 0
				 System.out.println("enter your column # (1,2,3)");
				 column = input.nextInt() -1; 
				 grid[row][column] = placement;
				 
				 //this sends to our endGame to look for parameters being met
				 if(endGame(row,column)) {
					 active = false;
					 System.out.println("Game over!" +"PLACEHOLDER FOR WINNER O OR X" + " wins");
				 }
				 
				 // if that happens this starts the game over through our display function
				 displayGame();
				 
				 if (placement == "x") //first player is x
					 placement = "o"; //if last was x now its second player o
				 else
					 placement = "x"; // and it was o before now its back to x
			 }
			 
		 } //end Game
		 
		 public static void displayGame() {
			 for (int i = 0; i < 3; i++) {
				 System.out.println();
			 
					for (int y=0; y <3; y++) {
						if (y == 0)
							System.out.print("|");
						
						System.out.print(grid[i][y] + "|");
						
						
					}
			 }
			 //outside of displayGame forloop
			 
			 System.out.println();
			 System.out.println();
			 
		 }//end displayGame
		
		 
		 //deciding win conditions through grid placements
		 public static boolean endGame(int rowPlacement, int columnPlacement) {
			 
			 //horizontal wins
			 if (grid[0][columnPlacement] == grid[1][columnPlacement]
					 && grid[0][columnPlacement] == grid[2][columnPlacement])
				 return true;
			 if (grid[rowPlacement][0] == grid[rowPlacement][1]
					 && grid[rowPlacement][0] == grid[rowPlacement][2])
				 return true;
			 
			 //diagonal wins
			 if (grid[0][0] == grid[1][1]
					 && grid[0][0] == grid[2][2]
				 && grid[1][1] !="_")
				 return true;
			 
			 if (grid[0][2] == grid[1][1]
					 && grid[2][0] == grid[0][2]
				 && grid[1][1] !="_")
				 return true;
			 
			 //otherwise...
			 
				 
			 
			 return false;
		 }//end endGame
		 
	}//ends class


