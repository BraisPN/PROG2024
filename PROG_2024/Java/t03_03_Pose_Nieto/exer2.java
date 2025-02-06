import java.util.Scanner;

public class exer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce o número de turistas no piso superior: ");
        int superior = scanner.nextInt();
        System.out.print("Introduce o número de turistas no piso inferior: ");
        int inferior = scanner.nextInt();
        int rango = calcularRango(superior, inferior);
        System.out.println("O rango do autobús é " + rango);
        scanner.close();
    }
    private static int calcularRango(int superior, int inferior) {
        int rango = 1;
        for (int d = 0; d <= superior + inferior; d++) {
            for (int s = 0; s <= d; s++) {
                int i = d - s;
                if (s == superior && i == inferior) {
                    return rango;
                }
                rango++;
            }
        }
        return 0;
    }
}
