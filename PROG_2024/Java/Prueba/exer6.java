package Prueba;

import java.util.Scanner;

public class exer6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        switch (num) {
            case 1:
                System.out.println("luns");
                break;
            case 2:
                System.out.println("martes");
                break;
            case 3:
                System.out.println("mércores");
                break;
            case 4:
                System.out.println("xoves");
                break;
            case 5:
                System.out.println("venres");
                break;
            case 6:
                System.out.println("sabado");
                break;
            case 7:
                System.out.println("domingo");
                break;
            default:
                System.out.println("Fora de rango");;
                break;
        } 
    }
}