package Controller;

import java.util.ArrayList;

import Model.Biblioteca;
import Model.Libro;
import Model.Usuario;
import Model.Utils.RolUsuario;

public class XestionRedeBilblios {
    private static XestionRedeBilblios instancia;

    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Biblioteca> biblios;
    private static ArrayList<Libro> libros; 

    private XestionRedeBilblios() {
        usuarios = new ArrayList<>();
        biblios = new ArrayList<>();
        libros = new ArrayList<>(); 
    }

    public static XestionRedeBilblios getInstancia() {
        if (instancia == null) {
            instancia = new XestionRedeBilblios();
        }
        return instancia;
    }

     // USUARIOS
    public void rexistrarUsuario(String nome, String contrasinal, RolUsuario rol) throws ExcepcionUsuarioExistente {
        for (Usuario u : usuarios) {
            if (u.getNome().equals(nome)) {
                throw new ExcepcionUsuarioExistente("Xa existe un usuario con ese nome.");
            }
        }
        Usuario novo = new Usuario(nome, contrasinal, rol);
        usuarios.add(novo);
    }

    public Usuario login(String nome, String contrasinal) {
        for (Usuario u : usuarios) {
            if (u.getNome().equals(nome) && u.getContrasinal().equals(contrasinal)) {
                return u;
            }
        }
        return null;
    }
}
