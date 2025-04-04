public abstract class Piloto extends Deportista{
    private String equipo;

    

    public Piloto(String nomeCompleto, String nomePopular, String dataNac, String equipo) {
        super(nomeCompleto, nomePopular, dataNac);
        this.equipo = equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    abstract double getPuntos();

    @Override
    public String toString() {
        return super.toString() + ". Equipo: " + equipo + " - Puntos: " + (int)getPuntos();
    }
}
