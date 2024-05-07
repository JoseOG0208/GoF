package biblioteca.memento;

import biblioteca.Book;
import java.util.ArrayList;
import java.util.List;


// Clase Memento que almacena el estado de un objeto Originator.
// el Originator manejará una lista de libros y el Memento almacenará
// una instantánea de esa lista en un punto específico del tiempo.
public class Memento {
    private List<Book> state; // Lista para almacenar el estado de los libros.

    //Constructor que inicializa el Memento con el estado de los libros.
    public Memento(List<Book> stateToSave) {
        this.state = new ArrayList<>(stateToSave);
    }

    // Devuelve el estado guardado de los libros en este memento.
    public List<Book> getSavedState() {
        return state;
    }
}
