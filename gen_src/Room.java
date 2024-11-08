// Room.java
import java.util.Map;
import java.util.HashMap;

public class Room {
    private Map<String, Room> exits = new HashMap<>();
    private String description;

    public Room(String description) {
        // Constructor code
    }

    public void addExit(String direction, Room toRoom) {
        // Method to add an exit
    }

    public Room go(String direction) {
        // Method to go in a direction
        return null;
    }

    public void printExits() {
        // Method to print available exits
    }

    public void lookAround() {
        // Method to look around the room
    }
}