public class CommandParser {

    public static void parse(String command, GameState state) {
        String[] splitCommand = command.trim().toLowerCase().split("\\s+");

        if (splitCommand.length < 1) {
            printInvalidCommandMessage();
            return;
        }

        switch (splitCommand[0]) {
            case "go" -> executeGoCommand(splitCommand, state);
            case "look" -> executeLookCommand(state);
            case "use" -> executeUseCommand(state);
            case "fetch" -> executeFetchCommand(state);
            case "help" -> printHelpMessage();
            case "inventory" -> executeInventoryCommand(state);
            default -> printInvalidCommandMessage();
        }
    }

    public static void printHelpMessage() {
        System.out.println("These are the available commands:");
        System.out.println("\"    \\\"go <direction>\\\" Go in the chosen direction");
        System.out.println("\"    \\\"look\\\" Look around the room");
        System.out.println("\"    \\\"use\\\" Try to use the current item youre holding");
        System.out.println("\"    \\\"fetch\\\" Pick up any available item in the room");
        System.out.println("\"    \\\"inventory\\\" Shows what you are holding in your hands.");
        System.out.println("\"    \\\"help\\\" HELP!!!");
    }

    public static void printInvalidCommandMessage() {
        System.out.println("That is an invalid command.");
    }

    public static void executeLookCommand(GameState state) {
        state.getCurrentRoom().look();
    }

    public static void executeGoCommand(String[] splitcommand, GameState state) {
        if (splitcommand.length < 2) {
            printInvalidCommandMessage();
        } else {
            Room currentRoom = state.getCurrentRoom();
            Room newRoom = currentRoom.enterRoom(splitcommand[1]);

            if (newRoom != null) {
                state.setCurrentRoom(newRoom);
                newRoom.look();
            }
        }
    }

    public static void executeFetchCommand(GameState state) {
        if (state.getHoldingRepairTool() == null) {
            if (state.getCurrentRoom().getRepairTool() != null) {
                state.setHoldingRepairTool(state.getCurrentRoom().getRepairTool());
                state.getCurrentRoom().removeRepairTool();
                System.out.println("You have picked up a " + state.getHoldingRepairTool().getName() + "!");
            } else {
                printNoAvailableItems();
            }
        } else {
            
            System.out.println("Your hands are full! You are already holding an item:");
            System.out.println(state.getHoldingRepairTool().getName());
        }

    }

    public static void printNoAvailableItems() {
        System.out.println("There are no available items in this room.");
        System.out.println("Try looking somewhere else.");
    }

    public static void executeInventoryCommand(GameState state) {
        System.out.println("You look in your hands and see a " + state.getHoldingRepairTool().getName() + ".");
    }

    public static void executeUseCommand(GameState state) {
        String currentItemFunction = state.getHoldingRepairTool().getFunctionality();
        String currentRoomObjective = state.getCurrentRoom().getObjective().getName();

        if (state.getHoldingRepairTool() == null) {
            System.out.println("You do not have any repairtools for this action");
        } else if (!state.getCurrentRoom().getObjective().isCompleted()) {
            if (currentItemFunction.equals(currentRoomObjective)) {
                System.out.println("You have used your " + state.getHoldingRepairTool().getName() + " to repair the "
                        + currentRoomObjective + "!");
                state.getCurrentRoom().getObjective().setCompleted(true);
                state.addCompletedObjectives();
                state.dropHoldingRepairTool();
            } else {
                state.setFailed(true);
            }
        } else {
            System.out.println("The " + currentRoomObjective + " is already fixed.");
            System.out.println("See if there is something else you can do.");
        }

    }
}