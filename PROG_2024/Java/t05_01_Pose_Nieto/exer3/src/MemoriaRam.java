public class MemoriaRam extends Componhente{
    private long memoriaBytes;
    private long velocidadeMemoriaHz;
    public MemoriaRam(String marca, String modelo, double prezo, double velocidadeMemoriaGz, double memoriaGB, long memoriaBytes, long velocidadeMemoriaHz) {
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
        return "Memoria RAM " + super.toString() + " con " + bytesToGigaBytes(getMemoriaBytes()) + " GB e velocidade " + hzToMhz(getVelocidadeMemoriaHz()) + " MHz";
    }
}
