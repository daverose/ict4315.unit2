package ict4315.unit3;
import java.util.Random;
/**
 * Created by daverose on 4/13/16.
 */
public class BruteNextMove extends AbstractNextMove implements nextMove {
    Random random = new Random();
    private int[][] board = new int[8][8];
    private int currentRow = 0;
    private int currentCol = 0;
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
    public boolean hasMove(int row, int col){
            if (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS ) {
                return true;
            } else {
                return false;
            }
        }
    public boolean legalMove(int r, int c){
        if (hasMove( r, c) && onBoard(r,c)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean onBoard(int row, int col) {
        return (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS);
    }
    public int play() {
        int move = 0;
        do {
            ++move;
            board[currentRow][currentCol] = move;
        } while (nextMove());
        return move;
    }

    }

