public class Student extends Reader{
    private String studentId;

    public Student(String name, String surname, String readerTicket, String studentId) {
        super(name, surname, readerTicket);
        this.studentId = studentId;
    }

    @Override
    public void borrowItem(LibraryItem item) {
        super.borrowItem(item);
    }

    @Override
    public void returnItem(LibraryItem item) {
        super.returnItem(item);
    }
}
