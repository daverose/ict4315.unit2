import java.util.Random;

public class MovementLogic {
    Board board = new Board();
    Random random = new Random();
    Knight myKnight = new Knight();
    private int currentRow, currentCol;


    public int play() {
        int move = 0;
        do {
            ++move;
            board.setBoard(currentRow, currentCol, move);
        } while (nextMove());

        return move;
    }
    public void setCurrRowAndCurrColToZero(){
    currentRow = 0;
    currentCol = 0;
    }

    public boolean nextMove() {
        int[] moves = { 0, 0, 0, 0, 0, 0, 0, 0 };
        int position = 0;
        for (int i = 0; i < myKnight.getMoves(); ++i) {
            int r = currentRow + myKnight.getHorizontal(i);
            int c = currentCol + myKnight.getVertical(i);
            if (board.legalMove( r, c)) {
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
    boolean closedTour(int beginRow, int beginCol) {
        for (int i = 0; i < myKnight.getMoves(); ++i) {
            if (currentRow + myKnight.getHorizontal(i) == beginRow && currentCol + myKnight.getVertical(i) == beginCol) {
                return true;
            }
        }
        return false;
    }

}
