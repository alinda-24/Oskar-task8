// Room.java

import java.util.Map;
import java.util.HashMap;

public class Room {
    private Map<String, Room> exits;
    private String description;

    public Room(String description) {
        // Constructor
    }

    public void addExit(String direction, Room toRoom) {
        // Add an exit
    }

    public Room go(String direction) {
        // Return the room in the given direction
        return null;
    }

    public void printExits() {
        // Print available exits
    }

    public void lookAround() {
        // Describe the current room and its exits
    }
}