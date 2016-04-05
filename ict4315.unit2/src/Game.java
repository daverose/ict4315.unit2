import java.util.Random;

/**
 * Created by daverose on 4/2/16.
 */
public class Game {
    private static int currentRow;
    private static int currentCol;
    private static int moves = 0;
    private static Random random = new Random();

    private static int[][] GameBoard = Board.createBoard();


    private static int play() {
        int move = 0;
        do {
            ++move;
            GameBoard[currentRow][currentCol] = move;
        } while (nextMove());
        return move;
    }

    private static boolean nextMove() {
        int[] moves = {0, 0, 0, 0, 0, 0, 0, 0};
        int position = 0;
        for (int i = 0; i < Knight.MOVES; ++i) {
            int r = currentRow + Knight.HORIZONTAL[i];
            int c = currentCol + Knight.VERTICAL[i];
            if (legalMove(r, c)) {
                moves[position] = i;
                ++position;
            }
        }

        if (position > 0) {
            int m = random.nextInt(position);
            currentRow += Knight.HORIZONTAL[moves[m]];
            currentCol += Knight.VERTICAL[moves[m]];
            return true;
        } else {
            return false;
        }
    }

    private static boolean legalMove(final int row, final int col) {
        if (row >= 0 && col >= 0 && row < GameBoard[0].length && col < GameBoard[2].length && GameBoard[row][col] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean closedTour(final int beginRow, final int beginCol) {
        for (int i = 0; i < Knight.MOVES; ++i) {
            if (currentRow + Knight.HORIZONTAL[i] == beginRow && currentCol + Knight.VERTICAL[i] == beginCol) {
                return true;
            }
        }
        return false;
    }

    public static void printBoard() {
        for (int i = 0; i < GameBoard[0].length; ++i) {
            for (int j = 0; j < GameBoard[1].length; ++j) {
                System.out.printf("%2d ", GameBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int count = 0;
        for (; count < 10000000; ++count) {
            currentRow = 0;
            currentCol = 0;
            for (int i = 0; i < GameBoard[0].length; ++i) {
                for (int j = 0; j < GameBoard[1].length; ++j) {
                    GameBoard[i][j] = 0;
                }
            }
            moves = play();
            if (moves == 64) {
                if (closedTour(0, 0)) {
                    System.out.println("Closed Tour!");
                } else {
                    System.out.println("Full Tour!");
                }
                printBoard();
                break;
            }
            if (count % 100000 == 0) {
                System.out.println(count / 100000);
            }
        }
        System.out.println("Trials: " + count);
    }


}


