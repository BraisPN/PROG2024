package App;

import java.util.HashMap;
import java.util.Scanner;

import Controller.Tenda;
import Utils.RolUsuario;
import View.Vista;

public class Main {
    public static void main(String[] args) throws Exception {
        Vista vista = new Vista();
        Tenda tenda = Tenda.getInstancia();
        Scanner s = new Scanner(System.in);
        boolean menuActivo = true;
        while (menuActivo) {
            vista.inicio();
            String opcion = s.nextLine();
            switch (opcion) {
                case "s":
                System.out.print("\nUsuario -> ");
                String Usuario = s.nextLine();
                System.out.print("Contrasinal -> ");
                String Contrasinal = s.nextLine();
                HashMap<String, String> sesion = new HashMap<>();
                sesion.put(Usuario, Contrasinal);
                if (tenda.comprobarUsuario(sesion)) {
                    System.out.println("\nSesión iniciada correctamente");
                    if (tenda.getUsuarioActual().getRol() == RolUsuario.ADMINISTRADOR ) {
                        vista.menuAdministrador();
                        opcion = s.nextLine();
                        switch (opcion) {
                            case "1":
                                
                                break;
                            case "2":
                            
                                break;
                            case "3":

                                break;
                            case "4":

                                break;
                            case "5":

                                break; 
                            default:
                                break;
                        }
                    }
                    else{

                    }

                
                } else {
                    System.out.println("Usuario ou contrasinal incorrecto");
                }
                
                    break;
                case "n":
                    System.out.println("+++ Ate prontooo +++");
                    menuActivo = false;
                    break;
                default:
                    System.out.println("Error: Escolla unha opción disponible");
                    break;
            }
        }

        s.close();
    }
}
