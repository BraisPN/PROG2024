package Prueba;

import java.util.Scanner;

public class exer4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Segundos:");
        int tempoTotal = scanner.nextInt();
        scanner.close();
        
        int horas = tempoTotal / 3600; 
        int resto = tempoTotal % 3600; 
        int minutos = resto / 60; 
        int segundos = resto % 60;

        System.out.println(horas);
        System.out.println(minutos);
        System.out.println(segundos);
    
    }
}
