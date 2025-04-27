package Model;

import Utils.RolUsuario;

public class Usuario {
    private String nome;
    private String contrasinal;
    private RolUsuario rol;

    public Usuario(String nome, String contrasinal, RolUsuario rol) {
        setNome(nome);
        setContrasinal(contrasinal);
        setRol(rol);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object obj) {
        Usuario u = (Usuario) obj;
        return this.nome.equals(u.getNome());
    }
}
