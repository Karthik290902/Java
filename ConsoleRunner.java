/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 */

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleRunner {

    /**
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX;

    private Game game;
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    private Board board = new Board();
    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Constructor
     */
    public ConsoleRunner() {    
        /*
         * Use the 'next' method of Scanner and the 'matches' of the String
         * class to process user responses as strings.
         */
        //edited
        System.out.println("Do you want to play as X (Y/N):");
        String response1 = scanner.next();
        if (response1.matches("[yY]")){
            playerIsX = true;
        }
        else{
            playerIsX = false;
        }
        System.out.println("Do you want a challenge (Y/N):");
        String response2 = scanner.next();
        if (response2.matches("[yY]")){
            System.out.println("SmartAI is not implemented so we will use Dumb AI");
            game = new Game(playerIsX, false);
            }
        else{
            game = new Game(playerIsX, false);
        }
        System.out.println(game.getBoard().toString());
    }

    public void aiTurn(){

            System.out.println("After AI role");
            game.aiPlacePiece();
            System.out.println(game.getBoard().toString());

            if (game.getStatus() == GameStatus.X_WON || game.getStatus() == GameStatus.O_WON) {
                System.out.println("You Lost!!");
                System.exit(0);
            }
            if (game.getStatus() == GameStatus.DRAW) {
            System.out.println("Its a Draw!!");
            System.exit(0);
        }


    }
    public void playerTurn(){
        while (true) {

            System.out.println("Enter desired x-coordinate:");
            int response3 = scanner.nextInt();
            System.out.println("Enter desired y-coordinate:");
            int response4 = scanner.nextInt();
            //if (Arrays.binarySearch(validValues, response3) >= 0 && Arrays.binarySearch(validValues, response4) >= 0)
            if (game.placePlayerPiece(response4,response3)){
                // x and y are valid values
                System.out.println("After your move");
                //creating a new board with the updated move
                System.out.println(game.getBoard().toString());
                break;
            } else {
                // x or y is not a valid value
                System.out.println("Invalid input. Please enter a value between 0 and 2 for both x and y coordinates.");
            }
        }
        if (game.getStatus() == GameStatus.X_WON || game.getStatus() == GameStatus.O_WON) {
            System.out.println("You Won!!");
            System.exit(0);
        }
        if (game.getStatus() == GameStatus.DRAW) {
            System.out.println("Its a Draw!!");
            System.exit(0);
        }

    }
    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        while(game.getStatus()== GameStatus.IN_PROGRESS){
            if(playerIsX){
                playerTurn();
                aiTurn();
            }
            else{
                aiTurn();
                playerTurn();
            }
        }

        }
    }


