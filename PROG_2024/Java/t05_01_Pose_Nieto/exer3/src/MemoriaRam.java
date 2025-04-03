public class MemoriaRam extends Componhente{
    private long memoriaBytes;
    private long velocidadeMemoriaHz;
    public MemoriaRam(String marca, String modelo, double prezo, double velocidadeMemoriaGz, double memoriaGB) {
                super(marca, modelo, prezo);
                this.velocidadeMemoriaHz = gigaHzToHz(velocidadeMemoriaGz);
                this.memoriaBytes = gigaBytesToBytes(memoriaGB);
           
    }
    public long getMemoriaGB() {
        return (long)bytesToGigaBytes(memoriaBytes);
    }
    public long getVelocidadeMemoriaMHz() {
        return (long)hzToMhz(velocidadeMemoriaHz);
    }

    @Override
    public String toString() {
        return "Memoria RAM " + super.toString() + " con " + this.getMemoriaGB() + " GB e velocidade " + this.getVelocidadeMemoriaMHz() + " MHz";
    }
}
