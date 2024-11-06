public class CommandParser {
    public static void parse(String command, GameState state) {
        String[] parts = command.split(" ");
        String action = parts[0];

        if (action.equals("go")) {
            if (parts.length < 2) {
                System.out.println("Go where?");
            } else {
                String direction = parts[1];
                Room newRoom = state.getCurrentRoom().go(direction);
                if (newRoom != null) {
                    state.setCurrentRoom(newRoom);
                    newRoom.lookAround();
                }
            }
        } else {
            System.out.println("Unknown command");
        }
    }

    public static void printHelpMessage() {
        System.out.println("Available commands:");
        System.out.println("- go [direction]");
    }
}