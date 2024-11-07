public class Book {
    private String title;
    private String author;
    private String genre;
    private int magicScore;

    public Book(String title, String author, String genre, int magicScore) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.magicScore = magicScore;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getMagicScore() {
        return magicScore;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMagicScore(int magicScore) {
        this.magicScore = magicScore;
    }

    public String getOverview() {
        return String.format("Title: %s, Author: %s, Genre: %s, Magic Score: %d", title, author, genre, magicScore);
    }
}