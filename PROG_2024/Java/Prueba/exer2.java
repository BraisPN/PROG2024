package Prueba;

import java.util.Scanner;

public class exer2 {
    /*
     * Exercicio 2. Pide por pantalla a idade dunha persoa e mostra por pantalla o ano no que naceu. 
     * Considera o ano actual 2025.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("La edad de Nacho será: ");
        int idade = scanner.nextInt();   
        scanner.close();

        int ano = 2025 - idade;

        System.out.println(ano);
    }

}
