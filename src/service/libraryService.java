package service;
import java.util.List;
import java.util.Scanner;
import view.viewApplication;
import entity.Books;

public class libraryService {

    private List<Books> booksList;

    public libraryService(List<Books> booksList) {
        this.booksList = booksList;
    }

    public void addBook(Books book) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos livros deseja inserir");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            System.out.println(i+"º Livro");
            sc.nextLine();
            viewApplication.showName();
            String name = sc.nextLine();
            book.setName(name);

            viewApplication.showAuthor();
            String author = sc.nextLine();
            book.setAuthor(author);

            viewApplication.showEdition();
            int edition = sc.nextInt();
            book.setEdition(edition);

            booksList.add(new Books(
                    book.getName(),
                    book.getAuthor(),
                    book.getEdition()
            ));
        }
    }


    public void getBooksList() {
        for (Books book : booksList) {
            System.out.println(book.getName()+" "+book.getAuthor()+" "+book.getEdition());

        }
    }
}
