package ict4315.unit2;
public class Knight {
    private int moves = 8;
    private int [] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private int [] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };
    public int getHorizontal(int i){
    int spot = horizontal[i];
        return spot;
    }
    public int getVertical(int i){
        int spot = vertical[i];
        return spot;
    }
    public int getMoves(){
        return moves;

    }

}
