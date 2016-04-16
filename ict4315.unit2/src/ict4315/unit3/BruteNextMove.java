package ict4315.unit3;
import java.util.Random;

public class BruteNextMove extends AbstractNextMove implements nextMove {
    //Board board = new Board();
    Random random = new Random();
    Knight myKnight = new Knight();
    private int[][] board = new int[8][8];
    private int currentRow;
    private int currentCol;
    public boolean nextMove() {
        int[] moves = { 0, 0, 0, 0, 0, 0, 0, 0 };
        int position = 0;
        for (int i = 0; i < myKnight.getMoves(); ++i) {
            int r = currentRow + myKnight.getHorizontal(i);
            int c = currentCol + myKnight.getVertical(i);
            if (legalMove( r, c)) {
                moves[position] = i;
                ++position;
            }
        }
        if (position > 0) {
            int m = random.nextInt(position);
            int n = moves[m];
            currentRow += myKnight.getHorizontal(n);
            currentCol += myKnight.getVertical(n);
            return true;
        } else {
            return false;
        }

    }

    public boolean legalMove(int row, int col) {
        if (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS && board[row][col] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int play() {
        int move = 0;
        do {
            ++move;
            board[currentRow][currentCol] = move;
        } while (nextMove());
        return move;
    }
    public void printBoard() {
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLUMNS; ++j) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }

}