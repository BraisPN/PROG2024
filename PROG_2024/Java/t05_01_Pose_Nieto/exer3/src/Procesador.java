public class Procesador extends Componhente{
    private Zocalo zocalo;
    private int numeroCores;
    
    public Procesador(String marca, String modelo, double prezo, Zocalo zocalo, int numeroCores) {
        super(marca, modelo, prezo);
        this.zocalo = zocalo;
        this.numeroCores = numeroCores;
    }

    @Override
    public String toString() {
        return "Procesador " + super.toString() + " con " + numeroCores + " e socket " + zocalo;
    }
}
