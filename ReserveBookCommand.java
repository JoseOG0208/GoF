package biblioteca.commands;

import biblioteca.Book;

// Clase que implementa el comando para reservar un libro en el sistema de biblioteca.
// Esta clase sigue el patrón de diseño Command, proporcionando una forma
// de encapsular la acción de reservar un libro como un objeto.
public class ReserveBookCommand implements Command {
    private Book book; // Referencia al libro que será reservado.

    // Constructor que inicializa el comando con el libro específico que debe ser reservado.
    // Al crear una instancia de este comando, se pasa el libro que se desea reservar,
    // vinculando así el comando a una acción específica sobre ese libro.
    public ReserveBookCommand(Book book) {
        this.book = book;
    }

    // Ejecuta el comando de reservar el libro. Este método altera el estado del libro para marcarlo como reservado,
    // asegurando que el libro no esté disponible para ser reservado por otro usuario.
    @Override
    public void execute() {
        book.reserve(); // Llama al método reserve del libro para marcarlo como reservado.
    }

    //Deshace la reserva del libro, liberando el libro para que otros usuarios puedan reservarlo.
    @Override
    public void undo() {
        book.release(); // Llama al método release del libro para desmarcarlo como reservado.
    }
}

