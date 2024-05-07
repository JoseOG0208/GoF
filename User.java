package biblioteca.users;

public abstract class User {
    private String name; // Nombre del usuario.

    // Constructor para crear un nuevo usuario.
    public User(String name) {
        this.name = name;
    }

    // Obtiene el nombre del usuario.
    public String getName() {
        return name;
    }

    public abstract void displayOptions(); // Método abstracto para mostrar las opciones específicas disponibles para el tipo de usuario.
    public abstract void handleAction(int action); // Método abstracto para manejar la acción seleccionada por el usuario.
}
