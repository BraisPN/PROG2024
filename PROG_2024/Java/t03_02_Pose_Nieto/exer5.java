import java.util.Scanner;

public class exer5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matriz[][] = new int[3][3];
        int xogador = 1;
        boolean ganador = false;

        while (ganador == false && tableroCheo(matriz) == false) {
            mostrarTablero(matriz);
            System.out.println("Xogador " + xogador + " introduzca a pocición");
            System.out.print("Fila(0-2): ");
            int fila = scanner.nextInt();
            System.out.print("Columna(0-2): ");
            int columna = scanner.nextInt();
            if (fila <= 2 && fila >= 0) {
                if (columna <= 2 && columna >= 0) {

                    if (matriz[fila][columna] == 0) {
                        matriz[fila][columna] = xogador;
                        ganador = comprobarGanador(matriz, xogador);
                        if (!ganador && xogador == 1) {
                            xogador = 2;
                        } 
                        else if(!ganador){
                            xogador = 1;
                        }
                    } else {
                        System.out.println("Posición xa ocupada");
                    }
                }
            } else {
                System.out.println("Error: Valores fora de rango");
            }
        }

        mostrarTablero(matriz);
        if (ganador) {
            System.out.println("O xogador " + xogador + " ganou!");
        } else {
            System.out.println("Empate!");
        }

        scanner.close();
    }

    private static void mostrarTablero(int[][] matriz) {
        for (int c = 0; c < 3; c++) {
            for (int f = 0; f < 3; f++) {
                if (matriz[c][f] == 0) {
                    System.out.print("- ");
                } else if (matriz[c][f] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    private static boolean comprobarGanador(int[][] matriz, int xogador) {
        for (int c = 0; c < 3; c++) {
            if ((matriz[c][0] == xogador && matriz[c][1] == xogador && matriz[c][2] == xogador) ||
                    (matriz[0][c] == xogador && matriz[1][c] == xogador && matriz[2][c] == xogador)) {
                return true;
            }
        }
        return (matriz[0][0] == xogador && matriz[1][1] == xogador && matriz[2][2] == xogador) ||
                (matriz[0][2] == xogador && matriz[1][1] == xogador && matriz[2][0] == xogador);
    }

    private static boolean tableroCheo(int[][] matriz) {
        for (int c = 0; c < 3; c++) {
            for (int f = 0; f < 3; f++) {
                if (matriz[c][f] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}