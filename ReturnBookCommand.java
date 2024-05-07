package biblioteca.commands;

import biblioteca.Book;

// Clase que implementa el comando para devolver un libro en el sistema de biblioteca.
// Implementa la interfaz Command, proporcionando métodos para ejecutar y deshacer la acción de devolver un libro.
public class ReturnBookCommand implements Command {
    private Book book;

    // Constructor que inicializa el comando con el libro específico que debe ser devuelto.
    public ReturnBookCommand(Book book) {
        this.book = book;
    }


    // Ejecuta el comando para devolver el libro. Este método cambia el estado del libro
    // para marcarlo como no reservado, liberando así el libro para que otros usuarios puedan reservarlo.
    @Override
    public void execute() {
        book.release();
    }

    // Deshace la devolución del libro, volviendo a reservar el libro.
    @Override
    public void undo() {
        book.reserve();
    } // Llama al método reserve del libro para reservarlo nuevamente.
}

