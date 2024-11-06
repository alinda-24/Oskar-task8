package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {

    private Room room;
    private Room northRoom;

    @Before
    public void setup() {
        room = new Room("Test Room");
        northRoom = new Room("North Room");
        room.addExit("north", northRoom);
    }

    @Test
    public void testRoomDescription() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        room.lookAround();
        assertTrue(outputStream.toString().contains("Test Room"));

        System.setOut(System.out);
    }

    @Test
    public void testValidDirection() {
        Room result = room.go("north");
        assertEquals(northRoom, result);
    }

    @Test
    public void testInvalidDirection() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Room result = room.go("east");
        assertNull(result);
        assertTrue(outputStream.toString().contains("You can't go that way!"));

        System.setOut(System.out);
    }

    @Test
    public void testPrintExits() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        room.printExits();
        assertTrue(outputStream.toString().contains("north"));

        System.setOut(System.out);
    }
}

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

