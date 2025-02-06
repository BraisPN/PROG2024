package Prueba;

import java.util.Scanner;

public class exer3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kilogramos comprados de mazas: ");
        double kg_mazas = scanner.nextDouble();
        System.out.println("Kilogramos comprados de naranxas: ");
        double kg_naranxas = scanner.nextDouble();
        scanner.close();

        double coste = (3.5 * kg_mazas) + (1.6 * kg_naranxas);
        System.out.println(coste);

        
    }
}
