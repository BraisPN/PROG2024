package Prueba;

import java.util.Scanner;

public class exer7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_x = scanner.nextInt();
        scanner.close();
        int num_y = num_x;
        int suma = 0;
        while (num_y != 0 ) {
            if (num_x % num_y == 0){
                suma += num_y;
            };
            num_y -= 1;
        }
        if (suma == (num_x + 1)) {
            System.out.println("Primo");
        }
        else{
            System.out.println("Non primo");
        }

    }
}
