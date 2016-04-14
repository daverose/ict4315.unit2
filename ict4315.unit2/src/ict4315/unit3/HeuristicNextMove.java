package ict4315.unit3;


public class HeuristicNextMove extends AbstractNextMove implements nextMove{
    private int[][] board = new int[8][8];
    private int currentRow = 0;
    private int currentCol = 0;
    public boolean nextMove() {
        int move = -1;
        int access = 9;
        for (int i = 0; i < myKnight.getMoves(); ++i) {
            int r = currentRow + myKnight.getHorizontal(i);
            int c = currentCol + myKnight.getVertical(i);
            if (legalMove(r, c)) {
                if (board[r][c] < access) {
                    access = board[r][c];
                    move = i;
                }
            }
        }

        if (move != -1) {
            reduceAccess();
            currentRow += myKnight.getHorizontal(move);
            currentCol += myKnight.getVertical(move);
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
    public void reduceAccess() {
        for (int i = 0; i < myKnight.getMoves(); ++i) {
            int r = currentRow + myKnight.getHorizontal(i);
            int c = currentCol + myKnight.getVertical(i);
            if (onBoard(r, c) && board[r][c] > 0) {
                --board[r][c];
            }
        }

    }

}
