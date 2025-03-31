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
        return marca + " " + modelo + ": " + prezo + "$";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (Double.doubleToLongBits(prezo) != Double.doubleToLongBits(other.prezo))
            return false;
        return true;
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
