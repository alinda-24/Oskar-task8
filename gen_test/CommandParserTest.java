package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommandParserTest {

    @Test
    public void testParseGoCommand() {
        GameState mockState = createMockGameState();
        CommandParser.parse("go north", mockState);
        assertEquals(mockState.getExpectedRoom(), mockState.getCurrentRoom());
    }

    @Test
    public void testParseHelpCommand() {
        // Assuming there is a method to capture outputs
        CommandParser.parse("help", null);
        assertEquals("Available commands:", getLastOutput());
    }
    
    @Test
    public void testParseUnknownCommand() {
        CommandParser.parse("fly", null);
        assertEquals("Unknown command. Type 'help' for a list of commands.", getLastOutput());
    }

    private GameState createMockGameState() {
        // Implement a basic mock/fake GameState for the test
        return new GameState(new Room("Mock Room"));
    }
    
    private String getLastOutput() {
        // Implement a utility to capture and return the last system output
        return ""; // Placeholder. Actual implementation needed
    }
}