import java.util.Arrays;

/**
 * Created by daverose on 4/2/16.
 */
public class Game {
    private static int currentRow;
    private static int currentCol;
    private static int moves = 0;
    static Board GameBoard = new Board();


     static boolean legalMove(final int row, final int col) {
        if (row >= 0 && col >= 0 && row < GameBoard.board[0].length && col < GameBoard.board[2].length && GameBoard.board[row][col] == 0) {
          System.out.println("Inside legalMove() and TRUE");
            return true;
        } else {
         System.out.println("Inside legalMove() and FALSE");
            return false;
        }
    }

    private static boolean closedTour(final int beginRow, final int beginCol) {
        for (int i = 0; i < Knight.MOVES; ++i) {
            if (currentRow + Knight.HORIZONTAL[i] == beginRow && currentCol + Knight.VERTICAL[i] == beginCol) {
                System.out.println("Inside closedTour and TRUE");
                return true;
            }
        }
        System.out.println("Inside closedTour and FALSE");
        return false;
    }

    public static void printBoard() {
        for (int i = 0; i < GameBoard.board[0].length; ++i) {
            for (int j = 0; j < GameBoard.board[1].length; ++j) {
                System.out.printf("%2d ", GameBoard.board[i][j]);
               // System.out.println("inside the J loop of print board");
            }
            System.out.println();
        }
    }
    private static int play() {
        int move = 0;
        do {
            ++move;
            GameBoard.board[currentRow][currentCol] = move;
        //  System.out.println(move);
        } while (Knight.nextMove());
       System.out.println("Move should return");
        return move;
    }
    public static void main(String[] args) {
        int count = 0;
        for (; count < 10000000; ++count) {
            currentRow = 0;
            currentCol = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    GameBoard.board[i][j] = 0;
                //   System.out.println(Arrays.toString(GameBoard.board[i]) + " " + Arrays.toString(GameBoard.board[j]));
                }
            }
            System.out.println("Before call to play()");
            moves = play();
            System.out.println("After call to play()");
            System.out.println(moves);
            if (moves == 64) {
                if (closedTour(0, 0)) {
                    System.out.println("Closed Tour!");
                } else {
                    System.out.println("Full Tour!");
                }
                printBoard();
                break;
            }
            if (count % 1000 == 0) {
                System.out.println(count / 1000);
            }
        }
        System.out.println("Trials: " + count);
    }


}


