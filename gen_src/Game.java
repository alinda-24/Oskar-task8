// Game.java
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
        // method to get user command
        return null;
    }

    private static void printWelcomeMessage() {
        // method to print welcome message
    }
    
    private static void generateRoomsFromFile(String filename) {
        // method to generate rooms from a file
    }
}

// CommandParser.java
public class CommandParser {
    public static void parse(String command, GameState state) {
        // method to parse commands
    }

    public static void printHelpMessage() {
        // method to print help message
    }
}

// Room.java
import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        // constructor
    }

    public void addExit(String direction, Room neighbor) {
        // method to add an exit
    }

    public void lookAround() {
        // method to look around the room
    }
}

// GameState.java
public class GameState {
    private Room currentRoom;

    public GameState(Room startingRoom) {
        // constructor
    }

    public Room getCurrentRoom() {
        // method to get current room
        return null;
    }
}