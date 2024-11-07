package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testAddAndSearchByTitle() {
        Library library = new Library();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 80);
        Book book2 = new Book("Moby Dick", "Herman Melville", "Novel", 60);
        
        library.addBook(book1);
        library.addBook(book2);
        
        List<Book> searchResults = library.searchByTitle("The Great Gatsby");
        assertEquals(1, searchResults.size());
        assertEquals(book1, searchResults.get(0));
        
        searchResults = library.searchByTitle("Unknown Title");
        assertTrue(searchResults.isEmpty());
    }
    
    @Test
    public void testSearchByAuthor() {
        Library library = new Library();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 80);
        Book book2 = new Book("This Side of Paradise", "F. Scott Fitzgerald", "Novel", 70);
        
        library.addBook(book1);
        library.addBook(book2);
        
        List<Book> searchResults = library.searchByAuthor("F. Scott Fitzgerald");
        assertEquals(2, searchResults.size());
        assertTrue(searchResults.contains(book1));
        assertTrue(searchResults.contains(book2));
        
        searchResults = library.searchByAuthor("Unknown Author");
        assertTrue(searchResults.isEmpty());
    }
    
    @Test
    public void testGetBooksSortedByMagicScore() {
        Library library = new Library();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 80);
        Book book2 = new Book("Moby Dick", "Herman Melville", "Novel", 60);
        Book book3 = new Book("The Odyssey", "Homer", "Epic", 90);
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        
        List<Book> sortedBooks = library.getBooksSortedByMagicScore();
        assertEquals(book3, sortedBooks.get(0));
        assertEquals(book1, sortedBooks.get(1));
        assertEquals(book2, sortedBooks.get(2));
    }
}

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

