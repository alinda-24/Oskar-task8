package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    private GameState gameState;
    private Map<String, Room> worldModel;
    private Room startRoom;
    private Room northRoom;

    @Before
    public void setUp() {
        worldModel = new HashMap<>();
        startRoom = new Room("Start Room");
        northRoom = new Room("North Room");

        startRoom.addExit("north", northRoom);
        worldModel.put("start", startRoom);
        worldModel.put("north", northRoom);

        gameState = new GameState(startRoom);
    }

    @Test
    public void testInitialRoomSetup() {
        assertEquals(startRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testGoValidDirection() {
        CommandParser.parse("go north", gameState);
        assertEquals(northRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testGoInvalidDirection() {
        CommandParser.parse("go south", gameState);
        assertEquals(startRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testUnknownCommand() {
        CommandParser.parse("jump", gameState);
        // Check console output manually if needed
        assertEquals(startRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testEmptyCommand() {
        CommandParser.parse("", gameState);
        assertEquals(startRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testGoWithoutDirection() {
        CommandParser.parse("go", gameState);
        assertEquals(startRoom, gameState.getCurrentRoom());
    }
}

import org.junit.Test;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

