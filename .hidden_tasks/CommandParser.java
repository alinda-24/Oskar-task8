public class CommandParser {
    public static void parse(String command, GameState state) {
        String[] words = command.split(" ");
        if (words[0].equalsIgnoreCase("go")) {
            if (words.length < 2) {
                System.out.println("Please specify a direction to go.");
                return;
            }
            Room newRoom = state.getCurrentRoom().go(words[1]);
            if (newRoom != null) {
                state.setCurrentRoom(newRoom);
                newRoom.lookAround();
            }
        } else if (words[0].equalsIgnoreCase("help")) {
            printHelpMessage();
        } else {
            System.out.println("Unknown command. Type 'help' for a list of commands.");
        }
    }

    public static void printHelpMessage() {
        System.out.println("Available commands:");
        System.out.println("- go [direction]: Move to a room in the specified direction.");
        System.out.println("- help: Show this help message.");
    }
}