package dawutils;

public class Calculadora {
    
    private static double ultimoResultado;

    public static void sumar(double num1, double num2){

        Calculadora.ultimoResultado = num1 + num2;
    }  

    public static double multiplicar(double num1, double num2){
        Calculadora.ultimoResultado = num1 *num2;
        return Calculadora.ultimoResultado;
    }

    public static double potencia(int base, int exponente){
    
        if (exponente == 0) {
            Calculadora.ultimoResultado = 1;
        }
        else if (exponente < 0) {
            exponente = exponente * (-1);
            double aux = 1;
            for(int i = 1;i<=exponente;i++){
                aux = aux * base;
            } 
            Calculadora.ultimoResultado = 1 / aux;
        }
        else {
            double aux = 1;
            for(int i = 1;i<=exponente;i++){
                aux = aux * base;
            } 
            Calculadora.ultimoResultado = aux;
        }
        return Calculadora.ultimoResultado;
    }

    public static double getMemoria(){
        return Calculadora.ultimoResultado;
    }

    
}
