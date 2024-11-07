package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {
    private Room room;
    private Room northRoom;
    
    @Before
    public void setup() {
        room = new Room("Main Room");
        northRoom = new Room("North Room");
        room.addExit("north", northRoom);
    }
    
    @Test
    public void testAddExitAndGo() {
        Room roomSouth = new Room("South Room");
        room.addExit("south", roomSouth);
        
        assertEquals(northRoom, room.go("north"));
        assertEquals(roomSouth, room.go("south"));
        assertNull(room.go("east")); // No exit in this direction
    }
    
    @Test
    public void testGoInvalidDirection() {
        assertNull(room.go("west"));
        room.printExits();
    }
    
    @Test
    public void testDescription() {
        assertEquals("Main Room", room.getDescription());
        room.lookAround();
    }
}