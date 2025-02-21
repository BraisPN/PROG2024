package Exer6.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Long>> empregados = new HashMap<>();
        empregados.put("12345678A", new ArrayList<>());
        empregados.put("87654321B", new ArrayList<>());

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("Menú:");
            System.out.println("1. Fichar entrada/saída");
            System.out.println("2. Comprobar salario");
            System.out.println("3. Saír");
            System.out.print("Elixe unha opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Introduce o teu DNI: ");
                String dni = scanner.next();
                ArrayList<Long> fichaxes = empregados.get(dni);

                if (fichaxes != null) {
                    long horaActual = System.currentTimeMillis();
                    fichaxes.add(horaActual);
                    System.out.println("Fichaxe rexistrada correctamente.");
                } else {
                    System.out.println("DNI non atopado.");
                }
            } else if (opcion == 2) {
                System.out.print("Introduce o teu DNI: ");
                String dni = scanner.next();
                ArrayList<Long> fichaxes = empregados.get(dni);

                if (fichaxes != null) {
                    double salario = 0;
                    for (int i = 0; i < fichaxes.size() - 1; i += 2) {
                        long entrada = fichaxes.get(i);
                        long saida = fichaxes.get(i + 1);
                        long minutosTraballados = (saida - entrada) / (1000 * 60);
                        salario += (minutosTraballados / 60.0) * 12; 
                    }
                    System.out.printf("Salario a percibir:  %.2f%n", salario);
                } else {
                    System.out.println("DNI non atopado.");
                }
            } else if (opcion == 3) {
                System.out.println("------> Saíndo do programa.");
            } else {
                System.out.println("Opción non válida.");
            }
        }

        scanner.close();
    }
}
