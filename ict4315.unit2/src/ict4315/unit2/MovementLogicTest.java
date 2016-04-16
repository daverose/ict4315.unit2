package ict4315.unit2;
import org.junit.Test;

/**
 * Created by daverose on 4/9/16.
 */
public class MovementLogicTest {
    Board Board = new Board();
    Knight myKnight = new Knight();

    @Test
    public void testNextMove() throws Exception {
        int currentRow = 0;
        int currentCol = 0;
        int[] illegalMove = new int[2];
//In order for this test to work I'd have to break down the method into a different one.
// my board test already tests legalMove


    }

    @Test
    public void testClosedTour() throws Exception {

    }
}
//
//    public boolean nextMove() {
//        int[] moves = { 0, 0, 0, 0, 0, 0, 0, 0 };
//        int position = 0;
//        for (int i = 0; i < MyKnight.getMoves(); ++i) {
//            int r = currentRow + MyKnight.getHorizontal(i);
//            int c = currentCol + MyKnight.getVertical(i);
//            if (board.legalMove( r, c)) {
//                moves[position] = i;
//                ++position;
//            }
//        }
//        if (position > 0) {
//            int m = random.nextInt(position);
//            int n = moves[m];
//            currentRow += MyKnight.getHorizontal(n);
//            currentCol += MyKnight.getVertical(n);
//            return true;
//        } else {
//
//            return false;
//        }
//
//    }