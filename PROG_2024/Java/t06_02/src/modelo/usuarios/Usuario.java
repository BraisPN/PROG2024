package modelo.usuarios;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    // Almacenamos usuario e contrasinal
    private String username;
    private String password;


    /**
     * Creamos un usuario
     * @param usernmane
     * @param password
     */
    public Usuario(String usernmane, String password) {
        this.username = usernmane;
        this.password = password;
    }


    /**
     * Comproba se o nome de usuario e contrasinal coinciden
     * @param username
     * @param password
     * @return
     */
    public boolean comprobarUsuario(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password)) return true;
        return false;
    }

    /**
     * Poñemolo abstracto para que cada clase filla o implante
     * @return
     */
    public abstract TipoUsuario getTipo();


    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return this.username;
    }

    
}
