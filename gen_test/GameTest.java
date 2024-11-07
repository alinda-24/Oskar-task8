package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    private GameState testState;
    private Room startRoom;
    private Room secondRoom;

    @Before
    public void setUp() {
        startRoom = new Room("Starting Room");
        secondRoom = new Room("Second Room");
        
        startRoom.addExit("east", secondRoom);
        secondRoom.addExit("west", startRoom);

        testState = new GameState(startRoom);
    }

    @Test
    public void testInitialRoomIsCorrect() {
        assertEquals(startRoom, testState.getCurrentRoom());
    }

    @Test
    public void testMoveToAnotherRoom() {
        testState.setCurrentRoom(secondRoom);
        assertEquals(secondRoom, testState.getCurrentRoom());
    }

    @Test
    public void testInvalidDirection() {
        Room current = testState.getCurrentRoom();
        Room next = current.go("north");
        assertNull(next);
    }

    @Test
    public void testValidDirection() {
        Room current = testState.getCurrentRoom();
        Room next = current.go("east");
        assertEquals(secondRoom, next);
    }
    
    @Test
    public void testLookAround() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        testState.getCurrentRoom().lookAround();
        assertTrue(output.toString().contains("Starting Room"));
        assertTrue(output.toString().contains("east"));
    }
    
    @Test
    public void testRoomExits() {
        String description = "Test Room";
        Room room = new Room(description);
        Room exitRoom = new Room("Next Room");
        room.addExit("south", exitRoom);
        
        assertEquals(exitRoom, room.go("south"));
        assertNull(room.go("north"));
    }
    
    @Test
    public void testRoomGoInvalidDirection() {
        Room newRoom = startRoom.go("InvalidDirection");
        assertNull(newRoom);
    }

    @Test
    public void testRoomDescription() {
        assertEquals("Starting Room", startRoom.lookAround());
    }

    @Test
    public void testAddExit() {
        Room roomC = new Room("Room C");
        startRoom.addExit("north", roomC);
        assertEquals(roomC, startRoom.go("north"));
    }

    @Test
    public void testCommandParserGoValidDirection() {
        CommandParser.parse("go east", testState);
        assertEquals(secondRoom, testState.getCurrentRoom());
    }

    @Test
    public void testCommandParserGoInvalidDirection() {
        CommandParser.parse("go north", testState);
        assertEquals(startRoom, testState.getCurrentRoom());
    }

    @Test
    public void testCommandParserHelp() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        CommandParser.parse("help", testState);
        assertTrue(output.toString().contains("Available commands"));
    }

    @Test
    public void testCommandParserUnknownCommand() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        CommandParser.parse("unknown", testState);
        assertTrue(output.toString().contains("Unknown command"));
    }

    @Test
    public void testGenerateRoomsFromFile() {
        try {
            String testContent = "Room;StartRoom;Initial Room Description\nRoom;RoomA;Room A Description\nExit;StartRoom;north;RoomA";
            File testFile = File.createTempFile("testSpaceship", ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
                writer.write(testContent);
            }
            GameState state = TestUtils.generateRoomsFromTestFile(testFile.getAbsolutePath());
            assertNotNull(state);
            assertEquals("Initial Room Description", state.getCurrentRoom().lookAround());
            state.getCurrentRoom().go("north");
            assertEquals("Room A Description", state.getCurrentRoom().lookAround());
        } catch (IOException e) {
            fail("Failed to create test file: " + e.getMessage());
        }
    }

    @Test
    public void testGenerateRoomsFromFileMissingRoom() {
        try {
            String invalidContent = "Room;RoomA;Room A Description\nExit;StartRoom;north;RoomA";
            File testFile = File.createTempFile("testSpaceshipInvalid", ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
                writer.write(invalidContent);
            }
            GameState state = TestUtils.generateRoomsFromTestFile(testFile.getAbsolutePath());
            assertNull(state);
        } catch (IOException e) {
            fail("Failed to create test file: " + e.getMessage());
        }
    }
}

class TestUtils {
    public static GameState generateRoomsFromTestFile(String filename) {
        HashMap<String, Room> worldModel = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(";");
                if (data[0].equals("Room")) {
                    worldModel.put(data[1], new Room(data[2]));
                } else if (data[0].equals("Exit")) {
                    worldModel.get(data[1]).addExit(data[2], worldModel.get(data[3]));
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            return null;
        }
        return new GameState(worldModel.get("StartRoom"));
    }
}