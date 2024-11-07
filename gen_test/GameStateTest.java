package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStateTest {
    private Room startRoom;
    private Room otherRoom;
    private GameState gameState;

    @Before
    public void setup() {
        startRoom = new Room("Starting Room");
        otherRoom = new Room("Other Room");
        gameState = new GameState(startRoom);
    }

    @Test
    public void testInitialRoom() {
        assertEquals(startRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testSetCurrentRoom() {
        gameState.setCurrentRoom(otherRoom);
        assertEquals(otherRoom, gameState.getCurrentRoom());
    }
}

import org.junit.Test;

import static org.junit.Assert.*;

