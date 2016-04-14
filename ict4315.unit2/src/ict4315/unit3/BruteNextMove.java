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
           // System.out.println("Inside nextMove and row and col is : " + currentCol + " " + currentRow);
            return true;
        } else {
           // System.out.println("no Moves!");
            return false;
        }

    }
//    public boolean hasMove(int row, int col){
//            if (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS ) {
//                return true;
//            } else {
//                return false;
//            }
//        }
    public boolean legalMove(int row, int col) {
        if (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS && board[row][col] == 0) {
            return true;
        } else {
            return false;
        }
    }
//    public boolean legalMove(int r, int c){
//        if (hasMove( r, c) && onBoard(r,c)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    public boolean onBoard(int row, int col) {
//        return (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS);
//    }
//
    public int play() {
        int move = 0;
        do {
            ++move;
            board[currentRow][currentCol] = move;
        //  System.out.println("Inside play board is " + board[currentRow][currentCol]);
        } while (nextMove());
        return move;
    }

    }

