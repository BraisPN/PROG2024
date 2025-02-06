import java.util.Scanner;

public class exer4 {
    public static void main(String[] args) throws Exception {
        // Inicializamos a entrada de datos
        Scanner scanner = new Scanner(System.in);

        // Pedimos o numero de estudiantes
        System.out.print("Indica o número de estudiantes: ");
        int estudiantes = scanner.nextInt();

        // Pedimos o numero de modulos
        System.out.print("Indica o número de modulos: ");
        int modulos = scanner.nextInt();

        // Inicializamos a matriz
        int[][] matriz = new int[estudiantes][modulos];

        for (int e = 0; e < matriz.length; e++) {
            for (int m = 0; m < modulos; m++) {
                System.out.print("Introduce a nota do estudiante " + e + " no modulo " + m + " : ");
                matriz[e][m] = scanner.nextInt();
            }
        }

        String opcion;
        scanner.nextLine();

        do {
            System.out.println("a) Media dun alumno/a");
            System.out.println("b) Porcentaxe de aprobados");
            System.out.println("c) Salir");
            System.out.print("Selecciona unha opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "a":
                    System.out.print("Introduce o número do alumno para calcular a media: ");
                    int alumno = scanner.nextInt();
                    scanner.nextLine();
                    if (alumno < estudiantes && alumno >= 0) {
                        int suma = 0;
                        for (int m = 0; m < matriz[alumno].length; m++) {
                            suma += matriz[alumno][m];
                        }
                        int media = suma / modulos;
                        System.out.println("Media: " + media);
                    }
                    else{
                        System.out.println("Introduzca un valor válido");
                    }
                    break;
                case "b":
                    System.out.print("Introduce o módulo para calcular o porcentaxe de aprobados: ");
                    int modulo = scanner.nextInt();
                    scanner.nextLine();
                    if (modulo < modulos && modulo >= 0) {
                        int aprobados = 0;
                        for (int e = 0; e < estudiantes; e++) {
                            if (matriz[e][modulo] >= 5) {
                                aprobados++;
                            }
                        }
                        double porcentaje = (aprobados * 100.0) / estudiantes;
                        System.out.println("Porcentaxe de aprobados :" + porcentaje + "%");   
                    }
                    else{
                        System.out.print("Error: Introduzca un valor válido");
                    }
                    break;
                case "c":
                    System.out.println("------> Saíndo");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de novo.");
            }

            System.out.println();
        } while (!opcion.equals("c"));

        scanner.close();
    }
}
