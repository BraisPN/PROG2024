import java.util.Comparator;

public abstract class Piloto extends Deportista implements Comparator<Piloto>{
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
        return super.toString() + ". Equipo: " + equipo + " - Puntos: " + (int) getPuntos();
    }
    @Override
    public int compare(Piloto ob1, Piloto ob2) {
        if (ob1.getPuntos() < ob2.getPuntos())
            return 1;
        else if (ob2.getPuntos() < ob1.getPuntos())
            return -1;
        return 0;
    }

}
