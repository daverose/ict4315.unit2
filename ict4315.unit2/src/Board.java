/**
 * Created by daverose on 4/2/16.
 */
public class Board {
     int[][] board = new int[8][8];
    int ROWS = 8;
    int COLUMNS = 8;
    public Board(){

    }
    boolean legalMove(int row, int col) {
        if (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS && board[row][col] == 0) {
            return true;
        } else {
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
}
