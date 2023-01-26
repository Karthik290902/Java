/**
 * Realization of AI interface using simplistic random placement strategy.
 */

import java.util.Random;

public class DumbAI implements AI {
    
    private Random random = new Random();

    //edited
    private char aiPiece;
    
    /**
     * Construct a DumbAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX) {
        //edited
        if (aiIsX){
            aiPiece = 'X';
        }
        else{
            aiPiece = 'O';
        }
    }

    public void setPiece(char piece) {
       aiPiece = piece;
    }

    public Move chooseMove(Board board) {
        int i;
        int j;
        //while loop in java
        do{
            //0 included but 3 excluded
            i = random.nextInt(3);
            j = random.nextInt(3);
        }
        while (board.get(i,j) != ' ');

        return new Move(i,j,aiPiece);

    }
}
