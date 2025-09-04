package entity;


public class User {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public User(String name, int id) {

    }
    public User(String nomeUser) {
        this.name = nomeUser;
    }

}
