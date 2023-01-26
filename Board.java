/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 */

public class Board {

    private char[][] board = new char[3][3];

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct an empty board (contains all space char's).
     */
    public Board() {
        //edited
        //creating new board
        //3 for the rows
        for (int i = 0; i< 3; i++){
            //3 for the columns
            for (int j =0; j< 3;j++){
                board[i][j]= ' ' ;
            }

        }
    }

    /**
     * Given the 'other' board as a starting condition, apply the given
     * 'move' to generate this board's state.
     */
    public Board(Board other, Move move) {
        //edited
        //creating new board using "other" board
        for (int i =0; i<3; i++){
            for (int j =0; j<3; j++){
                board[i][j] = other.get(i,j);
            }
        }
        //implementing the move played
        int i = move.getI();
        int j = move.getJ();
        char piece = move.getPiece();
        board[i][j] = piece;

    }

    /**
     * Convert to a string that shows the board's state.
     */
    public String toString() {
        //edited
        //printing the table
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("---------------\n");
            for (int j = 0; j < 3; j++) {
                sb.append(" | " + board[i][j]);
            }
            sb.append(" |");
            sb.append("\n");
        }
        sb.append("---------------");
        return(sb.toString());
    }

    /**
     * Get the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
        //returning the char in the board in the at index (i,j)
        return board[i][j];
    }
    
    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {
        boolean result = true;
        for (int i=0; i<3;i++){
            for (int j=0; j<3; j++){
                if (board[i][j] == ' ') {
                    result = false;
                }
            }
        }
        return result;
    }
}
