package entity;

public class Books extends Library {

    private boolean disponible;
    private User usuarioEmprestimo;

    public Books(String name, String author, int edition) {
        super(name, author, edition);
        this.disponible = false;
        this.usuarioEmprestimo = null;
    }
    public Books(){

    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isEmprestado (){
        return this.disponible;
    }


    public User getUsuarioEmprestimo() {
        return usuarioEmprestimo;
    }

    public void emprestadoPara(User user){
        this.usuarioEmprestimo = user;
        this.disponible = true;
    }

    public void devolverPara(User user){
        this.usuarioEmprestimo = null;
        this.disponible = false;
    }
}
