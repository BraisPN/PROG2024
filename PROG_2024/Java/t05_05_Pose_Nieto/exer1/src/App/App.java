package App;

import Controller.Tenda;
import Model.Usuario;
import Model.Exceptions.ExcepcionUsuarioExistente;
import Utils.*;
import View.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Tenda tenda = Tenda.getInstancia();
        Scanner sc = new Scanner(System.in);

        // DATOS DE PROBA
        tenda.cargarUsuariosProba();
        try {
            tenda.cargarProdutosProba();
        } catch (Exception e) {
            System.out.println("Erro cargando produtos de proba: " + e.getMessage());
        }

        System.out.println("\n**************************");
        System.out.println("**************************");
        System.out.println("*** BENVIDO A MUSI.COM ***");
        System.out.println("**************************");
        System.out.println("**************************");

        Usuario usuario = null;
        boolean menuActivo = true;
        while (menuActivo) {
            System.out.println("Que desexa facer?");
            System.out.println("1) Iniciar sesión");
            System.out.println("2) Rexistrarse");
            System.out.println("3) Saír");
            System.out.print("Escolle unha opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    // INICIAR SESIÓN
                    System.out.print("Nome de usuario: ");
                    String nome = sc.nextLine();
                    System.out.print("Contrasinal: ");
                    String contrasinal = sc.nextLine();
                    usuario = tenda.login(nome, contrasinal);

                    if (usuario == null) {
                        System.out.println("Usuario ou contrasinal incorrectos. Tente de novo.\n");
                    }
                    if (usuario.getRol() == RolUsuario.ADMINISTRADOR) {
                        MenuAdmin menuAdmin = new MenuAdmin();
                        menuAdmin.mostrarMenu();
                    } else if (usuario.getRol() == RolUsuario.CLIENTE) {
                        MenuCliente menuCliente = new MenuCliente();
                        menuCliente.mostrarMenu();
                    }
                    break;

                case "2":
                    // REXISTRARSE
                    System.out.print("Nome de usuario: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Contrasinal: ");
                    String novoContrasinal = sc.nextLine();
                    RolUsuario rol = null;

                    while (rol == null) {
                        System.out.println("Elixe rol:");
                        System.out.println("1. Cliente");
                        System.out.println("2. Administrador");
                        System.out.print("Opción: ");
                        String rolOpcion = sc.nextLine();
                        if (rolOpcion.equals("1")) {
                            rol = RolUsuario.CLIENTE;
                        } else if (rolOpcion.equals("2")) {
                            rol = RolUsuario.ADMINISTRADOR;
                        } else {
                            System.out.println("Opción non válida. Tente de novo.");
                        }
                    }

                    try {
                        tenda.rexistrarUsuario(novoNome, novoContrasinal, rol);
                        System.out.println("Rexistro completado con éxito! Agora pode iniciar sesión.\n");
                    } catch (ExcepcionUsuarioExistente e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Saindo...");
                    menuActivo = false;
                    break;
                default:
                    System.out.println("Opción non válida. Tente de novo.\n");
            }
        }

        sc.close();
    }
}
