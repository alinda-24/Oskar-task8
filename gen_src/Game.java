// Game.java
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private static GameState state;
    private static Scanner scanner = new Scanner(System.in);
    private static final String PROMPT = "> ";

    public static void main(String[] args) {
        generateRoomsFromFile("spaceship_layout.txt");
        printWelcomeMessage();
        while (true) {
            String command = getCommand();
            CommandParser.parse(command, state);
        }
    }

    private static String getCommand() {
        return null;
    }

    private static void printWelcomeMessage() {

    }

    private static void generateRoomsFromFile(String filename) {

    }
}

// GameState.java (Assuming a separate file for GameState class is needed)
public class GameState {
    public GameState(Room startRoom) {

    }

    public Room getCurrentRoom() {
        return null;
    }
}

// Room.java (Assuming a separate file for Room class is needed)
public class Room {
    public Room(String description) {

    }

    public void lookAround() {

    }

    public void addExit(String direction, Room room) {

    }
}

// CommandParser.java (Assuming a separate file for CommandParser class is needed)
public class CommandParser {
    public static void parse(String command, GameState state) {

    }

    public static void printHelpMessage() {
        
    }
}