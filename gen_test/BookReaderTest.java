package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookReaderTest {
    private static final String TEST_FILE = "test_books.csv";
    private static final String INVALID_FILE = "invalid.csv";

    @Before
    public void setUp() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            writer.write("Title1,Author1,2001\n");
            writer.write("Title2,Author2,2002\n");
        } catch (IOException e) {
            fail("Setup failed to create test CSV file.");
        }
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE));
        Files.deleteIfExists(Path.of(INVALID_FILE));
    }

    @Test
    public void testBookReader() {
        try {
            BookReader.main(new String[]{TEST_FILE});
            List<String> output = Files.readAllLines(Path.of(TEST_FILE));
            assertTrue(output.contains("Title: Title1, Author: Author1, Year: 2001"));
            assertTrue(output.contains("Title: Title2, Author: Author2, Year: 2002"));
        } catch (IOException e) {
            fail("Test failed due to IOException.");
        }
    }

    @Test(expected = IOException.class)
    public void testInvalidFileHandling() {
        BookReader.main(new String[]{INVALID_FILE});
    }
}
```

GameTest.java
```
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

