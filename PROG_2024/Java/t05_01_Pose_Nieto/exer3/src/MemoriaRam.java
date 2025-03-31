public class MemoriaRam extends Componhente{
    protected long memoriaBytes;
    protected long velocidadeMemoriaHz;
    public MemoriaRam(String marca, String modelo, double prezo, long memoriaBytes, long velocidadeMemoriaHz) {
        super(marca, modelo, prezo);
        this.memoriaBytes = memoriaBytes;
        this.velocidadeMemoriaHz = velocidadeMemoriaHz;
    }
    public long getMemoriaBytes() {
        return memoriaBytes;
    }
    public long getVelocidadeMemoriaHz() {
        return velocidadeMemoriaHz;
    }

    @Override
    public String toString() {
        return "Memoria RAM " + super.toString() + " con " + getMemoriaBytes() + "GB e velocidade " + getVelocidadeMemoriaHz() + "MHz";
    }
}
