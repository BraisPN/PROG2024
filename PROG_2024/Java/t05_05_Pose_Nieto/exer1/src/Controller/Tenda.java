package Controller;

import java.util.ArrayList;

import Model.Frauta;
import Model.Libro;
import Model.Producto;
import Model.Usuario;
import Model.Exceptions.*;
import Utils.*;

public class Tenda {
    private static Tenda instancia;

    private ArrayList<Usuario> usuarios;
    private ArrayList<Producto> productos;

    private Tenda() {
        usuarios = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public static Tenda getInstancia() {
        if (instancia == null) {
            instancia = new Tenda();
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

    // PRODUCTOS
    public void engadirProduto(Producto p) throws ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        if (p.getPrezo() < 0)
            throw new ExcepcionPrezoNegativo("O prezo non pode ser negativo.");
        if (p.getStock() < 0)
            throw new ExcepcionStockNegativo("O stock non pode ser negativo.");
        productos.add(p);
    }

    public Producto buscarProductoPorId(int id) throws ExcepcionIdInvalido {
        for (Producto p : productos) {
            if (p.getIdProducto() == id)
                return p;
        }
        throw new ExcepcionIdInvalido("Produto non encontrado");
    }

    public void engadirStock(int id, int cantidade) throws ExcepcionStockNegativo, ExcepcionIdInvalido {
        Producto p = buscarProductoPorId(id);
        p.setStock(p.getStock() + cantidade);
    }

    public void quitarStock(int id, int cantidade)
            throws ExcepcionIdInvalido, ExcepcionComprarSenStock, ExcepcionStockNegativo {
        Producto p = buscarProductoPorId(id);
        if (cantidade > p.getStock()) {
            throw new ExcepcionComprarSenStock("Non hai stock suficiente.");
        }
        p.setStock(p.getStock() - cantidade);
    }

    public void comprarProduto(int id) throws ExcepcionIdInvalido, ExcepcionComprarSenStock, ExcepcionStockNegativo {
        quitarStock(id, 1);
    }

    public void verTodosProdutos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public void verPorTipo(Class tipo) {
        for (Producto p : productos) {
            if (tipo.isInstance(p)) {
                System.out.println(p);
            }
        }
    }

    // DATOS DE PROBA
    public void cargarUsuariosProba() {
        usuarios.add(new Usuario("admin", "admin", RolUsuario.ADMINISTRADOR));
        usuarios.add(new Usuario("cliente", "cliente", RolUsuario.CLIENTE));
    }

    public void cargarProdutosProba() throws ExcepcionPrezoNegativo, ExcepcionStockNegativo, ExcepcionISBNIncorrecto {
        productos.add(new Frauta(20.0, 100, "Frauta de madeira", "Altus", "F001", true));
        productos.add(new Libro(20.0, 20, "Programación en Java", "Iniciando en Java", "J.S. Bach", "0123456789"));
    }
}