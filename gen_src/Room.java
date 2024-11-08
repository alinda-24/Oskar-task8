
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
        this.repairTool = null;
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

    public RepairTool getRepairTool() {
        return repairTool;
    }

    public void addObjective(Objective objective) {
        this.objective = objective;
    }

    public Objective getObjective() {
        return objective;
    }

    public Room enterRoom(String direction) {
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
        }
        System.out.println();
    }

    public void printRepairTools() {
        if (repairTool == null) {
            System.out.println("You search the room but don't see any useful items");

        } else {
            System.out.println("You look around in the room and see a " + repairTool.getName() + ".");
        }

    }

    public void printObjectives() {
        if (objective == null) {
            System.out.println("Nothing in this room seems to be in need of repair.");
        } else {
            System.out.println("You see a " + objective.getName() + ". It seems to be broken. " + objective.getDescription());
        }
    }

    public void look() {
        System.out.println(description);
        printRepairTools();
        printObjectives();
        printExits();
    }
}