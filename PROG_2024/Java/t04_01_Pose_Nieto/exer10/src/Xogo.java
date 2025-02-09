public class Xogo {
    private Taboleiro taboleiro;
    private Xogador xogadorA;
    private Xogador xogadorB;
    private Xogador xogadorActual;

    public Xogo() {
        taboleiro = new Taboleiro();
        xogadorA = new Xogador("A", 1);
        xogadorB = new Xogador("B", 2);
        xogadorActual = xogadorA;
    }

    public void iniciar() {
        while (true) {
            taboleiro.imprimir();
            int columnaSeleccionada = xogadorActual.seleccionarColumna();
            int filaSeleccionada = xogadorActual.seleccionarFila();

            if (taboleiro.realizarMovemento(columnaSeleccionada, filaSeleccionada, xogadorActual.getValor())) {
                if (taboleiro.comprobarGañador(xogadorActual.getValor())) {
                    taboleiro.imprimir();
                    System.out.println("¡Gaña o xogador " + xogadorActual.getNome() + "!");
                    break;
                }
                if (taboleiro.estaCheo()) {
                    taboleiro.imprimir();
                    System.out.println("¡Empate!");
                    break;
                }
                cambiarQuenda();
            } else {
                System.out.println("Movemento inválido, inténtao de novo.");
            }
        }
    }

    private void cambiarQuenda() {
        xogadorActual = (xogadorActual == xogadorA) ? xogadorB : xogadorA;
    }
}
