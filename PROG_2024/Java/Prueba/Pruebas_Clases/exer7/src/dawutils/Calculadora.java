package dawutils;

public class Calculadora {
    
    private static double ultimoResultado;

    private static void sumar(double num1, double num2){

        Calculadora.ultimoResultado = num1 + num2;
    }  

    private static double multiplicar(double num1, double num2){
        Calculadora.ultimoResultado = num1 *num2;
        return Calculadora.ultimoResultado;
    }

    private static double potencia(int base, int exponente) {
    
        if (exponente == 0) {
            return 1;
        }
        else if (exponente < 0) {
            exponente = exponente * (-1);
            double aux = 1;
            for(int i = 1;i<=exponente;i++){
                aux = aux * base;
            } 
            return 1 / aux;
        }
        else {
            double aux = 1;
            for(int i = 1;i<=exponente;i++){
                aux = aux * base;
            } 
            return aux;
        }
    }

    private static double getMemoria(){
        return Calculadora.ultimoResultado;
    }

    
}
