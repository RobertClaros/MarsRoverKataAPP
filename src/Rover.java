
public class Rover {
    private Direction direction;
    private int x;
    private int y;
    private final int maxX;
    private final int maxY;


    public Rover(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.direction = Direction.NORTH;
        this.x = 0;
        this.y = 0;
    }
    public Direction getDirection() {
        return direction;
    }

    public int getMaxX() {
        return maxX;
    }
    public int getMaxY() {
        return maxY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }




}
