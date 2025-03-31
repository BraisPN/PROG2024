public class Monitor extends Periferico{
    private double pulgadas;

    public Monitor(String marca, String modelo, double prezo, double pulgadas) {
        super(marca, modelo, prezo);
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "Monitor " + super.toString() + " con " + pulgadas + "pulgadas e conectores: " + getConectores();
    }
}
