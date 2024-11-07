public class CommandParser {

    public static void parse(String command, GameState state) {
        if (command.isEmpty()) {
            System.out.println("Please enter a command.");
            return;
        }

        String[] commandParts = command.split(" ");
        switch (commandParts[0].toLowerCase()) {
            case "go":
                if (commandParts.length < 2) {
                    System.out.println("Go where?");
                } else {
                    Room newRoom = state.getCurrentRoom().go(commandParts[1]);
                    if (newRoom != null) {
                        state.setCurrentRoom(newRoom);
                        newRoom.lookAround();
                    }
                }
                break;

            case "look":
                state.getCurrentRoom().lookAround();
                break;

            case "help":
                printHelpMessage();
                break;

            case "quit":
                System.out.println("Thank you for playing!");
                System.exit(0);
                break;

            default:
                System.out.println("I don't understand the command: " + command);
        }
    }

    public static void printHelpMessage() {
        System.out.println("Available commands:");
        System.out.println("- go [direction]: Move to the room in the specified direction.");
        System.out.println("- look: Repeat the description of your current location.");
        System.out.println("- help: Show this help message.");
        System.out.println("- quit: Exit the game.");
    }
}