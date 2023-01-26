import java.util.Arrays;
import java.util.Scanner;

/**
 * Represents the logic of the game in terms of detecting wins or draws.  Also
 * places new pieces for the human player or AI.
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;

    /*
     * TBD: Create additional private members if useful.
     */
    // to store the boolean value if ai is X or not
    private boolean aiIsX;
    private Scanner scanner = new Scanner(System.in);
    private boolean playerIsX;
    //to store the character the player is using
    private char player;
    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {
        //edited
        aiIsX = !playerIsX;
        this.playerIsX = playerIsX;
        status = GameStatus.IN_PROGRESS;
        if (challenging){
            ai = new SmartAI(aiIsX);
        }
        else{
            ai = new DumbAI(aiIsX);
        }

        if(playerIsX){
            player = 'X';
            }
        else{
            player = 'O';
        }

    }

    //setting value of playerIsX

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
        //edited
        //TBD
        return board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
        return status;}
    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */


    public boolean placePlayerPiece(int i, int j) {
        if (status == GameStatus.IN_PROGRESS && (i >= 0 && i < 3) && (j >= 0 && j < 3) && board.get(i, j) == ' ') {
            board = new Board(board, new Move(i, j, player));
            setStatus();
            return true;
        } else
            return false;

    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
        //edited
        if (status == GameStatus.IN_PROGRESS){
            Move move = ai.chooseMove(board);
            board = new Board(board, move);
            setStatus();
        }
    }
    private void setStatus() {
        if (board.isFull())
            status = GameStatus.DRAW;
        else
            status = GameStatus.IN_PROGRESS;

        if ((board.get(0, 0) == 'X' && board.get(0, 1) == 'X' && board.get(0, 2) == 'X')
                || (board.get(1, 0) == 'X' && board.get(1, 1) == 'X' && board.get(1, 2) == 'X')
                || (board.get(2, 0) == 'X' && board.get(2, 1) == 'X' && board.get(2, 2) == 'X')
                || (board.get(0, 0) == 'X' && board.get(1, 0) == 'X' && board.get(2, 0) == 'X')
                || (board.get(0, 1) == 'X' && board.get(1, 1) == 'X' && board.get(2, 1) == 'X')
                || (board.get(0, 2) == 'X' && board.get(1, 2) == 'X' && board.get(2, 2) == 'X')
                || (board.get(0, 0) == 'X' && board.get(1, 1) == 'X' && board.get(2, 2) == 'X')
                || (board.get(0, 2) == 'X' && board.get(1, 1) == 'X' && board.get(2, 0) == 'X')
        )
            status = GameStatus.X_WON;
        else if ((board.get(0, 0) == 'O' && board.get(0, 1) == 'O' && board.get(0, 2) == 'O')
                || (board.get(1, 0) == 'O' && board.get(1, 1) == 'O' && board.get(1, 2) == 'O')
                || (board.get(2, 0) == 'O' && board.get(2, 1) == 'O' && board.get(2, 2) == 'O')
                || (board.get(0, 0) == 'O' && board.get(1, 0) == 'O' && board.get(2, 0) == 'O')
                || (board.get(0, 1) == 'O' && board.get(1, 1) == 'O' && board.get(2, 1) == 'O')
                || (board.get(0, 2) == 'O' && board.get(1, 2) == 'O' && board.get(2, 2) == 'O')
                || (board.get(0, 0) == 'O' && board.get(1, 1) == 'O' && board.get(2, 2) == 'O')
                || (board.get(0, 2) == 'O' && board.get(1, 1) == 'O' && board.get(2, 0) == 'O')
        )
            status = GameStatus.O_WON;
    }
}
