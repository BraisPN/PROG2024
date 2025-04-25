package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Administrador;
import Model.Cliente;
import Model.Usuario;
import Utils.RolUsuario;
import View.Vista;

public class Tenda {
    private static Tenda tenda;
    private Vista vista;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Administrador> admins;
    private ArrayList<Cliente> clientes;
    private Usuario usuarioActual = null;

    

    private Tenda() {
        this.usuarios = new ArrayList<Usuario>();
        this.admins = new ArrayList<Administrador>();
        this.clientes = new ArrayList<Cliente>();

        rexistrarUsuario("Pepe", "abc123.", RolUsuario.ADMINISTRADOR);
    }

    public static Tenda getInstancia() {
        if (tenda == null) {
            tenda = new Tenda();
        }
        return tenda;
    }

    public void rexistrarUsuario(String nome, String Contrasinal, RolUsuario rol) {
        if (rol == RolUsuario.ADMINISTRADOR) {
            Administrador admin = new Administrador(nome, Contrasinal);
            usuarios.add(admin);
            admins.add(admin);
        } else {
            Cliente client = new Cliente(nome, Contrasinal);
            usuarios.add(client);
            clientes.add(client);
        }

    }

    public boolean comprobarUsuario(HashMap<String,String> sesion){
        for(Usuario u: usuarios){
            if (sesion.containsKey(u.getNome()) && sesion.containsValue(u.getContrasinal())) {
                this.usuarioActual = u;
                return true;
            }
        }
        return false;
    }
    
    public void engadirProducto(){
        
    }

    public void cerrarSesion(){
        this.usuarioActual = null;
    }

    public Usuario getUsuarioActual() {
        return this.usuarioActual;
    }

    
}
