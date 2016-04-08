
import java.util.Random;

public class MovementLogic {
    Board board = new Board();
    Random random = new Random();
    Knight MyKnight = new Knight();
    int currentRow, currentCol;


    public int play() {
        int move = 0;
        do {
            ++move;
            board.board[currentRow][currentCol] = move;
        } while (nextMove());

        return move;
    }

    public boolean nextMove() {
        int[] moves = { 0, 0, 0, 0, 0, 0, 0, 0 };
        int position = 0;
        for (int i = 0; i < MyKnight.MOVES; ++i) {
            int r = currentRow + MyKnight.HORIZONTAL[i];
            int c = currentCol + MyKnight.VERTICAL[i];
            if (board.legalMove( r, c)) {
                moves[position] = i;
                ++position;
            }
        }
        if (position > 0) {
            int m = random.nextInt(position);
            currentRow += MyKnight.HORIZONTAL[moves[m]];
            currentCol += MyKnight.VERTICAL[moves[m]];
            return true;
        } else {

            return false;
        }

    }



    boolean closedTour(int beginRow, int beginCol) {
        for (int i = 0; i < MyKnight.MOVES; ++i) {
            System.out.println(currentRow + " " + currentCol + " " + MyKnight.HORIZONTAL[i] + " " + MyKnight.VERTICAL[i]);
            if (currentRow + MyKnight.HORIZONTAL[i] == beginRow && currentCol + MyKnight.VERTICAL[i] == beginCol) {
                return true;
            }
        }
        return false;
    }

}
