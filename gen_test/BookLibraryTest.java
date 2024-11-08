package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookLibraryTest {
    private BookLibrary library;

    @Before
    public void setUp() {
        library = new BookLibrary();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Test", "Author", 2021);
        library.addBook(book);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testPrintAllBooks() {
        Book book1 = new Book("Test1", "Author1", 2021);
        Book book2 = new Book("Test2", "Author2", 2022);
        library.addBook(book1);
        library.addBook(book2);
        assertNotNull(library.getBooks());
        assertEquals(2, library.getBooks().size());
    }
}
```

CommandParserTest.java
```
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

