package biblioteca.users;

import biblioteca.Book;
import biblioteca.singleton.DatabaseManager;
import java.util.Scanner;

public class Admin extends User {
    private Scanner scanner;

    public Admin(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public void displayOptions() {
        System.out.println("1. Buscar libro por ID");
        System.out.println("2. Consultar disponibilidad de libro");
        System.out.println("3. Añadir un nuevo libro");
        System.out.println("4. Liberar un libro reservado");
    }

    @Override
    public void handleAction(int action) {
        DatabaseManager dbManager = DatabaseManager.getInstance();
        switch (action) {
            case 1:
                searchBookById(dbManager);
                break;
            case 2:
                checkBookAvailability(dbManager);
                break;
            case 3:
                addNewBook(dbManager);
                break;
            case 4:
                releaseBook(dbManager);
                break;
            default:
                System.out.println("Acción no permitida o no reconocida.");
                break;
        }
    }

    private void searchBookById(DatabaseManager dbManager) {
        System.out.print("Ingrese ID del libro: ");
        String id = scanner.nextLine();
        dbManager.findBookById(id).ifPresentOrElse(
                book -> System.out.println("Libro encontrado: " + book.getTitle()),
                () -> System.out.println("Libro no encontrado")
        );
    }

    private void checkBookAvailability(DatabaseManager dbManager) {
        System.out.print("Ingrese ID del libro para verificar disponibilidad: ");
        String id = scanner.nextLine();
        dbManager.findBookById(id).ifPresentOrElse(
                book -> System.out.println("El libro está " + (book.isReserved() ? "reservado." : "disponible.")),
                () -> System.out.println("Libro no encontrado")
        );
    }

    private void addNewBook(DatabaseManager dbManager) {
        System.out.print("Ingrese ID del nuevo libro: ");
        String newId = scanner.nextLine();
        System.out.print("Ingrese título del nuevo libro: ");
        String title = scanner.nextLine();
        Book newBook = new Book(newId, title);
        dbManager.addBook(newBook);
        System.out.println("Nuevo libro añadido con éxito.");
    }

    private void releaseBook(DatabaseManager dbManager) {
        System.out.print("Ingrese ID del libro para liberar: ");
        String id = scanner.nextLine();
        dbManager.findBookById(id).ifPresentOrElse(
                book -> {
                    if (book.isReserved()) {
                        book.release();
                        System.out.println("El libro ha sido liberado con éxito.");
                    } else {
                        System.out.println("El libro ya está disponible.");
                    }
                },
                () -> System.out.println("Libro no encontrado")
        );
    }
}
