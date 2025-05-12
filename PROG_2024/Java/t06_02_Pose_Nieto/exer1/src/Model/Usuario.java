package Model;

import Model.Excepcions.ExcepcionCorreoInvalido;
import Model.Excepcions.ExcepcionRolUsuario;
import Model.Utils.RolUsuario;

public class Usuario {
    private String nome;
    private String apelidos;
    private String dni;
    private String correo;
    private String nomeUsu;
    private String contrasinal;
    private RolUsuario rol;

    public Usuario(String nome, String apelidos, String dni, String correo, String nomeUsu, String contrasinal, int rol)
            throws ExcepcionCorreoInvalido, ExcepcionRolUsuario {
        setNome(nome);
        setApelidos(apelidos);
        setDni(dni);
        setCorreo(correo);
        setNomeUsu(nomeUsu);
        setContrasinal(contrasinal);
        setRol(rol);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) throws ExcepcionCorreoInvalido {
        if (!correo
                .matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            throw new ExcepcionCorreoInvalido("Error: Formato de correo incorrecto");
        }
        this.correo = correo;
    }

    public String getNomeUsu() {
        return nomeUsu;
    }

    public void setNomeUsu(String nomeUsu) {
        this.nomeUsu = nomeUsu;
    }

    public String getContrasinal() {
        return contrasinal;
    }

    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(int rol) throws ExcepcionRolUsuario {
        if (!(rol == 1 || rol == 2 || rol == 3)) {
            throw new ExcepcionRolUsuario("Error: Non se puido establecer o rol");
        }
        if (rol == 1) {
            this.rol = RolUsuario.ADMIN_XERAL;
        } else if (rol == 2) {
            this.rol = RolUsuario.ADMIN_BIBLIO;
        } else {
            this.rol = RolUsuario.CLIENTE;
        }
    }

}
