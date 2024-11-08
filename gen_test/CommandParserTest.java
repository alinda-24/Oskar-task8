package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommandParserTest {
    private CommandParser parser;
    private GameState state;
    private Room startRoom, northRoom;

    @Before
    public void setUp() {
        startRoom = new Room("You are in the starting room.");
        northRoom = new Room("You are in the north room.");
        startRoom.addExit("north", northRoom);
        state = new GameState(startRoom);
    }

    @Test
    public void testParseGoCommandValid() {
        CommandParser.parse("go north", state);
        assertEquals(northRoom, state.getCurrentRoom());
    }

    @Test
    public void testParseUnknownCommand() {
        CommandParser.parse("yell", state);
        // Expected to not change the current room
        assertEquals(startRoom, state.getCurrentRoom());
    }

    @Test
    public void testParseHelpCommand() {
        // Just check if help command processes without errors
        CommandParser.parse("help", state);
    }
}
```

RoomTest.java
```
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

