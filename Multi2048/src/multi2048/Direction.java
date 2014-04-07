package multi2048;

/**
 *
 * @author ingmar
 */
public enum Direction {
    
    UP
    ,DOWN
    ,LEFT
    ,RIGHT;
    
    public int getSquare(int source){
        switch(this){
            case UP:
                return Board.SIZE*(source % Board.SIZE) + (source / Board.SIZE);
            case DOWN:
                return Board.SIZE*(Board.SIZE -1- source % Board.SIZE) + (source / Board.SIZE);
            case LEFT:
                return source;
            case RIGHT:
                return Board.SIZE*(source/Board.SIZE) + (Board.SIZE - 1 - source % Board.SIZE);
        }
        throw new IllegalArgumentException("Something terrible went wrong");
    }

}
