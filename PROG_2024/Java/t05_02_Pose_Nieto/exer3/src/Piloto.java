public abstract class Piloto extends Deportista {
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
        return super.toString() + ". Equipo: " + this.equipo + " - Puntos: " + (int)getPuntos();
    }

    @Override
    public int compareTo(Deportista o) {
        if (o instanceof Piloto) {
            Piloto p = (Piloto) o;
            return Double.compare(p.getPuntos(), this.getPuntos());
        }
        return 0;
    }
}
