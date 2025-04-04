public class Tenista extends Deportista{
    private int posicionRanking;
    
    public Tenista(String nomeCompleto, String nomePopular, String dataNac, int posicionRanking) {
        super(nomeCompleto, nomePopular, dataNac);
        this.posicionRanking = posicionRanking;
    }

    public int getPosicionRanking() {
        return posicionRanking;
    }

    public void setPosicionRanking(int posicionRanking) {
        this.posicionRanking = posicionRanking;
    }

    @Override
    public String toString() {
        return "Tenista: " + super.toString() + ". Nº " + posicionRanking + " do mundo.";
    }

    
}
