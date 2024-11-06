import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Planet {
    private String name;
    private String description;
    private Map<String, Planet> connections = new HashMap<>();

    public Planet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addConnection(Planet planet, String type) {
        connections.put(type, planet);
    }

    public void describe() {
        System.out.println("Planet: " + name);
        System.out.println("Description: " + description);
        System.out.println("Connections:");
        for (Map.Entry<String, Planet> entry : connections.entrySet()) {
            System.out.println(" - " + entry.getKey() + " to " + entry.getValue().name);
        }
    }
}