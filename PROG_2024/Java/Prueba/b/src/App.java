import java.util.Optional;

public class App {
    public static void main(String[] args) throws Exception {

        /////////////// Test producto escalar
        int[][] vectores1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 1, 0, -1 },
                { 3, 3, 3, 3 }
        };
        int[][] vectores2 = {
                { 4, 5, 6 },
                { 1, 1, 1 },
                { -1, 0, 1 },
                { 2, 2, 2 }
        };

        for (int i = 0; i < vectores1.length; i++) {
            Optional<Integer> resultado = productoEscalar(vectores1[i], vectores2[i]);
            if (resultado.isPresent())
                System.out.println("O producto escalor dos vectores é " + resultado.get());
            else
                System.out.println("Non se pode calcular o producto escalar");
        }

        /////////////////// Test distancia dous puntos
        double[][] puntos1 = {
                { 1.0, 2.0 },
                { 3.0, 4.0 },
                { 0.0, 0.0 },
                { 1.0 }
        };
        double[][] puntos2 = {
                { 4.0, 6.0 },
                { 0.0, 0.0 },
                { 1.0, 1.0 },
                { 2.0, 3.0 }
        };

        for (int i = 0; i < puntos1.length; i++) {
            Optional<Double> resultado = distanciaEntreDousPuntos(puntos1[i], puntos2[i]);
            if (resultado.isPresent())
                System.out.println("A distancia entre dous puntos é: " + resultado.get());
            else
                System.out.println("Non se pode calcular a distancia entre estes dous puntos");
        }

        /////////////////// Test matriz identidade
        int[][][] matrices = {
                {
                        { 1, 0, 0 },
                        { 0, 1, 0 },
                        { 0, 0, 1 }
                },
                {
                        { 1, 0, 0 },
                        { 0, 1, 0 },
                        { 1, 0, 1 }
                },
                {
                        { 1, 0 },
                        { 0, 1 }
                },
                {
                        { 1, 0, 0 },
                        { 0, 2, 0 },
                        { 0, 0, 1 }
                },
                {
                        { 1, 0, 0 },
                        { 0, 1, 0 }
                }
        };

        for (int i = 0; i < matrices.length; i++) {
            boolean identidade = eMatrizIdentidade(matrices[i]);
            System.out.println("A matriz" + (identidade ? " é " : " non é ") +
                    "unha matriz identidade.");
        }

    }

    public static Optional<Integer> productoEscalar(int[] vector1, int[] vector2) {
        int producto = 0;
        if (vector1.length == vector2.length) {
            for (int i = 0; i < vector1.length; i++) {
                producto += vector1[i] * vector2[i];
            }
            return Optional.of(producto);
        }
        return Optional.empty();

    }

    public static Optional<Double> distanciaEntreDousPuntos(double[] vector1, double[] vector2) {
        double distancia = 0;
        if (vector1.length == 2 && vector2.length == 2) {
            distancia = Math.sqrt(((vector2[0] - vector1[0]) * (vector2[0] - vector1[0]))
                    + ((vector2[1] - vector1[1]) * (vector2[1] - vector1[1])));
            return Optional.of(distancia);
        }

        return Optional.empty();
    }

    public static boolean eMatrizIdentidade(int[][] matriz) {
    int filas = matriz.length;

    for (int i = 0; i < filas; i++) {
        if (matriz[i].length != filas) {
            return false;
        }
    }

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < filas; j++) {
            if (i == j && matriz[i][j] != 1) {
                return false;
            } else if (i != j && matriz[i][j] != 0) {
                return false;
            }
        }
    }

    return true;
}


}