import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", 1869, "Лев Толстой", "978-5-389-13700-2");
        Book book2 = new Book("Война и мир", 1868, "Лев Толстой", "978-5-389-13700-0");
        Book book3 = new Book("Война и мир", 1866, "Лев Толстой", "978-5-389-13700-3");
        FictionBook fictionBook = new FictionBook("Гарри Поттер и философский камень",
                1997, "Дж.К. Роулинг", "978-5-389-00697-9", "Фантастика");
        NotFictionBook notFictionBook = new NotFictionBook("Sapiens: Краткая история человечества",
                2011, "Юваль Ной Харари", "978-5-907040-01-6", "История");
        Student student = new Student("Иван", "Иванов", "12345", "12345");
        Professor professor = new Professor("Петр", "Петров", "54321", "Математика");
        LibraryManagementSystem librarySystem = new LibraryManagementSystem();

        // Добавление книг и читателей в библиотечную систему
        librarySystem.addBook(book1, 5);
        librarySystem.addBook(book2, 5);
        librarySystem.addBook(book3, 5);
        librarySystem.addBook(fictionBook, 3);
        librarySystem.addBook(notFictionBook, 2);
        librarySystem.addReader(student);
        librarySystem.addReader(professor);

//         Изменение характеристик книг
        librarySystem.updateBooks(book1, "Анна Каренина", 1877, "Лев Толстой", "978-5-389-13701-9");
        librarySystem.updateBooks(fictionBook, "Гарри Поттер и Тайная комната", 1998, "Дж.К. Роулинг", "978-5-389-00698-6");
        librarySystem.updateBooks(notFictionBook, "Sapiens: Краткая история человечества", 2011, "Юваль Ной Харари", "978-5-907040-02-3");

        // Изменение характеристик читателей
        librarySystem.updateReader(student, "Иван", "Петров", "12346");
        librarySystem.updateReader(professor, "Николай", "Сидоров", "54322");




//        Другие операции с библиотечной системой
        librarySystem.borrowItem(student, book1);
        librarySystem.borrowItem(student, book1);
        librarySystem.borrowItem(student, book1);

        librarySystem.borrowItem(student, book1);
        librarySystem.borrowItem(student, book1);
        librarySystem.borrowItem(student, book1);
        librarySystem.borrowItem(student, book1);
        librarySystem.borrowItem(student, book1);
        librarySystem.borrowItem(professor, fictionBook);
        librarySystem.returnItem(student, book1);
        librarySystem.returnItem(student, book1);


        // Поиск книг и читателей
        List<LibraryItem> searchResults = librarySystem.searchLibraryItems("Война");
        List<Reader> readerResults = librarySystem.searchReaders("Петр");



        librarySystem.checkBookStatus(book1);
        System.out.println();
        librarySystem.printBorrowersForBook(book1);

    }
}
