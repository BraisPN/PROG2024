public class Tablero {
    private int[][] tablero;
    private final int tam = 3;


    public Tablero() {
        tablero = new int[tam][tam];
    }


    public void imprimir() {
        for (int col = 0; col < tam; col++) {
            System.out.print("\tC" + col);
        }
        System.out.println();
        for (int fila = 0; fila < tam; fila++) {
            System.out.print("F" + fila);
            for (int col = 0; col < tam; col++) {
                switch (tablero[col][fila]) {
                    case 0:
                        System.out.print("\t-");
                        break;
                    case 1:
                        System.out.print("\tX");
                        break;
                    case 2:
                        System.out.print("\tO");
                        break;
                }
            }
            System.out.println();
        }
    }


    public boolean realizarMovimiento(int columna, int fila, int valor) {
        if (tablero[columna][fila] == 0) {
            tablero[columna][fila] = valor;
            return true;
        }
        return false;
    }


    public boolean comprobarGanador(int valor) {
        // Comprobamos filas, columnas y diagonales
        for (int i = 0; i < tam; i++) {
            if ((tablero[i][0] == valor && tablero[i][1] == valor && tablero[i][2] == valor) || // Filas
                (tablero[0][i] == valor && tablero[1][i] == valor && tablero[2][i] == valor)) { // Columnas
                return true;
            }
        }
        // Comprobación de diagonales
        if ((tablero[0][0] == valor && tablero[1][1] == valor && tablero[2][2] == valor) ||
            (tablero[0][2] == valor && tablero[1][1] == valor && tablero[2][0] == valor)) {
            return true;
        }
        return false;
    }


    public boolean estaLleno() {
        for (int col = 0; col < tam; col++) {
            for (int fila = 0; fila < tam; fila++) {
                if (tablero[col][fila] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}