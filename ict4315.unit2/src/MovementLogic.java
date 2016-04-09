import java.util.Random;

public class MovementLogic {
    Board board = new Board();
    Random random = new Random();
    Knight MyKnight = new Knight();
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
        for (int i = 0; i < MyKnight.getMoves(); ++i) {
            int r = currentRow + MyKnight.getHorizontal(i);
            int c = currentCol + MyKnight.getVertical(i);
            if (board.legalMove( r, c)) {
                moves[position] = i;
                ++position;
            }
        }
        if (position > 0) {
            int m = random.nextInt(position);
            int n = moves[m];
            currentRow += MyKnight.getHorizontal(n);
            currentCol += MyKnight.getVertical(n);
            return true;
        } else {

            return false;
        }

    }
    boolean closedTour(int beginRow, int beginCol) {
        for (int i = 0; i < MyKnight.getMoves(); ++i) {
            if (currentRow + MyKnight.getHorizontal(i) == beginRow && currentCol + MyKnight.getVertical(i) == beginCol) {
                return true;
            }
        }
        return false;
    }

}
