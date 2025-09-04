import entity.Books;
import java.util.ArrayList;
import java.util.List;
import service.libraryService;



public class Main {

    public static void main(String[] args) {
        List<Books> list = new ArrayList<>();
        libraryService library = new libraryService(list);
        library.runApllication();
    }
}
