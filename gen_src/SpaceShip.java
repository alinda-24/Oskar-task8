// SpaceShip.java

import java.util.List;
import java.util.ArrayList;

public class SpaceShip {
    private String name;
    private List<Alien> passengers;

    public SpaceShip(String name) {
        // constructor
    }

    public String getName() {
        // method to get spaceship name
    }

    public void boardAlien(Alien alien) {
        // method to board an alien
    }

    public void listPassengers() {
        // method to list passengers
    }

    public static void main(String[] args) {
        // main method
    }
}


// Alien.java

public class Alien {
    private String species;
    private String ability;
    private String origin;

    public Alien(String species, String ability, String origin) {
        // constructor
    }

    public String getSpecies() {
        // method to get alien species
    }

    public String getAbility() {
        // method to get alien ability
    }

    public String getOrigin() {
        // method to get alien origin
    }

    @Override
    public String toString() {
        // override toString method
    }
}