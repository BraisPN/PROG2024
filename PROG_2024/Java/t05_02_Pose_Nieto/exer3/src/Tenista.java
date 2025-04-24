public class Tenista extends Deportista {
    private Integer posicionRanking;

    public Tenista(String nomeCompleto, String nomePopular, String dataNac, int posicionRanking) {
        super(nomeCompleto, nomePopular, dataNac);
        this.posicionRanking = posicionRanking;
    }

    public Integer getPosicionRanking() {
        return posicionRanking;
    }

    public void setPosicionRanking(int posicionRanking) {
        this.posicionRanking = posicionRanking;
    }

    @Override
    public String toString() {
        return "Tenista: " + super.toString() + ". Nº " + this.posicionRanking + " do mundo.";
    }

    @Override
    public int compareTo(Deportista o) {
        Tenista t = (Tenista) o;
        return this.posicionRanking.compareTo(t.getPosicionRanking());
    }
}
