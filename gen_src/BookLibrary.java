// File: BookLibrary.java
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BookLibrary {
    private List<Book> books;

    public BookLibrary() {
    }

    public void addBook(Book book) {
    }

    public void printAllBooks() {
    }

    public static void main(String[] args) {
        String filePath;
        BookLibrary library;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] bookData;
                Book book;
            }
        } catch (IOException e) {
        }

        library.printAllBooks();
    }
}

// File: Book.java
public class Book {
    public Book(String title, String author, int year) {
    }

    @Override
    public String toString() {
    }
}