public class Book extends LibraryItem{
    protected String author;
    protected String isbn;

    public Book(String title, int year, String author, String isbn) {
        super(title, year);
        this.author = author;
        this.isbn = isbn;
    }


    public String getBookDetails() {
        return "Title: " + this.title + ", Author: " + this.author + ", ISBN: " + this.isbn;
    }
}
