package entity;

public class Books extends Library {

    private boolean disponible;

    public Books(String name, String author, int edition) {
        super(name, author, edition);
    }
    public Books(){

    }
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void emprestado (){
        setDisponible(false);
    }
}
