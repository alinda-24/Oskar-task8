//Here is the revised code with only class and method signatures:

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    private static GameState state;
    private static Scanner playerInput = new Scanner(System.in);
    private static final String PROMPT = "> ";

    public static void main(String[] args) {
        generateSpaceshipLayout("Rooms.txt");
        printWelcomeMessage();

        while (state.getObjectiveAmount() > state.getCompletedObjectives()) {
            String command = getCommand();
            CommandParser.parse(command, state);
        }
    }

    private static String getCommand() {
        System.out.print(PROMPT);
        String command = playerInput.nextLine();
        command = command.replaceFirst(PROMPT, "");
        return command;
    }

    private static void printWelcomeMessage() {
    }

    private static void generateSpaceshipLayout(String filename) {
        Map<String, Room> spaceshipMap = new HashMap<>();
        BufferedReader file = null;
        state = new GameState(spaceshipMap.get(null));

        try {
            file = new BufferedReader(new FileReader(filename));
            
            String line = file.readLine();
            if (line == null) {
                System.out.println("Line is null");
            }
            

            while (line != null) {
            switch (line) {
                case "Room":
                    String name = file.readLine();
                    String description = file.readLine();

                    Room newRoom = new Room(description);
                    spaceshipMap.put(name, newRoom);   
                
                    line = file.readLine();
                break;
                case "Exit":
                    String room = file.readLine();
                    String direction = file.readLine();
                    String toRoom = file.readLine();
                    
                    spaceshipMap.get(room).addExit(direction, spaceshipMap.get(toRoom));
                    
                    line = file.readLine();
                
                break;
                case "RepairTool":
                    room = file.readLine();
                    name = file.readLine();
                    String functionality = file.readLine();

                    RepairTool repairTool = new RepairTool(name, functionality);
                    spaceshipMap.get(room).addRepairTool(repairTool);

                    line = file.readLine();
                break;
                case "Objective":
                    room = file.readLine();
                    name = file.readLine();

                    Objective objective = new Objective(name);
                    spaceshipMap.get(room).addObjective(objective);
                    state.addObjectiveAmount();
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