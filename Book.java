package biblioteca;

public class Book {
    // Identificador único para el libro
    private String id;
    // Título del libro.
    private String title;
    // Flag para indicar si el libro está actualmente reservado.
    private boolean reserved;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.reserved = false; // Inicialmente, el libro no está reservado.
    }

    //Obtiene el id del libro.
    public String getId() {
        return id;
    }

    //Obtiene el título del libro.
    public String getTitle() {
        return title;
    }

    //Verifica si el libro está reservado.
    public boolean isReserved() {
        return reserved;
    }

    //Marca el libro como reservado.
    public void reserve() {
        this.reserved = true;
    }

    //Libera el libro de su estado reservado.
    public void release() {
        this.reserved = false;
    }
}
