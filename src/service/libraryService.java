package service;

import java.util.List;
import java.util.Scanner;

import entity.User;
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
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "º Livro");

            viewApplication.showName();
            String name = sc.nextLine();

            viewApplication.showAuthor();
            String author = sc.nextLine();

            viewApplication.showEdition();
            int edition = sc.nextInt();
            sc.nextLine();

            booksList.add(new Books(
                    name,
                    author,
                    edition
            ));
        }
    }

    public void selectOptions() {

        Scanner sc = new Scanner(System.in);
        Books book = new Books();
        String option = "";
        while (!option.equals("0")) {
            viewApplication.showOptions();
            option = sc.nextLine();
            switch (option) {
                case "1":
                    addBook(book);
                    break;
                case "2":
                    getBooksList();
                    break;
                case "3":
                    emprestar();
                    break;
                case "0":
                    System.out.println("Execução encerrada.");
                    break;
                default:
                    System.out.println("Opção incorreta. Tente novamente.");
                    break;
            }
        }
    }

    public void getBooksList() {

        User user = new User();

        if (booksList == null || booksList.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }
        System.out.println("Livros disponíveis");
        for (Books book : booksList) {
            System.out.println("Nome: "+book.getName() + ", Autor: " + book.getAuthor() + ", Edição: " + book.getEdition());
            if (book.isEmprestado()) {
                System.out.println("Livros emprestados");
                System.out.println("Emprestado para: " + user.getName());
            }
        }
    }

    public void emprestar() {

        User user = new User();
        Scanner sc = new Scanner(System.in);

        if (booksList == null || booksList.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");

        }else {
            System.out.println("Informe qual livro deseja emprestar: ");
            String nomeLivro = sc.nextLine();
            for (Books book : booksList) {

                if (book.getName().equals(nomeLivro)) {
                    book.borrowed();
                    System.out.println("Livro emprestado para: "+user.getName());
                }else {
                    System.out.println("Livro não encontrado");
                    break;
                }
            }
        }
    }
    public void runApllication(){
        selectOptions();
    }
}
