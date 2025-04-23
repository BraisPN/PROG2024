public class Factura {
    private static int numFactura = 0;

    private int numero;
    private String dni;
    private double cantidade;
    

    public Factura(String dni, double cantidade) throws ExcepcionDNIInvalido, ExcepcionNumeroNegativo{
        this.numero = numFactura;
        numFactura++;
        setDni(dni);
        setCantidade(cantidade);
        
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws ExcepcionDNIInvalido {
        if (ExcepcionDNIInvalido.comprobarDNI(dni)) {
            this.dni = dni;
        } else {
            throw new ExcepcionDNIInvalido("O DNI é inválido");
        }
    }

    public double getCantidade() {
        return cantidade;
    }

    public void setCantidade(double cantidade) throws ExcepcionNumeroNegativo {
        if (cantidade < 0) {
            throw new ExcepcionNumeroNegativo("A cantidade non pode ser negativa");
        } else {
            this.cantidade = cantidade;
        }

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return this.numero + ": " + this.dni + " -> " + this.cantidade + " €";
    }
}
