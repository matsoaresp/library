import entity.Books;
import java.util.ArrayList;
import java.util.List;
import service.libraryService;
import view.viewApplication;

public class Main {
    public static void main(String[] args) {

        Books books = new Books();
        List<Books> list = new ArrayList<>();
        libraryService library = new libraryService(list);
        library.addBook(books);
        library.getBooksList();



    }
}