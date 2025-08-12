

public class Main {
    public static void main(String[] args) {

        Books books = new Books("Harry Potter","Magia","Jk",2);
        List<Books> lista = new ArrayList<>();

        libraryService library = new libraryService(lista);
        library.addBook(books);
        library.getBooksList();



    }
}