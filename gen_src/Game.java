//Here is the revised code with only class and method signatures:

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    private static GameState state;
    private static Scanner playerInput = new Scanner(System.in);
    private static final String PROMPT = ">> ";

    public static void main(String[] args) {
        generateSpaceshipLayout("Rooms.txt");
        printWelcomeMessage();

        while (state.getObjectiveAmount() > state.getCompletedObjectives() && !state.isFailed()) {
            String command = getCommand();
            CommandParser.parse(command, state);
        }

        if (state.isFailed()) {
            printFailedMessage();
        } else {
            printWinMessage();
        }
    }

    private static String getCommand() {
        System.out.print(PROMPT);
        String command = playerInput.nextLine();
        command = command.replaceFirst(PROMPT, "");
        return command;
    }

    private static void printWelcomeMessage() {
    System.out.println("You wake up on a spaceship, drifting out in cold dark space. The ship is broken and you need to repair it.");
    System.out.println("Look around in the ship for repairtools and try to fix the ship");
    System.out.println();
    state.getCurrentRoom().look();
    CommandParser.printHelpMessage();
    }

    private static void printFailedMessage () {
        System.out.println("You used your " + state.getHoldingRepairTool().getName() + " on the "
        + state.getCurrentRoom().getObjective().getName() + " but something went wrong.");
        System.out.println("The ship has exploded, and no one will ever find the remains.");
        System.out.println("Gone, like tears in the rain.");
    }

    private static void printWinMessage() {
        System.out.println("You have successfully repaired the ship!");
    }

    private static void generateSpaceshipLayout(String filename) {
        Map<String, Room> spaceshipMap = new HashMap<>();
        state = new GameState(spaceshipMap.get(null));
        BufferedReader file = null;

        try {
            file = new BufferedReader(new FileReader(filename));

            String line = file.readLine();
            if (line == null) {
                System.out.println("Line is null");
            }

            while (line != null) {
                String[] fileWords = line.split(";");
                switch (fileWords[0]) {
                    case "Room":
                        String name = fileWords[1];
                        String description = fileWords[2];

                        Room newRoom = new Room(description);
                        spaceshipMap.put(name, newRoom);

                        line = file.readLine();
                        break;
                    case "Exit":
                        String room = fileWords[1];
                        String direction = fileWords[2];
                        String toRoom = fileWords[3];

                        spaceshipMap.get(room).addExit(direction, spaceshipMap.get(toRoom));

                        line = file.readLine();

                        break;
                    case "RepairTool":
                        room = fileWords[1];
                        name = fileWords[2];
                        String functionality = fileWords[3];

                        RepairTool repairTool = new RepairTool(name, functionality);
                        spaceshipMap.get(room).addRepairTool(repairTool);

                        line = file.readLine();
                        break;
                    case "Objective":
                        room = fileWords[1];
                        name = fileWords[2];
                        description = fileWords[3];

                        Objective objective = new Objective(name, description);
                        spaceshipMap.get(room).addObjective(objective);
                        state.addObjectiveAmount();

                        line = file.readLine();
                        break;
                    default:
                        break;

                }
            }
            file.close();

            state.setCurrentRoom(spaceshipMap.get("Quarters"));


        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            // Exit the program
            System.exit(1);
    }
}
}

// This format maintains the structure with the class and method signatures for
// educational references.