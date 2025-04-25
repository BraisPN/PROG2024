package View;

import java.util.Scanner;

public class Vista {

    public void inicio() {
        System.out.println("\n**************************");
        System.out.println("**************************");
        System.out.println("*** BENVIDO A MUSI.COM ***");
        System.out.println("**************************");
        System.out.println("**************************");
        System.out.println("\nDesea iniciar sesión (s/n)");
    }

    // public HashMap<String, String> inicioSesion(Scanner s) {
    //     System.out.print("\nUsuario -> ");
    //     String Usuario = s.nextLine();
    //     System.out.print("Contrasinal -> ");
    //     String Contrasinal = s.nextLine();
    //     HashMap<String, String> sesion = new HashMap<>();
    //     sesion.put(Usuario, Contrasinal);
    //     return sesion;
    // }

    public void menuAdministrador() {
        System.out.println("1) Engadir produto");
        System.out.println("2) Ver produtos");
        System.out.println("3) Engadir stock");
        System.out.println("4) Eliminar stock");
        System.out.println("5) Cerrar Sesión");
        System.out.print("\nOpción -> ");


        // Engadir produto (submenú para escoller tipo)
        // Ver produtos (submenú):
        // Engadir stock (por identificador)
        // Eliminar stock (por identificador)
    }
    
    public void menuEngadirProducto(Scanner s){
        System.out.println("1) Instrumento");
        System.out.println("2) Complemento");
        String opcion = s.nextLine();
        switch (opcion) {
            case "1":
                System.out.println("1) Saxofón");
                System.out.println("2) Frauta");
                System.out.println("3) Trombón");
                opcion = s.nextLine();
                switch (opcion) {
                    case "1":
                        
                        break;
                    case "2":

                        break;
                    default:
                        break;
                }
                break;
            case "2":
                
                break;
            default:
                System.out.println("Error: Escolla unha opción disponible");
                break;
        }
    }

    public void menuProductosAdmin() {
        System.out.println("1) Tódolos produtos");
        System.out.println("2) Tódolos instrumentos");
        System.out.println("3) Tódalas frautas");
        System.out.println("4) Tódolos saxofóns");
        System.out.println("5) Tódolos trombóns");
        System.out.println("6) Tódolos complementos");
        System.out.println("7) Tódolos libros");
        System.out.println("8) Tódolos estoxos");
        System.out.println("9) Información dun produto concreto (por identificador)");
        System.out.println("10) Sair");
        System.out.print("\nOpción -> ");

    }

    public void menuCliente() {
        System.out.println("1) Ver produtos");
        System.out.println("2) Comprar unha unidade");
        System.out.println("3) Cerrar Sesión");
        System.out.print("\nOpción -> ");


        // Ver produtos (submenú)
        // Comprar unha unidade (por identificador, sen almacenar compras, só modificar
        // stock)
    }

    public void menuProductosCliente() {
        System.out.println("1) Tódolos produtos");
        System.out.println("2) Tódolos instrumentos");
        System.out.println("3) Tódalas frautas");
        System.out.println("4) Tódolos saxofóns");
        System.out.println("5) Tódolos trombóns");
        System.out.println("6) Tódolos complementos");
        System.out.println("7) Tódolos libros");
        System.out.println("8) Tódolos estoxos");
        System.out.println("9) Sair");
        System.out.print("\nOpción -> ");
    }
}
