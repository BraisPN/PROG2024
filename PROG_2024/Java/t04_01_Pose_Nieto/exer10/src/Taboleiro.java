public class Taboleiro {
    private int[][] taboleiro;
    private final int tam = 3;

    public Taboleiro() {
        taboleiro = new int[tam][tam];
    }

    public void imprimir() {
        for (int col = 0; col < tam; col++) {
            System.out.print("C" + col);
        }
        System.out.println();
        for (int fila = 0; fila < tam; fila++) {
            System.out.print("F" + fila);
            for (int col = 0; col < tam; col++) {
                switch (taboleiro[col][fila]) {
                    case 0:
                        System.out.print("-");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case 2:
                        System.out.print("O");
                        break;
                }
            }
            System.out.println();
        }
    }

    public boolean realizarMovemento(int columna, int fila, int valor) {
        if (taboleiro[columna][fila] == 0) {
            taboleiro[columna][fila] = valor;
            return true;
        }
        return false;
    }

    public boolean comprobarGañador(int valor) {
        // Comprobamos filas, columnas e diagonais
        for (int i = 0; i < tam; i++) {
            if ((taboleiro[i][0] == valor && taboleiro[i][1] == valor && taboleiro[i][2] == valor) || // Filas
                (taboleiro[0][i] == valor && taboleiro[1][i] == valor && taboleiro[2][i] == valor)) { // Columnas
                return true;
            }
        }
        // Comprobación de diagonais
        if ((taboleiro[0][0] == valor && taboleiro[1][1] == valor && taboleiro[2][2] == valor) ||
            (taboleiro[0][2] == valor && taboleiro[1][1] == valor && taboleiro[2][0] == valor)) {
            return true;
        }
        return false;
    }

    public boolean estaCheo() {
        for (int col = 0; col < tam; col++) {
            for (int fila = 0; fila < tam; fila++) {
                if (taboleiro[col][fila] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
