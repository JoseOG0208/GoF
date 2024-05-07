package biblioteca.factory;

import biblioteca.users.User;
import biblioteca.users.Student;
import biblioteca.users.Professor;
import biblioteca.users.Admin;
import java.util.Scanner;

// Clase concreta ConcreteUserFactory que extiende UserFactory.
// Esta fábrica es responsable de crear instancias concretas de diferentes tipos de usuarios
// basados en el tipo especificado. Utiliza el patrón de diseño Factory Method para permitir
// flexibilidad en la creación de diferentes tipos de usuarios.
public class ConcreteUserFactory extends UserFactory {
    private Scanner scanner;

    // Constructor de ConcreteUserFactory que inicializa el scanner necesario para la entrada de datos.
    public ConcreteUserFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    // Implementa el método createUser de la clase abstracta UserFactory para crear diferentes tipos
    // de usuarios basados en el tipo especificado. La creación del usuario depende del tipo
    // que se le pase, y cada tipo corresponde a una clase de usuario diferente.
    @Override
    public User createUser(String type, String name) {
        switch (type.toLowerCase()) {
            case "1":
                return new Student(name, scanner); // Crea y devuelve una nueva instancia de Student.
            case "2":
                return new Professor(name, scanner);  // Crea y devuelve una nueva instancia de Professor.
            case "3":
                return new Admin(name, scanner); // Crea y devuelve una nueva instancia de Admin.
            default:
                throw new IllegalArgumentException("Tipo de usuario desconocido");
        }
    }
}
