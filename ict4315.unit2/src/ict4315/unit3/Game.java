package ict4315.unit3;

public class Game {
    public static void main(String[] args) {
        int ROWS = 8;
        int COLUMNS = 8;
        int count = 0;
        int moves;
        for (; count < 10000000; ++count) {
            Board BruteBoard = new Board();
            BruteNextMove BruteNextMove = new BruteNextMove();
         //   BruteBoard.setCurrRowAndCurrColToZero();
            for (int i = 0; i < ROWS; ++i) {
                for (int j = 0; j < COLUMNS; ++j) {
                    BruteBoard.setBoard(i,j,0);
                }
            }
            /*System.out.println("Inside main");*/
            moves = BruteNextMove.play();
            if (moves == 64) {
                if (BruteNextMove.closedTour(0, 0)) {
                    System.out.println("Brute Force Closed Tour!");
                } else {
                    System.out.println("Brute Force Full Tour!");
                }
                BruteBoard.printBoard();
                break;
            }
            if (count % 100000 == 0) {
                System.out.println("Working on brute force " + count / 100000);
            }
        }
        System.out.println("Brute Force Trials: " + count);
        Board HeuristicBoard = new Board();
        HeuristicNextMove HeuristicNextMove = new HeuristicNextMove();
        HeuristicBoard.initialize();

        for (int row = 0; row < ROWS / 2; ++row) {
            for (int col = (ROWS / 2 - 1); col >= row; --col) {
                HeuristicBoard.initialize();
                HeuristicNextMove.setCurrentCol(col);
                HeuristicNextMove.setCurrentRow(row);
                moves = HeuristicNextMove.play();
                if (moves == 64) {
                    if (HeuristicNextMove.closedTour(row, col)) {
                        System.out.println("Heuristic Closed Tour!");
                    } else {
                        System.out.println("Heuristic Full Tour!");
                    }
                }
                HeuristicBoard.printBoard();
                System.out.println();
            }
        }
    }
}
