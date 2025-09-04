package service;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Scanner;
import entity.User;
import view.viewApplication;
import entity.Books;


public class libraryService {

    private static final Logger logger = Logger.getLogger(libraryService.class.getName());
    private List<Books> booksList;

    public libraryService(List<Books> booksList) {
        this.booksList = booksList;

        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.ALL);

        for (var handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }

        ConsoleHandler handler = new ConsoleHandler() {
            @Override
            protected synchronized void setOutputStream(java.io.OutputStream out) throws SecurityException {
                super.setOutputStream(System.out);
            }
        };
        handler.setLevel(Level.ALL);
        rootLogger.addHandler(handler);
    }

    public void addBook(Books book) {
        logger.info("\u001B[32m[INFO] Opcao de adicionar livros\u001B[0m");
        try{
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
        }catch (Exception e){
            logger.severe("\u001B[31m[ERROR] Erro ao adicionar livros: " + e.getMessage() + "\u001B[0m");
            e.printStackTrace();
        }

    }

    public void selectOptions() {
        logger.info("\u001B[32m[INFO] Iniciando aplicacao \u001B[0m");
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
                case "4":
                    devolver();
                    break;
                case "0":
                    System.out.println("Execucao encerrada.");
                    break;
                default:
                    logger.warning("\u001B[31m[ERROR] Opcao incorreta. Tente novamente: \u001B[0m");
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
                System.out.println("Livro: "+book.getName() + ", Autor: " + book.getAuthor() + ", Edicao: " + book.getEdition());
            }else {
                System.out.println("Nenhum livro disponivel");
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

        try{
            logger.info("\u001B[32m[INFO] Opcao de emprestar livros \u001B[0m");
            Scanner sc = new Scanner(System.in);
            if (booksList == null || booksList.isEmpty()) {
                logger.log(Level.WARNING,"Nenhum livro cadastrado");
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
                logger.log(Level.WARNING,"Nenhum livro emprestado");
            }
        }catch (IllegalArgumentException e ){
            logger.severe("\u001B[31m[ERROR] Entrada inválida: " + e.getMessage() + "\u001B[0m");
        }catch (Exception e){
            logger.severe("\u001B[31m[ERROR] Erro inesperado: " + e.getMessage() + "\u001B[0m");
            e.printStackTrace();
        }
        }

        public void devolver (){

        try{
            logger.info("\u001B[32m[INFO] Opcao de devolver livros \u001B[0m");
            Scanner sc = new Scanner(System.in);

            System.out.println("Livros emprestados");
            boolean emprestado = false;
            for(Books book : booksList){
                if(book.isEmprestado()){
                    System.out.println("Livro: " + book.getName());
                    emprestado = true;
                }
            }
            if (!emprestado) {
                System.out.println("Nenhum livro emprestado");
            }

            System.out.println("Informe o nome do livro");
            String nomeLivro = sc.nextLine();
            for (Books book : booksList) {
                if (book.getName().equals(nomeLivro)) {
                    book.devolverPara(null);

                    System.out.println("Livro devolvido");
                }
            }
        }catch (IllegalArgumentException e ){
            logger.severe("Erro ao devolver livro");
        }
        }
    public void runApllication(){
        selectOptions();
    }
    }



