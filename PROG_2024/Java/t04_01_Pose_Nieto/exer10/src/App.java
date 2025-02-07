import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }
}


// Nueva clase Juego
class Juego {
    private Tablero tablero;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private Jugador jugadorActual;


    public Juego() {
        tablero = new Tablero();
        jugadorA = new Jugador("A", 1);
        jugadorB = new Jugador("B", 2);
        jugadorActual = jugadorA;
    }


    public void iniciar() {
        while (true) {
            tablero.imprimir();
            int columnaSeleccionada = jugadorActual.seleccionarColumna();
            int filaSeleccionada = jugadorActual.seleccionarFila();


            if (tablero.realizarMovimiento(columnaSeleccionada, filaSeleccionada, jugadorActual.getValor())) {
                if (tablero.comprobarGanador(jugadorActual.getValor())) {
                    tablero.imprimir();
                    System.out.println("¡Gana el jugador " + jugadorActual.getNombre() + "!");
                    break;
                }
                if (tablero.estaLleno()) {
                    tablero.imprimir();
                    System.out.println("¡Empate!");
                    break;
                }
                cambiarTurno();
            } else {
                System.out.println("Movimiento inválido, intentalo de nuevo.");
            }
        }
    }


    private void cambiarTurno() {
        jugadorActual = (jugadorActual == jugadorA) ? jugadorB : jugadorA;
    }
}


// Nueva clase Tablero
class Tablero {
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


// Nueva clase Jugador
class Jugador {
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



