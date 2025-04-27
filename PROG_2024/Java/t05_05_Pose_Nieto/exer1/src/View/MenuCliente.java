package View;

import Controller.Tenda;
import java.util.Scanner;

public class MenuCliente {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú Cliente ---");
            System.out.println("1. Ver produtos");
            System.out.println("2. Comprar produto");
            System.out.println("3. Cerrar sesión");
            System.out.print("Escolla unha opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    new MenuProductos().mostrarMenu();
                    break;
                case 2:
                    comprarProduto();
                    break;
                case 3:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    private void comprarProduto() {
        System.out.print("ID do produto: ");
        int id = sc.nextInt();
        try {
            Tenda.getInstancia().comprarProduto(id);
            System.out.println("Compra realizada con éxito!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
