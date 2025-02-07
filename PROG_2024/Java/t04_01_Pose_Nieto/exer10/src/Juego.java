public class Juego {
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