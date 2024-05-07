package biblioteca.memento;

import biblioteca.Book;
import java.util.List;

// Esta clase es responsable de crear un memento que contenga una instantánea de su estado actual
// y de restaurar su estado a partir de un memento.
public class Originator {
    private List<Book> books; // La lista actual de libros que maneja el originator.

    // Establece la lista de libros que el originator debe manejar.
    // Este método puede ser usado para actualizar el estado interno del originator.
    public void set(List<Book> books) {
        this.books = books;
    }

    // Crea un memento que contiene una copia del estado actual del originator.
    // Este memento puede ser utilizado para restaurar el estado del originator en un momento posterior.
    public Memento saveToMemento() {
        return new Memento(books);
    }
}
