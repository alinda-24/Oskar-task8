package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlanetTest {

    @Test
    public void testPlanetCreationAndConnections() {
        Planet mars = new Planet("Mars", "Red Planet");
        Planet earth = new Planet("Earth", "Blue Planet");

        mars.addConnection(earth, "space route");

        // This assumes there's a connection check method in the Planet class
        assertTrue(mars.connections.containsKey("space route"));

        // Testing describe method for veracity
        mars.describe(); // Should print description and connection properly
    }
}