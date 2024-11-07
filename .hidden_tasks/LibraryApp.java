import java.util.List;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        try {
            BufferedReader br = new BufferedReader(new FileReader("books.csv"));
            String line = br.readLine(); // skip headers

            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length == 4) {
                    String title = attributes[0].replace("\"", "");
                    String author = attributes[1].replace("\"", "");
                    String genre = attributes[2].replace("\"", "");
                    int magicScore;
                    try {
                        magicScore = Integer.parseInt(attributes[3].trim());
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid magic score for book: " + title);
                        continue;
                    }
                    library.addBook(new Book(title, author, genre, magicScore));
                } else {
                    System.err.println("Corrupted data: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Could not read the file: " + e.getMessage());
        }

        // Example usage of library system
        List<Book> booksByMagicScore = library.getBooksSortedByMagicScore();
        for (Book book : booksByMagicScore) {
            System.out.println(book.getOverview());
        }
    }
}