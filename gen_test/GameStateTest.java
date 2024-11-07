package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStateTest {
    private Room room1;
    private Room room2;
    private GameState gameState;
    
    @Before
    public void setup() {
        room1 = new Room("Starting Room");
        room2 = new Room("Second Room");
        gameState = new GameState(room1);
    }
    
    @Test
    public void testGetCurrentRoom() {
        assertEquals(room1, gameState.getCurrentRoom());
    }
    
    @Test
    public void testSetCurrentRoom() {
        gameState.setCurrentRoom(room2);
        assertEquals(room2, gameState.getCurrentRoom());
    }
    
    @Test
    public void testRoomTransitions() {
        room1.addExit("north", room2);
        gameState.setCurrentRoom(room1);
        Room newRoom = gameState.getCurrentRoom().go("north");
        assertEquals(room2, newRoom);
        assertEquals(room2, gameState.getCurrentRoom()); // GameState should update as well
    }
}

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

