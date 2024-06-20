public class NotFictionBook extends Book{
    private String subjectArea;

    public NotFictionBook(String title, int year, String author, String isbn, String subjectArea) {
        super(title, year, author, isbn);
        this.subjectArea = subjectArea;
    }
}
