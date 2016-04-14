package ict4315.unit3;

public class Heuristic {
  /**
   * The number of rows on the chessboard
   */
  public static final int ROWS = 8;

  /**
   * The number of columns on the chessboard
   */
  public static final int COLUMNS = 8;

  /**
   * The number of possible moves that a knight can make. This is really just
   * the length of the HORIZONTAL and VERTICAL arrays.
   */
  public static final int MOVES = 8;

  /**
   * The possible moves that the knight can make horizontally. This pairs up
   * with the VERTICAL array.
   */
  public static final int[] HORIZONTAL = { 2, 1, -1, -2, -2, -1, 1, 2 };

  /**
   * The possible moves that the knight can make vertically. This pairs up with
   * the HORIZONTAL array.
   */
  public static final int[] VERTICAL = { -1, -2, -2, -1, 1, 2, 2, 1 };

  /**
   * The internal representation of the chessboard.
   */
  private static int[][] board = new int[ROWS][COLUMNS];

  /**
   * The accessibility matrix with the initial accessibility numbers.
   */
  private static final int[][] INITIAL_ACCESSIBILITY = { 
      { 2, 3, 4, 4, 4, 4, 3, 2 }, 
      { 3, 4, 6, 6, 6, 6, 4, 3 },
      { 4, 6, 8, 8, 8, 8, 6, 4 }, 
      { 4, 6, 8, 8, 8, 8, 6, 4 }, 
      { 4, 6, 8, 8, 8, 8, 6, 4 }, 
      { 4, 6, 8, 8, 8, 8, 6, 4 },
      { 3, 4, 6, 6, 6, 6, 4, 3 }, 
      { 2, 3, 4, 4, 4, 4, 3, 2 } };
  
  private static int[][] accessibility;

  /**
   * The current row.
   */
  private static int currentRow;

  /**
   * The current column.
   */
  private static int currentCol;

  /**
   * How many moves have been made in this tour.
   */
  private static int moves = 0;

  /**
   * Play the game and return the number of moves made.
   * 
   * @return the number of moves made
   */
  private static int play() {
    int move = 0;
    do {
      ++move;
      board[currentRow][currentCol] = move;
    } while (nextMove());
    return move;
  }

  /**
   * Calculate the next move and make it if there is a possible move. If more
   * than one move is possible, then choose the first move with the lowest
   * accessibility number.
   * 
   * @return true if a move was made and false otherwise.
   */
  private static boolean nextMove() {
    int move = -1;
    int access = 9;
    for (int i = 0; i < MOVES; ++i) {
      int r = currentRow + HORIZONTAL[i];
      int c = currentCol + VERTICAL[i];
      if (legalMove(r, c)) {
        if (accessibility[r][c] < access) {
          access = accessibility[r][c];
          move = i;
        }
      }
    }

    if (move != -1) {
      reduceAccess();
      currentRow += HORIZONTAL[move];
      currentCol += VERTICAL[move];
      return true;
    } else {
      return false;
    }
  }

  /**
   * Determine if the given position is a legal move on the board. The position
   * must be on the board and not have been used yet.
   * 
   * @param row
   *          - the row of the position to test
   * @param col
   *          - the column of the position to test
   * @return true if the move is legal, false otherwise
   */
  private static boolean legalMove(final int row, final int col) {
    if (onBoard(row, col) && board[row][col] == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Check that the given position is on the board. This is to avoid repeating
   * the code in different methods.
   * 
   * @param row
   *          - the given row
   * @param col
   *          - the given column
   * @return true if the position is on the board, false otherwise.
   */
  private static boolean onBoard(final int row, final int col) {
    return (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS);
  }

  /**
   * Lower the accessibility number of every position accessible from the
   * current position. This must be called just before the knight is moved to
   * the next position.
   */
  private static void reduceAccess() {
    for (int i = 0; i < MOVES; ++i) {
      int r = currentRow + HORIZONTAL[i];
      int c = currentCol + VERTICAL[i];
      if (onBoard(r, c) && accessibility[r][c] > 0) {
        --accessibility[r][c];
      }
    }

  }

  /**
   * Test the final position against the start position to see if this was a
   * closed tour. This makes no attempt to check if it was a full tour which is
   * why the method is private. Also the start position must be passed in since
   * we do not keep track of it.
   * 
   * @param beginRow
   *          - the start row
   * @param beginCol
   *          - the start column
   * @return true if the tour was closed, false otherwise
   */
  private static boolean closedTour(final int beginRow, final int beginCol) {
    for (int i = 0; i < MOVES; ++i) {
      if (currentRow + HORIZONTAL[i] == beginRow && currentCol + VERTICAL[i] == beginCol) {
        return true;
      }
    }
    return false;
  }

  /**
   * Display the board to the console. (0, 0) is the top left.
   */
  public static void printBoard() {
    for (int i = 0; i < ROWS; ++i) {
      for (int j = 0; j < COLUMNS; ++j) {
        System.out.printf("%2d ", board[i][j]);
      }
      System.out.println();
    }
  }
  
  private static void initialize() {
    accessibility = new int[ROWS][COLUMNS];
    for (int i = 0; i < ROWS; ++i) {
      System.arraycopy(INITIAL_ACCESSIBILITY[i], 0, accessibility[i], 0, COLUMNS);
    }
    for (int i = 0; i < ROWS; ++i) {
      for (int j = 0; j < COLUMNS; ++j) {
        board[i][j] = 0;
      }
    }
  }

  /**
   * Run the ten possible tours for this algorithm and display the board.
   * 
   * @param args
   *          - any arguments are ignored
   */
  public static void main(String[] args) {
    for (int row = 0; row < ROWS / 2; ++row) {
      for (int col = (ROWS / 2 - 1); col >= row; --col) {
        initialize();
        currentRow = row;
        currentCol = col;
        moves = play();
        if (moves == 64) {
          if (closedTour(row, col)) {
            System.out.println("Closed Tour!");
          } else {
            System.out.println("Full Tour!");
          }
        }
        printBoard();
        System.out.println();
      }
    }
  }

}
