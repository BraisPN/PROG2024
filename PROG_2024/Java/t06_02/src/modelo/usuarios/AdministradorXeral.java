package modelo.usuarios;

public class AdministradorXeral extends Usuario {

    /**
     * Crea o administador xeral
     * @param usuario
     * @param password
     */
    public AdministradorXeral(String usuario, String password) {
        super(usuario, password);
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMIN_XERAL;
    }

}
