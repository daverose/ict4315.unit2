/**
 * Created by daverose on 4/2/16.
 */
import java.util.Random;
public class Knight {
    private static int currentRow;
    private static int currentCol;
    public static final int MOVES = 8;
    public static final int[] HORIZONTAL = {2, 1, -1, -2, -2, -1, 1, 2};
    public static final int[] VERTICAL = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static Random random = new Random();

    public static boolean nextMove() {
        int[] moves = {0, 0, 0, 0, 0, 0, 0, 0};
        int position = 0;
        for (int i = 0; i < MOVES; ++i) {
            int r = currentRow + HORIZONTAL[i];
            int c = currentCol + VERTICAL[i];
            if (Game.legalMove(r, c)) {
                moves[position] = i;
                ++position;

            }
        }
        if (position > 0) {
            int m = random.nextInt(position);
            currentRow += HORIZONTAL[moves[m]];
            currentCol += VERTICAL[moves[m]];
          //  System.out.println("returning TRUE");
            System.out.println("pos > zero");
            return true;
        } else {
            System.out.println("Knight nextMove is FALSE");
            return false;
        }

    }
}

