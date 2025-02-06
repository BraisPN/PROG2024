package Prueba;

import java.util.Scanner;

public class exer8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        int raiz = 0;

        while ((raiz) * (raiz) <= num) {
            raiz++;
        }

        System.out.println(raiz - 1);
        
    }

}
