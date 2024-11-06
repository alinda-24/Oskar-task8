package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UniverseTest {

    @Test
    public void testGenerateUniverseFromFile() throws IOException {
        File tempFile = File.createTempFile("universe", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("Planet;Earth;Our home planet\n");
            writer.write("Planet;Mars;The red planet\n");
            writer.write("Connection;Earth;Mars;galactic highway\n");
        }
        Universe universe = new Universe();
        universe.generateUniverseFromFile(tempFile.getAbsolutePath());

        // Verify the planet connections and descriptions
        // This assumes the toString or a similar method properly outputs planet info
        System.out.println("Expected planet connections and descriptions should be logged.");
    }

    @Test
    public void testGenerateUniverseFromFileWithInvalidData() throws IOException {
        File tempFile = File.createTempFile("universe_invalid", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("Planet;Earth;Our home planet\n");
            writer.write("Invalid;Data\n"); // Invalid line format
        }
        Universe universe = new Universe();
        universe.generateUniverseFromFile(tempFile.getAbsolutePath());

        // Expect universe to still have Earth, but not the invalid entry
        System.out.println("Expected planet info (like Earth) should be logged without error from invalid data.");
    }
}

// SpaceShipTest.java
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

