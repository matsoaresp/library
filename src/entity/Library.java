package entity;

public abstract class Library {

    private String name;
    private String description;
    private String author;

    public Library(String name, String description, String author, int edition) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    private int edition;

}
