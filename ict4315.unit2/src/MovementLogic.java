
import java.util.Random;

public class MovementLogic {
    int[][] board = new int[8][8];
    Random random = new Random();
    Knight MyKnight = new Knight();
    int currentRow, currentCol;
    int ROWS = 8;
    int COLUMNS = 8;

    public int play() {
        int move = 0;
        do {
            ++move;
            board[currentRow][currentCol] = move;
         //   System.out.println(move);
        } while (nextMove());

        return move;
    }

    public boolean nextMove() {
        //System.out.println("Inside nextMove()");
        int[] moves = { 0, 0, 0, 0, 0, 0, 0, 0 };
        int position = 0;
        for (int i = 0; i < MyKnight.MOVES; ++i) {
            int r = currentRow + MyKnight.HORIZONTAL[i];
            int c = currentCol + MyKnight.VERTICAL[i];
           // System.out.println("ROW: " + r + " COL: " + c);
          //  r and c are working as expected
            if (legalMove( r, c)) {
                moves[position] = i;
                ++position;
           // System.out.println("This is the position :" + position);
            }
        }
        if (position > 0) {
            int m = random.nextInt(position);
            currentRow += MyKnight.HORIZONTAL[moves[m]];
            currentCol += MyKnight.VERTICAL[moves[m]];
        //   System.out.println("More than one choice");
            return true;
        } else {

            return false;
        }

    }
    boolean legalMove(final int row, final int col) {
       //System.out.println("ROW: " + row + " COL: " + col);
        if (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS && board[row][col] == 0) {
         //   System.out.println("move was legal");
            return true;
        } else {
        //    System.out.println("move was NOT legal");
            return false;
        }
    }
    public void printBoard() {
        int ROWS = 8;
        int COLUMNS = 8;
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLUMNS; ++j) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }

    boolean closedTour(int beginRow, int beginCol) {
        for (int i = 0; i < MyKnight.MOVES; ++i) {
            System.out.println(currentRow + " " + currentCol + " " + MyKnight.HORIZONTAL[i] + " " + MyKnight.VERTICAL[i]);
            if (currentRow + MyKnight.HORIZONTAL[i] == beginRow && currentCol + MyKnight.VERTICAL[i] == beginCol) {
                return true;
            }
        }
        return false;
    }

}
