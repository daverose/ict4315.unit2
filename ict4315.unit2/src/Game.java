
public class Game {
    public static void main(String[] args) {
        int ROWS = 8;
        int COLUMNS = 8;
        MovementLogic Logic = new MovementLogic();
        int[][] board = new int[ROWS][COLUMNS];
        int count = 0;
        int moves;
        for (; count < 10000000; ++count) {
            Logic.currentCol = 0;
            Logic.currentCol = 0;
            for (int i = 0; i < ROWS; ++i) {
                for (int j = 0; j < COLUMNS; ++j) {
                    board[i][j] = 0;
                }
            }
            moves = Logic.play();
            System.out.println(moves);
            if (moves == 64) {
                if (Logic.closedTour(0, 0)) {
                    System.out.println("Closed Tour!");
                } else {
                    System.out.println("Full Tour!");
                }
                Logic.printBoard();
                break;
            }
            if (count % 100000 == 0) {
                System.out.println(count / 100000);
            }
        }
        System.out.println("Trials: " + count);
    }
}


