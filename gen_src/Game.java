// File: Game.java
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
        // Implementation detail removed
    }

    private static void printWelcomeMessage() {
        // Implementation detail removed
    }

    private static void generateRoomsFromFile() {
        // Implementation detail removed
    }
}

// Note: While CommandParser, GameState, Room, and other classes/interfaces are referred to,
// they are not declared here. Additional classes should be defined appropriately in their
// respective files if this was a larger program.