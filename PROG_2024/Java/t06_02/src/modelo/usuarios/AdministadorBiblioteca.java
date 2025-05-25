package modelo.usuarios;

import modelo.Biblioteca;

public class AdministadorBiblioteca extends Usuario{
    //Almacenamos o biblioteca que administra o Usuario
    private Biblioteca biblioteca;

    /**
     * Crea o administador da biblioteca
     * @param username
     * @param password
     * @param biblioteca
     */
    public AdministadorBiblioteca(String username, String password, Biblioteca biblioteca){
        super(username, password);
        this.biblioteca = biblioteca;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMIN_BIBLITOECA;
    }

    

}
