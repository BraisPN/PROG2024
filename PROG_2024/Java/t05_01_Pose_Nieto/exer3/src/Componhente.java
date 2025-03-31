public abstract class Componhente extends Produto{

    public Componhente(String marca, String modelo, double prezo) {
        super(marca, modelo, prezo);
    }
    
    public double bytesToGigaBytes(long bytes){
        return bytes / 1000000000;
    }

    public long gigaBytesToBytes(double gigaBytes){
        return (long)(gigaBytes * 1000000000);
    }

    public double hzToMhz(long hz){
        return hz / 1000000;
    }

    public long gigaHzToHz(double ghz){
        return (long)(ghz * 1000000);
    }
}
