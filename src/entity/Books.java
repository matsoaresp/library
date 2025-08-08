package entity;

public class Books extends Library {

    private boolean disponible;

    public Books(String name, String description, String author, int edition) {
        super(name, description, author, edition);
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
