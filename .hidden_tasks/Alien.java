import java.util.List;
import java.util.ArrayList;

public class Alien {
    private String species;
    private String power;
    private String homePlanet;

    public Alien(String species, String power, String homePlanet) {
        this.species = species;
        this.power = power;
        this.homePlanet = homePlanet;
    }

    public String getSpecies() {
        return species;
    }

    public String getPower() {
        return power;
    }

    public String getHomePlanet() {
        return homePlanet;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "species='" + species + '\'' +
                ", power='" + power + '\'' +
                ", homePlanet='" + homePlanet + '\'' +
                '}';
    }

    public static List<Alien> readAliensFromFile(String filePath) {
        List<Alien> aliens = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    aliens.add(new Alien(data[0], data[1], data[2]));
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading alien data from file: " + e.getMessage());
        }
        return aliens;
    }

    public static void main(String[] args) {
        List<Alien> aliens = Alien.readAliensFromFile("aliens.csv");
        for (Alien alien : aliens) {
            System.out.println(alien);
        }
    }
}