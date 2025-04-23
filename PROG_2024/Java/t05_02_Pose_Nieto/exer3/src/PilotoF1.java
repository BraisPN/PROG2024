public class PilotoF1 extends Piloto{
    private int victoriasTotais;
    private int voltasRapidas;
    private int poles;
    
    public PilotoF1(String nomeCompleto, String nomePopular, String dataNac, String equipo, int victoriasTotais,
            int voltasRapidas, int poles) {
        super(nomeCompleto, nomePopular, dataNac, equipo);
        this.victoriasTotais = victoriasTotais;
        this.voltasRapidas = voltasRapidas;
        this.poles = poles;
    }
    public int getVictoriasTotais() {
        return victoriasTotais;
    }
    public void setVictoriasTotais(int victoriasTotais) {
        this.victoriasTotais = victoriasTotais;
    }
    public int getVoltasRapidas() {
        return voltasRapidas;
    }
    public void setVoltasRapidas(int voltasRapidas) {
        this.voltasRapidas = voltasRapidas;
    }
    public int getPoles() {
        return poles;
    }
    public void setPoles(int poles) {
        this.poles = poles;
    }

    public double getPuntos(){
        return (victoriasTotais * 25) + (voltasRapidas * voltasRapidas) + (poles * 5);
    }
    
}