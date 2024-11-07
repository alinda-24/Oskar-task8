// Room.java
import java.util.Map;
import java.util.HashMap;

public class Room {
    private Map<String, Room> exits = new HashMap<>();
    private String description;
    private RepairTool repairTool;
    private Objective objective;

    public Room(String description) {
     this.description = description;
    }

    public void addExit(String direction, Room toRoom) {
        exits.put(direction, toRoom);
    }

    public void addRepairTool(RepairTool repairTool) {
        this.repairTool = repairTool;
    }

    public void removeRepairTool() {
        this.repairTool = null;
    }

    public void addObjective(Objective objective) {
        this.objective = objective;
    }

    public Room go(String direction) {
        Room enterRoom = exits.get(direction);
        if (exits.get(direction) == null) {
            System.out.println("Try not to walk into the walls. You might break the ship... or yourself.");
            printExits();
        }
        return enterRoom;
    }

    public void printExits() {
        System.out.println("There are sliding spaceship doors in the directions: ");
        for (String direction : exits.keySet()) {
            System.out.println(direction);
            System.out.println();
        }
    }

    public void lookAround() {
        System.out.println(description);
        printExits();
    }
}