public class ExcepcionDNIInvalido extends Exception{
    
    public ExcepcionDNIInvalido(String message){
        super(message);
    }

    public static boolean comprobarDNI(String dni) {
        if (dni.length() != 9) {
            return false;
        }
        
        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);

        for( int i=0; i < numeros.length();i++){
            if (numeros.charAt(i) < '0' || numeros.charAt(i) > '9') {
                return false;
            }
        }

        if (!(letra >= 'A' && letra <= 'Z')) {
            return false;
        }
    

        // Collemos os numeros como un enteiro
        int numero = Integer.valueOf(numeros);

        // Calculamos o resto
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numero % letras.length();

        // Collemos a letra real
        char letraReal = letras.charAt(resto);

        // Se as letras son diferentes
        if (letra != letraReal) {
            return false;
        }
        return true;
    }
}
