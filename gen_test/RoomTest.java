package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {
    private Room room1 = new Room("Room 1");
    private Room room2 = new Room("Room 2");

    @Test
    public void testRoomDescription() {
        assertEquals("Room 1", room1.getDescription());
    }

    @Test
    public void testAddExit() {
        room1.addExit("north", room2);
        assertEquals(room2, room1.go("north"));
    }

    @Test
    public void testInvalidDirection() {
        assertNull(room1.go("south"));
    }
}

import org.junit.Test;

import static org.junit.Assert.*;

