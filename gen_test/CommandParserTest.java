package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommandParserTest {

    private GameState gameState;
    private Room startRoom;
    private Room northRoom;

    @Before
    public void setup() {
        startRoom = new Room("Start Room");
        northRoom = new Room("North Room");
        startRoom.addExit("north", northRoom);
        gameState = new GameState(startRoom);
    }

    @Test
    public void testParseGoWithValidDirection() {
        CommandParser.parse("go north", gameState);
        assertEquals(northRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testParseGoWithInvalidDirection() {
        CommandParser.parse("go east", gameState);
        assertEquals(startRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testParseUnknownCommand() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CommandParser.parse("jump", gameState);
        assertTrue(outputStream.toString().contains("Unknown command"));

        System.setOut(System.out);
    }
}


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

