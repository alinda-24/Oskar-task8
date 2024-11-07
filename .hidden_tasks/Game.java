import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private static GameState state;
    private static Scanner scanner = new Scanner(System.in);
    private static final String PROMPT = "> ";

    public static void main(String[] args) {
        generateRoomsFromFile("spaceship_layout.txt");
        printWelcomeMessage();

        while (true) {
            String command = getCommand();
            CommandParser.parse(command, state);
        }
    }

    private static String getCommand() {
        System.out.print(PROMPT);
        String command = scanner.nextLine();
        return command.replaceFirst(PROMPT, "");
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to the Sci-fi Spaceship Repair Game!");
        state.getCurrentRoom().lookAround();
        CommandParser.printHelpMessage();
    }
    
    private static void generateRoomsFromFile(String filename) {
        HashMap<String, Room> worldModel = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(";");
                if (data[0].equals("Room")) {
                    worldModel.put(data[1], new Room(data[2]));
                } else if (data[0].equals("Exit")) {
                    worldModel.get(data[1]).addExit(data[2], worldModel.get(data[3]));
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error generating rooms from file: " + e.getMessage());
            System.exit(1);
        }
        
        state = new GameState(worldModel.get("StartRoom"));
    }
}