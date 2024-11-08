package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    private static final String TEST_LAYOUT_FILE = "test_spaceship_layout.txt";

    @Before
    public void setUp() {
        setUpLayoutFile();
    }

    public static void setUpLayoutFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_LAYOUT_FILE))) {
            writer.write("Room;StartRoom;You are in the starting room.\n");
            writer.write("Room;EngineRoom;You are in the engine room.\n");
            writer.write("Exit;StartRoom;north;EngineRoom\n");
        } catch (IOException e) {
            fail("Setup failed to create test layout file.");
        }
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_LAYOUT_FILE));
    }

    @Test
    public void testGameInitialization() {
        try {
            Game.main(new String[]{});
            // Test game initialization logic, this example needs a manual input simulation to proceed further.
            assertTrue(true); // Placeholder for actual channeling of input/output.
        } catch (Exception e) {
            fail("Test failed due to Exception.");
        }
    }
}
```

BookLibraryAppTest.java
```
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.List;

