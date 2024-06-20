import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public abstract class LibraryItem implements Searchable{
    protected String title;
    protected int year;
    protected boolean available;
    protected List<Reader> borrowers;


    public LibraryItem(String title, int year){
        this.title = title;
        this.year = year;
        this.available = true;
        this.borrowers = new ArrayList<>();
    }

    public void borrowItem(Reader reader) {
        this.available = false;
        this.borrowers.add(reader);
    }

    public void returnItem() {
        this.available = true;
        this.borrowers.clear();
    }

    public List<Reader> getBorrowers(){
        return borrowers;
    }

    @Override
    public boolean matches(String x) {
        return this.title.toLowerCase().contains(x.toLowerCase());
    }
}
