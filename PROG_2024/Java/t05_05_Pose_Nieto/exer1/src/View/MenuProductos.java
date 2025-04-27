package View;

import Controller.Tenda;
import Model.Frauta;
import Model.Saxofon;
import Model.Trombon;
import Model.Libro;
import Model.Estoxo;
import java.util.Scanner;

public class MenuProductos {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú Ver Produtos ---");
            System.out.println("1. Tódolos produtos");
            System.out.println("2. Tódolos instrumentos");
            System.out.println("3. Tódalas frautas");
            System.out.println("4. Tódolos saxofóns");
            System.out.println("5. Tódolos trombóns");
            System.out.println("6. Tódolos complementos");
            System.out.println("7. Tódolos libros");
            System.out.println("8. Tódolos estoxos");
            System.out.println("9. Saír");
            System.out.print("Escolla unha opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Tenda.getInstancia().verTodosProdutos();
                    break;
                case 2:
                    Tenda.getInstancia().verPorTipo(Frauta.class);
                    Tenda.getInstancia().verPorTipo(Saxofon.class);
                    Tenda.getInstancia().verPorTipo(Trombon.class);
                    break;
                case 3:
                    Tenda.getInstancia().verPorTipo(Frauta.class);
                    break;
                case 4:
                    Tenda.getInstancia().verPorTipo(Saxofon.class);
                    break;
                case 5:
                    Tenda.getInstancia().verPorTipo(Trombon.class);
                    break;
                case 6:
                    Tenda.getInstancia().verPorTipo(Libro.class);
                    Tenda.getInstancia().verPorTipo(Estoxo.class);
                    break;
                case 7:
                    Tenda.getInstancia().verPorTipo(Libro.class);
                    break;
                case 8:
                    Tenda.getInstancia().verPorTipo(Estoxo.class);
                    break;
                case 9:
                    System.out.println("Saíndo do menú de produtos...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 9);
    }
}
