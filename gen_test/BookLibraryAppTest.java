package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookLibraryAppTest {
    private BookLibraryApp app;

    @Before
    public void setUp() {
        app = new BookLibraryApp();
        createTestFile();
    }

    private void createTestFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.csv"))) {
            writer.write("Title1,Author1,2001\n");
            writer.write("Title2,Author2,2002\n");
        } catch (IOException e) {
            fail("Setup failed to create test CSV file.");
        }
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of("books.csv"));
    }

    @Test
    public void testLoadLibraryFromFile() {
        app.loadLibraryFromFile("books.csv");
        List<Book> books = app.library.getBooks();
        assertEquals(2, books.size());
        assertEquals("Title1", books.get(0).getTitle());
        assertEquals("Author2", books.get(1).getAuthor());
    }
}
```

BookLibraryTest.java
```
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

