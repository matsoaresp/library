package service;

import java.util.List;
import java.util.Scanner;

import entity.User;
import view.viewApplication;
import entity.Books;

public class libraryService {

    private List<Books> booksList;
    private List<User> userList;

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

    public List<Books> getBooksList() {

        if (booksList == null || booksList.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return null;
        }
        System.out.println("Livros disponiveis");
        for (Books book : booksList) {
            if(!book.isEmprestado()){
                System.out.println("Livro: "+book.getName() + ", Autor: " + book.getAuthor() + ", Edição: " + book.getEdition());
            }
        }
        System.out.println("Livros emprestados");
        boolean emprestado = false;
        for(Books book : booksList){
                if(book.isEmprestado()){
                    System.out.println("Livro: " + book.getName() + " | Emprestado para: " + book.getUsuarioEmprestimo().getName());
                    emprestado = true;
                }
            }

        if (!emprestado) {
            System.out.println("Nenhum livro emprestado");
        }
        return null;
    }

    public void emprestar() {

        Scanner sc = new Scanner(System.in);

        if (booksList == null || booksList.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }
            System.out.println("Informe seu nome: ");
            String nomeUser = sc.nextLine();
            System.out.println("Informe qual livro deseja emprestar: ");
            String nomeLivro = sc.nextLine();

            User user = new User(nomeUser);
            boolean emprestado = false;
            for (Books book : booksList) {
                if (book.getName().equals(nomeLivro)) {
                    book.emprestadoPara(user);
                    System.out.println("Livro emprestado para: "+book.getUsuarioEmprestimo().getName());
                    emprestado = true;
                    break;
                }
            }
        if (!emprestado) {
            System.out.println("Livro não encontrado");
        }
        }
    public void runApllication(){
        selectOptions();
    }
    }



