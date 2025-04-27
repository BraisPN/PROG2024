package View;

import Controller.Tenda;
import java.util.Scanner;

public class MenuAdmin {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1) Engadir produto");
            System.out.println("2) Ver produtos");
            System.out.println("3) Engadir stock");
            System.out.println("4) Eliminar stock");
            System.out.println("5) Cerrar Sesión");
            System.out.print("Escolla unha opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    new MenuEngadirProducto().mostrarMenu();
                    break;
                case 2:
                    new MenuProductos().mostrarMenu();
                    break;
                case 3:
                    engadirStock();
                    break;
                case 4:
                    eliminarStock();
                    break;
                case 5:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void engadirStock() {
        System.out.print("ID do produto: ");
        int id = sc.nextInt();
        System.out.print("Cantidade a engadir: ");
        int cantidade = sc.nextInt();
        try {
            Tenda.getInstancia().engadirStock(id, cantidade);
            System.out.println("Stock engadido correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eliminarStock() {
        System.out.print("ID do produto: ");
        int id = sc.nextInt();
        System.out.print("Cantidade a eliminar: ");
        int cantidade = sc.nextInt();
        try {
            Tenda.getInstancia().quitarStock(id, cantidade);
            System.out.println("Stock eliminado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
