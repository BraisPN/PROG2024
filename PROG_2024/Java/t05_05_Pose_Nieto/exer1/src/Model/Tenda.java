package Model;

import java.util.ArrayList;

import Utils.RolUsuario;

public class Tenda {
    private static Tenda tenda;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Administrador> admins;
    private ArrayList<Cliente> clientes;

    

    private Tenda() {
        this.usuarios = new ArrayList<Usuario>();
        this.admins = new ArrayList<Administrador>();
        this.clientes = new ArrayList<Cliente>();
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
}
