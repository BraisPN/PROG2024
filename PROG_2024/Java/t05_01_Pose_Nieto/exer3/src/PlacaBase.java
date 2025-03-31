public class PlacaBase extends Componhente{
    private Zocalo zocalo;

    public PlacaBase(String marca, String modelo, double prezo, Zocalo zocalo) {
        super(marca, modelo, prezo);
        this.zocalo = zocalo;
    }

    @Override
    public String toString() {
        return "Placa Base " + super.toString() + " con socket " + zocalo;
    }
}
