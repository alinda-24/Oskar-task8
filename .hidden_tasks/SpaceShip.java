import java.util.List;
import java.util.ArrayList;

public class SpaceShip {
    private String name;
    private List<Alien> passengers;

    public SpaceShip(String name) {
        this.name = name;
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void boardAlien(Alien alien) {
        passengers.add(alien);
        System.out.println(alien.getSpecies() + " boards the " + name);
    }

    public void listPassengers() {
        System.out.println("Passengers aboard " + name + ":");
        for (Alien alien : passengers) {
            System.out.println("- " + alien);
        }
    }

    public static void main(String[] args) {
        SpaceShip ship = new SpaceShip("Galactic Explorer");
        Alien alien1 = new Alien("Zorgon", "Telepathy", "Zeta-9");
        Alien alien2 = new Alien("Tralvok", "Invisibility", "Nebula-3");

        ship.boardAlien(alien1);
        ship.boardAlien(alien2);
        ship.listPassengers();
    }
}