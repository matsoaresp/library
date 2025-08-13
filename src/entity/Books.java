package entity;

public class Books extends Library {

    private boolean disponible;

    public Books(String name, String author, int edition) {
        super(name, author, edition);
    }
    public Books(){

    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isEmprestado (){
        return this.disponible;
    }

    public void borrowed(){

        this.disponible = true;
    }

    public void devolver (){

        this.disponible = false;
    }
}
