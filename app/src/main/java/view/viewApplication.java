package view;

public class viewApplication {

    public static void showName(){
        System.out.println("Informe o nome do livro");
    }
    public static void showAuthor(){
        System.out.println("Informe o nome do autor do livro");
    }
    public static void showEdition(){
        System.out.println("Informe a edição do livro");
    }
    public static void showOptions(){
        System.out.println("==== MENU ====");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Emprestar livro");
        System.out.println("4 - Devolver livro");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

    }
}
