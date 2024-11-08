public class Room {
    private Map<String, Room> exits;
    private String description;

    public Room(String description) {}

    public void addExit(String direction, Room toRoom) {}

    public Room go(String direction) {
        return null;
    }

    public void printExits() {}

    public void lookAround() {}
}