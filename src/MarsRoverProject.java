import java.util.Random;

public class MarsRoverProject {
    public static void main(String[] args) {
        Random random = new Random();
        Rover rover = new Rover(5, 5);

        rover.addObstacle(new Obstacle(random.nextInt(6), random.nextInt(6)));
        rover.addObstacle(new Obstacle(random.nextInt(6), random.nextInt(6)));
        System.out.println("Posición de los obstáculos:");
        for (Obstacle obstacle : rover.getObstacles()) {
            System.out.println("X: " + obstacle.getX() + ", Y: " + obstacle.getY());
        }

        String commands = "fff";
        System.out.println("Comandos de movimiento");
        System.out.println(commands);
        String result = rover.executeCommands(commands);
        System.out.println("-----------------------------");
        System.out.println("Posicion final del Rover");
        System.out.println(result);
    }
}
