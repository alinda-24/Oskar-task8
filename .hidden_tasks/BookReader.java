public class BookReader {
    public static void main(String[] args) {
        String filePath = "books.csv"; // Path to the CSV file
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(",");
                // Display book information
                System.out.println("Title: " + bookData[0] + ", Author: " + bookData[1] + ", Year: " + bookData[2]);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle file I/O exceptions
        }
    }
}