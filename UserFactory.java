package biblioteca.factory;

import biblioteca.users.User;

// Clase abstracta UserFactory que define un método para la creación de diferentes tipos de usuarios.
// Esta clase es parte del patrón de diseño Factory Method, permitiendo que subclases concretas
// especifiquen los objetos User que serán creados.
public abstract class UserFactory {
    //Crea un objeto User basado en el tipo y nombre proporcionados.
    public abstract User createUser(String type, String name);
}
