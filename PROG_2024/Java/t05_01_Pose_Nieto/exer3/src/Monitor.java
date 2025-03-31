public class Monitor extends Periferico{
    protected double pulgadas;

    public Monitor(String marca, String modelo, double prezo, double pulgadas) {
        super(marca, modelo, prezo);
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
