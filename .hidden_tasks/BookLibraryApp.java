import java.util.List;
import java.util.Scanner;

public class BookLibraryApp {
    private BookLibrary library;
    private Scanner scanner;

    // Initializes a new BookLibraryApp
    public BookLibraryApp() {
        library = new BookLibrary();
        scanner = new Scanner(System.in);
    }

    // Main method to start the application
    public static void main(String[] args) {
        BookLibraryApp app = new BookLibraryApp();
        app.loadLibraryFromFile("books.csv");
        app.startMenu();
    }

    // Method to load books from a file
    public void loadLibraryFromFile(String filePath) {
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
    }

    // Display the main menu of the application
    public void startMenu() {
        while (true) {
            System.out.println("\nWelcome to the Book Library");
            System.out.println("1. View all books");
            System.out.println("2. Search for a book by title");
            System.out.println("3. Sort books by year");
            System.out.println("4. Delete a book by title");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    library.printAllBooks();
                    break;
                case 2:
                    searchBookByTitle();
                    break;
                case 3:
                    sortBooksByYear();
                    break;
                case 4:
                    deleteBookByTitle();
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to allow users to search books by title
    private void searchBookByTitle() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        for (Book book : library.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Method to sort books by publication year
    private void sortBooksByYear() {
        library.getBooks().sort((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear()));
        System.out.println("Books sorted by year:");
        library.printAllBooks();
    }

    // Method to allow deletion of a book by title
    private void deleteBookByTitle() {
        System.out.print("Enter book title to delete: ");
        String title = scanner.nextLine();
        List<Book> books = library.getBooks();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                System.out.println("Book removed.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}