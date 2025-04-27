package View;

import Controller.Tenda;
import Model.Usuario;
import Utils.*;
import Model.Exceptions.*;
import java.util.Scanner;

public class MenuPrincipal {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        Tenda tenda = Tenda.getInstancia();
        tenda.cargarUsuariosProba();
        try {
            tenda.cargarProdutosProba();
        } catch (Exception e) {
            System.out.println("Erro cargando produtos de proba: " + e.getMessage());
        }

        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Rexistrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Saír");
            System.out.print("Escolla unha opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    rexistrarUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    System.out.println("Saíndo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    private void rexistrarUsuario() {
        System.out.print("Nome de usuario: ");
        String nome = sc.next();
        System.out.print("Contrasinal: ");
        String contrasinal = sc.next();
        System.out.println("Seleccione rol: ");
        System.out.println("1. Administrador");
        System.out.println("2. Cliente");
        System.out.print("Rol: ");
        int opcion = sc.nextInt();
        RolUsuario rol = (opcion == 1) ? RolUsuario.ADMINISTRADOR : RolUsuario.CLIENTE;

        try {
            Tenda.getInstancia().rexistrarUsuario(nome, contrasinal, rol);
            System.out.println("Usuario rexistrado correctamente.");
        } catch (ExcepcionUsuarioExistente e) {
            System.out.println(e.getMessage());
        }
    }

    private void iniciarSesion() {
        System.out.print("Nome de usuario: ");
        String nome = sc.next();
        System.out.print("Contrasinal: ");
        String contrasinal = sc.next();
        Usuario usuario = Tenda.getInstancia().login(nome, contrasinal);
        if (usuario != null) {
            System.out.println("Inicio de sesión correcto. Benvido " + usuario.getNome());
            if (usuario.getRol() == RolUsuario.ADMINISTRADOR) {
                new MenuAdmin().mostrarMenu();
            } else {
                new MenuCliente().mostrarMenu();
            }
        } else {
            System.out.println("Nome de usuario ou contrasinal incorrectos.");
        }
    }
}
