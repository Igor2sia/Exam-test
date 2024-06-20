class Professor extends Reader {
    private String department;

    public Professor(String name, String surname, String readerTicket, String department) {
        super(name, surname, readerTicket);
        this.department = department;
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