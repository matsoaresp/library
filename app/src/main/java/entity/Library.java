package entity;


public abstract class Library {

    private Long id;
    private String name;
    private String author;


    public Library() {
        this.name = "";

        this.author = "";
        this.edition = 0;
    }
    public Library(String name, String author, int edition) {
        this.name = name;
        this.author = author;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
