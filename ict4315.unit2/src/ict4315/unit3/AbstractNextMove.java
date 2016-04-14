package ict4315.unit3;

public abstract class AbstractNextMove {
    Knight myKnight = new Knight();
    static final int ROWS = 8;
    static final int COLUMNS = 8;
    private int currentCol = 0;
    private int currentRow = 0;
    public void setCurrentCol(int col) {
        currentCol = col;
    }
    public void setCurrentRow(int row){
        currentRow = row;
    }
    public boolean onBoard(final int row, final int col) {
        return (row >= 0 && col >= 0 && row < ROWS && col < COLUMNS);
    }
    boolean closedTour(int beginRow, int beginCol) {
        for (int i = 0; i < myKnight.getMoves(); ++i) {
            if (currentRow + myKnight.getHorizontal(i) == beginRow && currentCol + myKnight.getVertical(i) == beginCol) {
                return true;
            }
        }
        return false;
    }
    abstract boolean legalMove(int r, int c);
}
