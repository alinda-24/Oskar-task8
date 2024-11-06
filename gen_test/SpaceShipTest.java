package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpaceShipTest {

    @Test
    public void testSpaceShipCreationAndBoarding() {
        SpaceShip spaceShip = new SpaceShip("Black Pearl");
        Alien alien = new Alien("Kryptonian", "Flight", "Krypton");

        spaceShip.boardAlien(alien);

        // Test listPassengers method
        spaceShip.listPassengers();
        
        int aliensCount = (int) spaceShip.passengers.stream()
                            .filter(a -> a.getSpecies().equals("Kryptonian"))
                            .count();
        
        assertEquals(1, aliensCount);
    }
}

// PlanetTest.java
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

