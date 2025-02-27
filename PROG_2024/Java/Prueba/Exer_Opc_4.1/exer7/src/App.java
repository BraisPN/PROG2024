import dawutils.Calculadora;

public class App {
    public static void main(String[] args) throws Exception {
        Calculadora.sumar(6,7);
        System.out.println((int) Calculadora.getMemoria());
        Calculadora.multiplicar(Calculadora.getMemoria(), 5);
        System.out.println((int)Calculadora.getMemoria());
        Calculadora.potencia(6, 5);
        System.out.println((int)Calculadora.getMemoria());

    }
}
