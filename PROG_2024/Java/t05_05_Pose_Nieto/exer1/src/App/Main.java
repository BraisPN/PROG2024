package App;

import java.util.Scanner;

import View.Vista;

public class Main {
    public static void main(String[] args) throws Exception {
        Vista vista = new Vista();
        Scanner s = new Scanner(System.in);
        vista.inicio();
        String opcion = s.nextLine();
        boolean menuActivo = true;
        while (menuActivo) {
            switch (opcion) {
                case "s":
                    vista.inicioSesion();
                    break;
                case "n":
                    System.out.println("+++ Ate prontooo +++");
                    menuActivo = false;
                    break;
                default:
                    break;
            }
        }
        
        s.close();
    }
    public void inicioSesion(Scanner s) {
        System.out.println("\nUsuario -> ");
        s.nextLine();
        System.out.println("Contrasinal ->");
    }
}
