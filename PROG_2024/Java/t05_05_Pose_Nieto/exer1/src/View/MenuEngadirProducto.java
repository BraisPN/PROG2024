package View;

import Controller.Tenda;
import Model.Estoxo;
import Model.Frauta;
import Model.Libro;
import Model.Saxofon;
import Model.Trombon;
import Utils.TipoEstoxo;
import Utils.TipoSaxofon;

import java.util.Scanner;

public class MenuEngadirProducto {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú Engadir Produto ---");
            System.out.println("1) Engadir Frauta");
            System.out.println("2) Engadir Libro");
            System.out.println("3) Engadir Saxofón");
            System.out.println("4) Engadir Trombón");
            System.out.println("5) Engadir Estoxo");
            System.out.println("6) Saír");
            System.out.print("Escolla unha opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    engadirFrauta();
                    break;
                case 2:
                    engadirLibro();
                    break;
                case 3:
                    engadirSaxofon();
                    break;
                case 4:
                    engadirTrombon();
                    break;
                case 5:
                    engadirEstoxo();
                    break;
                case 6:
                    System.out.println("Saíndo do menú engadir produto...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private void engadirTrombon() {
        try {
            System.out.print("Prezo: ");
            double prezo = sc.nextDouble();
            System.out.print("Stock: ");
            int stock = sc.nextInt();
            sc.nextLine();
            System.out.print("Descrición: ");
            String descripcion = sc.nextLine();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            System.out.print("Ten transpositor? (s/N): ");
            String resposta = sc.nextLine();

            boolean transpositor = resposta.equalsIgnoreCase("s");

            Trombon trombon = new Trombon(prezo, stock, descripcion, marca, modelo, transpositor);
            Tenda.getInstancia().engadirProduto(trombon);
            System.out.println("Trombón engadido correctamente.");
        } catch (Exception e) {
            System.out.println("Erro ao engadir trombón: " + e.getMessage());
        }
    }

    private void engadirEstoxo() {
        try {
            System.out.print("Prezo: ");
            double prezo = sc.nextDouble();
            System.out.print("Stock: ");
            int stock = sc.nextInt();
            sc.nextLine();
            System.out.print("Descrición: ");
            String descripcion = sc.nextLine();

            System.out.println("Tipo de estoxo:");
            for (TipoEstoxo tipo : TipoEstoxo.values()) {
                System.out.println("- " + tipo);
            }
            System.out.print("Escriba o tipo: ");
            String tipoInput = sc.nextLine().toUpperCase();
            TipoEstoxo tipo = TipoEstoxo.valueOf(tipoInput);

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            Estoxo estoxo = new Estoxo(prezo, stock, descripcion, tipo, marca);
            Tenda.getInstancia().engadirProduto(estoxo);
            System.out.println("Estoxo engadido correctamente.");
        } catch (Exception e) {
            System.out.println("Erro ao engadir estoxo: " + e.getMessage());
        }
    }

    private void engadirSaxofon() {
        try {
            System.out.print("Prezo: ");
            double prezo = sc.nextDouble();
            System.out.print("Stock: ");
            int stock = sc.nextInt();
            sc.nextLine();
            System.out.print("Descrición: ");
            String descricion = sc.nextLine();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            System.out.println("Tipo de Saxofón (SOPRANO, ALTO, TENOR, BARITONO): ");
            String tipoInput = sc.nextLine().toUpperCase();
            TipoSaxofon tipo = TipoSaxofon.valueOf(tipoInput);

            Saxofon saxofon = new Saxofon(prezo, stock, descricion, marca, modelo, tipo);
            Tenda.getInstancia().engadirProduto(saxofon);
            System.out.println("Saxofón engadido correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de saxofón inválido.");
        } catch (Exception e) {
            System.out.println("Erro ao engadir saxofón: " + e.getMessage());
        }

    }

    private void engadirFrauta() {
        try {
            System.out.print("Prezo: ");
            double prezo = sc.nextDouble();
            System.out.print("Stock: ");
            int stock = sc.nextInt();
            sc.nextLine(); // limpar salto de liña
            System.out.print("Descrición: ");
            String descricion = sc.nextLine();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            System.out.print("¿Ten pé de Si? (s/N): ");
            String resposta = sc.nextLine();

            boolean peSI = false;
            if (resposta.equalsIgnoreCase("s")) {
                peSI = true;
            }

            Frauta frauta = new Frauta(prezo, stock, descricion, marca, modelo, peSI);
            Tenda.getInstancia().engadirProduto(frauta);
            System.out.println("Frauta engadida correctamente.");
        } catch (Exception e) {
            System.out.println("Erro ao engadir frauta: " + e.getMessage());
        }
    }

    private void engadirLibro() {
        try {
            System.out.print("Prezo: ");
            double prezo = sc.nextDouble();
            System.out.print("Stock: ");
            int stock = sc.nextInt();
            sc.nextLine();
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("Descrición: ");
            String descricion = sc.nextLine();
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            System.out.print("ISBN: ");
            String isbn = sc.nextLine();

            Libro libro = new Libro(prezo, stock, titulo, descricion, autor, isbn);
            Tenda.getInstancia().engadirProduto(libro);
            System.out.println("Libro engadido correctamente.");
        } catch (Exception e) {
            System.out.println("Erro ao engadir libro: " + e.getMessage());
        }
    }
}
