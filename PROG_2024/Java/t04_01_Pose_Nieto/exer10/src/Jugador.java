import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int valor;
    private Scanner scanner;


    public Jugador(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
        this.scanner = new Scanner(System.in);
    }


    public String getNombre() {
        return nombre;
    }


    public int getValor() {
        return valor;
    }


    public int seleccionarColumna() {
        System.out.print("Introduce la columna: ");
        return scanner.nextInt();
    }


    public int seleccionarFila() {
        System.out.print("Introduce la fila: ");
        return scanner.nextInt();
    }
}
