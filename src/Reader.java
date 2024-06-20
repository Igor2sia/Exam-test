import java.util.ArrayList;
import java.util.List;

public abstract class Reader implements Searchable{
    protected String name;
    protected String surname;
    protected String readerTicket;
    protected List<LibraryItem> borrowedItems;

    public Reader(String name, String surname, String readerTicket) {
        this.name = name;
        this.surname = surname;
        this.readerTicket = readerTicket;
        this.borrowedItems = new ArrayList<>();
    }



    public void borrowItem(LibraryItem item) {
        this.borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        this.borrowedItems.remove(item);
        item.returnItem();
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    @Override
    public boolean matches(String query) {
        return this.name.toLowerCase().contains(query.toLowerCase()) || this.surname.toLowerCase().contains(query.toLowerCase());
    }

    public String getName() {
        return name + " " + surname;
    }
}
