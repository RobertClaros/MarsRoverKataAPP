import java.util.Random;
import java.util.Scanner;

public class MarsRoverProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el tamaño del tablero en x = ");
        int maxX = scanner.nextInt();
        System.out.print("Introduzca el tamaño del tablero en y = ");
        int maxY = scanner.nextInt();

        Rover rover = new Rover(maxX, maxY);
        RoverService roverService = new RoverService(rover);

        initializeObstacles(roverService, rover);
        String commands = getValidCommands(scanner);
        System.out.println("Comandos de movimiento ingresados: "+commands );

        String result = roverService.executeCommands(commands);
        System.out.println("-----------------------------");
        System.out.println("Posición final del Rover");
        System.out.println(result);
    }

    private static void initializeObstacles(RoverService roverService, Rover rover) {
        Random random = new Random();
        roverService.addObstacle(new Obstacle(random.nextInt(rover.getMaxX()), random.nextInt(rover.getMaxY())));
        roverService.addObstacle(new Obstacle(random.nextInt(rover.getMaxX()), random.nextInt(rover.getMaxY())));
        System.out.println("Posición de los obstáculos:");
        for (Obstacle obstacle : roverService.getObstacles()) {
            System.out.println("X: " + obstacle.getX() + ", Y: " + obstacle.getY());
        }
    }


    private static String getValidCommands(Scanner scanner) {
        String commands;

        do {
            System.out.println("Introduzca los comandos de movimiento del Rover");
            System.out.println("Para mover hacia adelante f");
            System.out.println("Para mover hacia atrás b");
            System.out.println("Para mover hacia la izquierda l");
            System.out.println("Para mover hacia la derecha r");
            commands = scanner.next();

            if (!commands.matches("[fblr]+")) {
                System.out.println("Comandos ingresados incorrectos, intente nuevamente");
            }
        } while (!commands.matches("[fblr]+"));

        return commands;
    }


}

