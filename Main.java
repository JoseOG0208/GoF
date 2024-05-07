package biblioteca;

import biblioteca.factory.UserFactory;
import biblioteca.factory.ConcreteUserFactory;
import biblioteca.singleton.DatabaseManager;
import biblioteca.users.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Configuración inicial de las herramientas necesarias para el sistema.
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = DatabaseManager.getInstance(); // Singleton para la gestión de la base de datos.
        UserFactory userFactory = new ConcreteUserFactory(scanner); // Factory para la creación de usuarios.

        while (true) {
            // Menú principal
            System.out.println("Bienvenido al sistema de la biblioteca.");
            System.out.println("1. Crear usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Manejo de las opciones del menú.
            switch (choice) {
                case 1:  // Crear usuario
                    createUser(userFactory, dbManager, scanner);
                    break;
                case 2:  // Iniciar sesión
                    loginAndInteract(dbManager, scanner);
                    break;
                case 3:  // Salir
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default: // Opción invalida
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    // Método para crear un usuario utilizando una fábrica.
    private static void createUser(UserFactory userFactory, DatabaseManager dbManager, Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo usuario: ");
        String name = scanner.nextLine();
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Estudiante");
        System.out.println("2. Profesor");
        System.out.println("3. Administrador");
        int userType = scanner.nextInt();
        scanner.nextLine();

        // Crear el usuario y añadirlo a la base de datos si la creación es exitosa.
        User newUser = userFactory.createUser(convertUserType(userType), name);
        if (newUser != null) {
            dbManager.addUser(newUser);
            System.out.println("Usuario creado exitosamente: " + newUser.getName());
        } else {
            System.out.println("No se pudo crear el usuario. Asegúrese de elegir un tipo válido.");
        }
    }

    // Método para iniciar sesión y interactuar con el sistema.
    private static void loginAndInteract(DatabaseManager dbManager, Scanner scanner) {
        System.out.print("Ingrese su nombre: ");
        String name = scanner.nextLine();
        User user = dbManager.getUserByName(name).orElse(null);
        if (user != null) {
            interactWithUser(user, scanner);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Método para interactuar con el sistema después de iniciar sesión.
    private static void interactWithUser(User user, Scanner scanner) {
        boolean continueSession = true;
        while (continueSession) {
            user.displayOptions();
            System.out.print("Seleccione una acción (1-4) o escriba 'salir' para finalizar sesión: ");
            String input = scanner.nextLine().toLowerCase();
            if ("salir".equals(input)) {
                continueSession = false;
                System.out.println("Finalizando sesión...");
            } else {
                try {
                    int action = Integer.parseInt(input);
                    user.handleAction(action);
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                }
            }
        }
    }

    // Método para convertir el tipo de usuario de entero a cadena según el menú de creación de usuarios.
    private static String convertUserType(int userType) {
        switch (userType) {
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            default:
                throw new IllegalArgumentException("Tipo de Usuario no valido");
        }
    }
}
