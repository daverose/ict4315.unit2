/**
 * Created by daverose on 4/2/16.
 */
public class Board {
    private int[][] board = new int[8][8];
    private int rows = 8;
    private int columns = 8;
    public Board(){

    }
    public void setBoard(int row, int col, int val) {
        board[row][col] = val;
    }
    public boolean legalMove(int row, int col) {
        if (row >= 0 && col >= 0 && row < rows && col < columns && board[row][col] == 0) {
            return true;
        } else {
            return false;
        }
    }
    public void printBoard() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }
}
