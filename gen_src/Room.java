public class Room {

    private Map<String, Room> exits = new HashMap<>();
    private String description;

    public Room(String description) {
        // Constructor implementation
    }

    public void addExit(String direction, Room toRoom) {
        // Method implementation
    }

    public Room go(String direction) {
        // Method implementation
        return null;
    }

    public void printExits() {
        // Method implementation
    }

    public void lookAround() {
        // Method implementation
    }
}