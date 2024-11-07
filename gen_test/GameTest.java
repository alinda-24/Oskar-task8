package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    private GameState state;
    private Room room1;
    private Room room2;

    @Before
    public void setup() {
        room1 = new Room("Room 1 description");
        room2 = new Room("Room 2 description");
        room1.addExit("north", room2);

        state = new GameState(room1);
    }

    @Test
    public void testGoCommandMovesPlayerToTheCorrectRoom() {
        CommandParser.parse("go north", state);
        assertEquals(room2, state.getCurrentRoom());
    }

    @Test
    public void testGoCommandWithNoDirection() {
        PrintStream originalOut = System.out;
        PrintStream mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        CommandParser.parse("go", state);

        verify(mockOut).println("Go where?");
        System.setOut(originalOut);
    }

    @Test
    public void testGoCommandWithInvalidDirection() {
        PrintStream originalOut = System.out;
        PrintStream mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        CommandParser.parse("go south", state);

        verify(mockOut).println("You can't go that way!");
        System.setOut(originalOut);
    }

    @Test
    public void testLookCommandShowsCurrentRoomDescription() {
        PrintStream originalOut = System.out;
        PrintStream mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        CommandParser.parse("look", state);

        verify(mockOut).println("Room 1 description");
        verify(mockOut).println("There are exits in the directions: north ");
        System.setOut(originalOut);
    }

    @Test
    public void testHelpCommandShowsHelpMessage() {
        PrintStream originalOut = System.out;
        PrintStream mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        CommandParser.parse("help", state);

        verify(mockOut).println("Available commands:");
        verify(mockOut).println("- go [direction]: Move to the room in the specified direction.");
        verify(mockOut).println("- look: Repeat the description of your current location.");
        verify(mockOut).println("- help: Show this help message.");
        verify(mockOut).println("- quit: Exit the game.");
        System.setOut(originalOut);
    }

    @Test
    public void testQuitCommandExitsTheGame() {
        PrintStream originalOut = System.out;
        PrintStream mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        try {
            CommandParser.parse("quit", state);
            fail("Expected System.exit() to be called");
        } catch (Exception ignored) {
            // Expected System.exit() to happen, test passes if exception is caught
        }

        System.setOut(originalOut);
    }
}

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

