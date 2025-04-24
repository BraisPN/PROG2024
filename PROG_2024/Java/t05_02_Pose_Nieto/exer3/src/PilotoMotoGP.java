public class PilotoMotoGP extends Piloto {
    private int puntosTotais;

    public PilotoMotoGP(String nomeCompleto, String nomePopular, String dataNac, String equipo, int puntosTotais) {
        super(nomeCompleto, nomePopular, dataNac, equipo);
        this.puntosTotais = puntosTotais;
    }

    public double getPuntos() {
        return puntosTotais;
    }

  

}
