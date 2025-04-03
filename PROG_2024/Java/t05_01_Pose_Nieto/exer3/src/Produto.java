public abstract class Produto {
    protected String marca;
    protected String modelo;
    protected double prezo;
    
    public Produto(String marca, String modelo, double prezo) {
        this.marca = marca;
        this.modelo = modelo;
        this.prezo = prezo;
    }

    
    @Override
    public String toString() {
        return marca + " " + modelo + ": " + prezo + "€";
    }

    @Override
    public boolean equals(Object obj) {
        Produto other = (Produto) obj;
        if (this.marca.equals(other.getMarca()) && this.modelo.equals(other.modelo)) {
            return true;
        }
        return false;
    }


    // Getters & Setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrezo() {
        return prezo;
    }


    
}
