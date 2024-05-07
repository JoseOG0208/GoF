package biblioteca.singleton;

import biblioteca.Book;
import biblioteca.users.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Clase Singleton que actúa como el gestor central de la base de datos para el sistema de biblioteca.
// Mantiene y administra las listas de libros y usuarios, proporcionando métodos para manipular estos datos.

public class DatabaseManager {
    private static DatabaseManager instance; // Instancia única del DatabaseManager
    private List<Book> books = new ArrayList<>(); // Lista para almacenar todos los libros en el sistema.
    private List<User> users = new ArrayList<>(); // Lista para almacenar todos los usuarios en el sistema.


    //Constructor privado para prevenir la instanciación directa y garantizar el uso del patrón Singleton.
    private DatabaseManager() { }

    // Método estático para obtener la instancia única del DatabaseManager.
    // Si no existe una instancia, crea una nueva. De lo contrario, devuelve la existente.
    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    // Añade un nuevo libro a la lista de libros gestionada por el sistema.
    public void addBook(Book book) {
        books.add(book);
    }

    // Busca un libro por su identificador en la lista de libros.
    public Optional<Book> findBookById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    // Añade un nuevo usuario a la lista de usuarios gestionada por el sistema.
    public void addUser(User user) {
        users.add(user);
    }

    // Busca un usuario por su nombre en la lista de usuarios.
    public Optional<User> getUserByName(String name) {
        return users.stream().filter(user -> user.getName().equalsIgnoreCase(name)).findFirst();
    }
}
