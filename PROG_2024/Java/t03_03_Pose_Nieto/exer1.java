import java.util.Scanner;

public class exer1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Número: ");
        int numero = scanner.nextInt();

        if (numero == 6174) {
            System.out.println(0);
        } else if (Repdigit(numero)) {
            System.out.println(-1);
        } else if (numero >= 1000 && numero <= 9999) {
            int iteraciones = calcular_iter(numero);
            System.out.println(iteraciones);
        } else {
            System.out.println("ERROR: Introduce un número válido");
        }

        scanner.close();
    }

    private static int calcular_iter(int numero) {
        int iteraciones = 0;
        int restas = numero;

        while (restas != 6174 && iteraciones < 100) {
            int mayor = obtenerMayor(restas);
            int menor = reves_numero(mayor);
            restas = mayor - menor;
            iteraciones++;
        }
        return iteraciones;
    }

    private static boolean Repdigit(int numero) {
        int d1 = numero / 1000;
        int d2 = (numero / 100) % 10;
        int d3 = (numero / 10) % 10;
        int d4 = numero % 10;
        return (d1 == d2 && d1 == d3 && d1 == d4);
    }

    private static int reves_numero(int numero) {
        int i = 0;
        int novon = 0;
        while (i != 4) {
            int cifra = numero % 10;
            novon = novon * 10 + cifra;
            numero /= 10;
            i++;
        }

        return novon;
    }

    private static int obtenerMayor(int numero) {
        int dixitos[] = obterDixitos(numero);
        ordenarDescendente(dixitos);
        return convertirNumero(dixitos);
    }

    private static int[] obterDixitos(int numero) {
        int dixitos[] = new int[4];
        for (int i = 0; i < 4; i++) {
            dixitos[i] = numero % 10;
            numero /= 10;
        }
        return dixitos;
    }

    private static void ordenarDescendente(int dixitos[]) {
        for (int i = 0; i < dixitos.length - 1; i++) {
            for (int j = i + 1; j < dixitos.length; j++) {
                if (dixitos[i] < dixitos[j]) {
                    int temp = dixitos[i];
                    dixitos[i] = dixitos[j];
                    dixitos[j] = temp;
                }
            }
        }
    }

    private static int convertirNumero(int dixitos[]) {
        int numero = 0;
        for (int digito : dixitos) {
            numero = numero * 10 + digito;
        }
        return numero;
    }
}
