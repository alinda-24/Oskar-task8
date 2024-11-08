import java.util.List;
import java.util.ArrayList;

public class BookLibrary {
    private List<Book> books;

    // Initializes a new BookLibrary
    public BookLibrary() {
        books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books in the library
    public void printAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        String filePath = "books.csv"; // Path to the CSV file
        BookLibrary library = new BookLibrary();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(",");
                // Create a Book object from the CSV data
                Book book = new Book(bookData[0], bookData[1], Integer.parseInt(bookData[2]));
                library.addBook(book); // Add the book to the library
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle file I/O exceptions
        }

        library.printAllBooks(); // Print all books in the library
    }
}