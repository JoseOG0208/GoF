package biblioteca.users;

import biblioteca.Book;
import biblioteca.singleton.DatabaseManager;
import java.util.Scanner;

public class Student extends User {
    private Scanner scanner;

    public Student(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public void displayOptions() {
        System.out.println("1. Buscar libro por ID");
        System.out.println("2. Reservar libro");
        System.out.println("3. Consultar disponibilidad de libro");
    }

    @Override
    public void handleAction(int action) {
        DatabaseManager dbManager = DatabaseManager.getInstance();
        switch (action) {
            case 1:
                searchBookById(dbManager);
                break;
            case 2:
                reserveBook(dbManager);
                break;
            case 3:
                checkBookAvailability(dbManager);
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

    private void reserveBook(DatabaseManager dbManager) {
        System.out.print("Ingrese ID del libro para reservar: ");
        String id = scanner.nextLine();
        dbManager.findBookById(id).ifPresentOrElse(
                book -> {
                    if (!book.isReserved()) {
                        book.reserve();
                        System.out.println("Libro reservado con éxito.");
                    } else {
                        System.out.println("El libro ya está reservado.");
                    }
                },
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
}
