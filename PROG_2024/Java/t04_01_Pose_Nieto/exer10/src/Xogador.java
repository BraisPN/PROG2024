import java.util.Scanner;

public class Xogador {
    private String nome;
    private int valor;
    private Scanner scanner;

    public Xogador(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
        this.scanner = new Scanner(System.in);
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }

    public int seleccionarColumna() {
        System.out.print("Introduce a columna: ");
        return scanner.nextInt();
    }

    public int seleccionarFila() {
        System.out.print("Introduce a fila: ");
        return scanner.nextInt();
    }
}
