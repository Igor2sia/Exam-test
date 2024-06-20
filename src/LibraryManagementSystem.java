import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class LibraryManagementSystem {
    private List<LibraryItem> items;
    private List<Reader> readers;
    private Map<LibraryItem, Integer> availableCopies;
    private int maxValueOfcopies;

    private Map<Reader, List<LibraryItem>> borrowedItems;//

    public LibraryManagementSystem() {
        this.items = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.availableCopies = new HashMap<>();
        this.borrowedItems = new HashMap<>();
    }

    public void addBook(Book book, int copies) {
        this.items.add(book);
        this.maxValueOfcopies = copies;
        this.availableCopies.put(book, copies);
        System.out.println("The book \"" + book.title + "\" in the amount of " + copies + " pieces has been added");
    }

    public void removeBook(Book book) {
        this.items.remove(book);
        this.availableCopies.remove(book);
    }

    public void updateBooks(Book book, String newTitle, int newYear, String newAuthor, String newISBN) {
        book.title = newTitle;
        book.year = newYear;
        book.author = newAuthor;
        book.isbn = newISBN;
        System.out.println("Changes have been made to the book");
    }

    public void addReader(Reader reader) {
        this.readers.add(reader);
        System.out.println("The reader \"" + reader.name + " " + reader.surname + "\" has been added");
    }

    public void removeReader(Reader reader) {
        this.readers.remove(reader);
    }

    public void updateReader(Reader reader, String newName, String newSurname, String newReaderTicket) {
        reader.name = newName;
        reader.surname = newSurname;
        reader.readerTicket = newReaderTicket;
        System.out.println("Changes have been made to the readers");
    }

    public boolean borrowItem(Reader reader, LibraryItem item) {
        if (availableCopies.containsKey(item) && availableCopies.get(item) > 0 && item.available) {
            availableCopies.put(item, availableCopies.get(item) - 1);
            System.out.println("Книга '" + item.title + "' выдана читателю " + reader.getName());
            return true;
        }
        System.out.println("Книг не осталось");
        return false;
    }

    public void returnItem(Reader reader, LibraryItem item) {
        reader.returnItem(item);
        int availableCount = this.availableCopies.get(item) + 1;
        if (availableCount < maxValueOfcopies){
            this.availableCopies.put(item, availableCount);
            System.out.println("Книга '" + item.title + "' была возвращена читателем " + reader.getName() +
                    ". Теперь доступно " + this.availableCopies.get(item) + " копий.");
        }
        else System.out.println("В библиотеку возвращены все книги. Вернуть книгу нельзя");
    }

    public List<LibraryItem> searchLibraryItems(String query) {
        List<LibraryItem> matchingItems = new ArrayList<>();
        for (LibraryItem item : this.items) {
            if (item.matches(query)) {
                matchingItems.add(item);
            }
        }

        if (matchingItems.isEmpty()) {
            System.out.println("Ничего не найдено по запросу: " + query);
        } else {
            System.out.println("Найдено " + matchingItems.size() + " результатов по запросу: " + query);
            for (LibraryItem item : matchingItems) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    System.out.println("- " + item.title + " (Автор: " + book.author + ", Год издания: " + book.year + ", ISBN: " + book.isbn +  ")");
                }

            }
        }

        return matchingItems;
    }

    public List<Reader> searchReaders(String query) {
        List<Reader> matchingReaders = new ArrayList<>();
        for (Reader reader : this.readers) {
            if (reader.matches(query)) {
                matchingReaders.add(reader);
            }
        }

        if (matchingReaders.isEmpty()) {
            System.out.println("Ничего не найдено по запросу: " + query);
        } else {
            System.out.println("Найдено " + matchingReaders.size() + " результатов по запросу: " + query);
            for (Reader reader: matchingReaders) {
                System.out.println("- " + reader.getName() + " (Читательский билет: " + reader.readerTicket + ")");
            }
        }
        return matchingReaders;
    }

    public void checkBookStatus(LibraryItem book) {
        if (this.availableCopies.containsKey(book)) {
            int availableCopies = this.availableCopies.get(book);
            System.out.println("Книга '" + book.title + "' - осталось " + availableCopies + " экземпляров.");
        }
    }

    public void printBorrowersForBook(LibraryItem book) {
        List<Reader> borrowers = getBorrowersForBook(book);

        if (borrowers.isEmpty()) {
            System.out.println("Книга '" + book.title + "' в данный момент не выдана никому.");
        } else {
            System.out.println("Книга '" + book.title + "' взята следующими читателями:");
            for (Reader reader : borrowers) {
                System.out.println("- " + reader.getName());
            }
        }
    }

    private List<Reader> getBorrowersForBook(LibraryItem book) {
        return this.borrowedItems.entrySet().stream()
                .filter(entry -> entry.getValue().contains(book))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}