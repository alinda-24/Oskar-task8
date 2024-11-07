// Game.java

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private static GameState state;
    private static Scanner scanner = new Scanner(System.in);

    private static final String PROMPT = "> ";

    public static void main(String[] args) {
        generateRoomsFromFile();
        printWelcomeMessage();

        while (true) {
            String command = getCommand();
            CommandParser.parse(command, state);
        }
    }

    private static String getCommand() {
        System.out.print(PROMPT);
        return scanner.nextLine().replaceFirst(PROMPT, "");
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to The Colossal Adventure, the exciting new text-based adventure game.");
        state.getCurrentRoom().lookAround();
        CommandParser.printHelpMessage();
    }

    private static void generateRoomsFromFile() {
        HashMap<String, Room> worldModel = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("rooms.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                if ("Room".equals(data[0]))
                    worldModel.put(data[1], new Room(data[2]));
                else if ("Exit".equals(data[0]))
                    worldModel.get(data[1]).addExit(data[2], worldModel.get(data[3]));
            }
        } catch (IOException e) {
            System.err.println("Error generating rooms from file: " + e.getMessage());
            System.exit(1);
        }

        state = new GameState(worldModel.get("start"));
    }
}