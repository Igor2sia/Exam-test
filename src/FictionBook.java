public class FictionBook extends Book{
    private String genre;

    public FictionBook(String title, int year, String author, String isbn, String genre) {
        super(title, year, author, isbn);
        this.genre = genre;
    }

}
