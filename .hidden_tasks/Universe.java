import java.util.Map;
import java.util.HashMap;

public class Universe {
    private Map<String, Planet> planets = new HashMap<>();

    public void generateUniverseFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data[0].equals("Planet") && data.length == 3) {
                    planets.put(data[1], new Planet(data[1], data[2]));
                } else if (data[0].equals("Connection") && data.length == 4) {
                    Planet from = planets.get(data[1]);
                    Planet to = planets.get(data[2]);
                    if (from != null && to != null) {
                        from.addConnection(to, data[3]);
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error generating universe from file: " + e.getMessage());
        }
    }

    public void describeUniverse() {
        for (Planet planet : planets.values()) {
            planet.describe();
        }
    }

    public static void main(String[] args) {
        Universe universe = new Universe();
        universe.generateUniverseFromFile("universe.txt");
        universe.describeUniverse();
    }
}