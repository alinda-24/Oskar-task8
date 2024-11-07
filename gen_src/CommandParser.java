public class CommandParser {

    public static void parse(String command, GameState state) {
        String[] splitCommand = command.trim().toLowerCase().split("\\s+");
        
        if (splitCommand.length < 1) {
            printInvalidCommandMessage();
            return;
        }
    }

    public static void printHelpMessage() {
        // method signature with no implementation
    }

    public static void printInvalidCommandMessage() {

    }

    public static void executeLookCommand(){

    }

    public static void executeMoveCommand(String[] splitcommand, GameState state) {

    }

    public static void executePickUpCommand(String[] splitcommand, GameState state) {

    }

    public static void executeUseCommand(String[] splitcommand, GameState state) {
        
    }


}