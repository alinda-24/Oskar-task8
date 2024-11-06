package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStateTest {

    private Room startRoom;
    private Room northRoom;

    @Before
    public void setup() {
        startRoom = new Room("Start Room");
        northRoom = new Room("North Room");
    }

    @Test
    public void testGetCurrentRoom() {
        GameState gameState = new GameState(startRoom);
        assertEquals(startRoom, gameState.getCurrentRoom());
    }

    @Test
    public void testSetCurrentRoom() {
        GameState gameState = new GameState(startRoom);
        gameState.setCurrentRoom(northRoom);
        assertEquals(northRoom, gameState.getCurrentRoom());
    }
}