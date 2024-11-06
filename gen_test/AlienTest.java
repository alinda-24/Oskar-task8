package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlienTest {

    @Test
    public void testAlienCreation() {
        Alien alien = new Alien("Xenomorph", "Acid Blood", "LV-426");
        assertEquals("Xenomorph", alien.getSpecies());
        assertEquals("Acid Blood", alien.getPower());
        assertEquals("LV-426", alien.getHomePlanet());
    }

    @Test
    public void testToString() {
        Alien alien = new Alien("Yautja", "Camouflage", "Yautja Prime");
        String expected = "Alien{" + "species='Yautja', power='Camouflage', homePlanet='Yautja Prime'}";
        assertEquals(expected, alien.toString());
    }

    @Test
    public void testReadAliensFromFileValidData() throws IOException {
        File tempFile = File.createTempFile("aliens", ".csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("species,power,homePlanet\n");
            writer.write("Klingon,Strength,Qo'noS\n");
            writer.write("Vulcan,Logic,Vulcan\n");
        }
        List<Alien> aliens = Alien.readAliensFromFile(tempFile.getAbsolutePath());
        assertEquals(2, aliens.size());
        assertEquals("Klingon", aliens.get(0).getSpecies());
        assertEquals("Vulcan", aliens.get(1).getSpecies());
    }

    @Test
    public void testReadAliensFromFileInvalidLine() throws IOException {
        File tempFile = File.createTempFile("aliens_invalid", ".csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("species,power,homePlanet\n");
            writer.write("Klingon,Strength\n"); // Invalid line, missing data
        }
        List<Alien> aliens = Alien.readAliensFromFile(tempFile.getAbsolutePath());
        assertEquals(0, aliens.size()); // No valid alien should be added
    }

    @Test
    public void testReadAliensFromFileNonExistent() {
        List<Alien> aliens = Alien.readAliensFromFile("non_existent_file.csv");
        assertTrue(aliens.isEmpty()); // Should handle and return empty list
    }
}

// UniverseTest.java
import org.junit.Test;
import java.io.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

