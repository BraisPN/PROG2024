import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String opcion = "";

        while(!(opcion.equals("d"))) {
            
            System.out.println("++++-Menú-++++");
            System.out.println("a) Engadir pregunta");
            System.out.println("b) Responder cuestionario");
            System.out.println("c) Mostrar resultados");
            System.out.println("d) Saír");
            
            opcion = sc.nextLine();

            switch (opcion) {
                case "a":
                    System.out.print("Pregunta: ");
                    String pregunta = sc.nextLine();
                    
                    engadirPregunta(pregunta);
                    break;
                case "b":
                    System.out.println("Opcion b");
                    break;
                case "c":
                    System.out.println("Opción c");
                    break;
                case "d":
                    System.out.println("-------> Saíndo");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        
        sc.close();
    }
}
