package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {
    private Room room;

    @Before
    public void setUp() {
        room = new Room("Test room.");
    }

    @Test
    public void testAddExitAndGo() {
        Room nextRoom = new Room("You entered the next room.");
        room.addExit("east", nextRoom);
        assertEquals(nextRoom, room.go("east"));
    }

    @Test
    public void testGoNonExistentDirection() {
        assertNull(room.go("west"));
    }
}
```

Note: These tests assume the methods provided in your classes are public and accessible. For classes that expect user input, manual interaction or a mock framework would be necessary for full testing. Additionally, the setup and file paths should be adjusted to your development environment when running these tests locally.