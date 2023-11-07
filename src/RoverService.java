import java.util.ArrayList;
import java.util.List;

public class RoverService {
    private Rover rover;
    private Direction direction;
    private List<Obstacle> obstacleList = new ArrayList<>();

    public RoverService(Rover rover) {
        this.rover = rover;
        this.direction = rover.getDirection();
    }

    public String executeCommands(String commands) {
        StringBuilder result = new StringBuilder();
        for (char command : commands.toCharArray()) {
            if (command == 'f') {
                moveForward();
            } else if (command == 'b') {
                moveBackward();
            } else if (command == 'l') {
                turnLeft();
            } else if (command == 'r') {
                turnRight();
            }

        }
        result.append("Position: ").append(rover.getX()).append(",").append(rover.getY()).append(" Direction: ").append(direction).append("\n");
        return result.toString();
    }


    private void moveForward() {
        int newX = rover.getX();
        int newY = rover.getY();
        switch (direction) {
            case NORTH:
                newY = (rover.getY() + 1) % (rover.getMaxY() + 1);
                break;
            case EAST:
                newX = (rover.getX() + 1) % (rover.getMaxX() + 1);
                break;
            case SOUTH:
                newY = (rover.getY() - 1 + rover.getMaxY() + 1) % (rover.getMaxY() + 1);
                break;
            case WEST:
                newX = (rover.getX() - 1 + rover.getMaxX() + 1) % (rover.getMaxX() + 1);
                break;
        }
        if (!isObstacle(newX, newY)) {
            rover.setX(newX);
            rover.setY(newY);
        }
    }

    private void moveBackward() {
        int newX = rover.getX();
        int newY = rover.getY();
        switch (direction) {
            case NORTH:
                newY = (rover.getY() - 1 + rover.getMaxY() + 1) % (rover.getMaxY() + 1);
                break;
            case EAST:
                newX = (rover.getX() - 1 + rover.getMaxX() + 1) % (rover.getMaxX() + 1);
                break;
            case SOUTH:
                newY = (rover.getY() + 1) % (rover.getMaxY() + 1);
                break;
            case WEST:
                newX = (rover.getX() + 1) % (rover.getMaxY() + 1);
                break;
        }
        if (!isObstacle(newX, newY)) {
            rover.setX(newX);
            rover.setY(newY);
        }
    }


    private void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }



    public void addObstacle(Obstacle obstacle) {
        obstacleList.add(obstacle);
    }
    public List<Obstacle> getObstacles() {
        return obstacleList;
    }
    private boolean isObstacle(int x, int y) {
        for (Obstacle obstacle : obstacleList) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                return true;
            }
        }
        return false;
    }
}
