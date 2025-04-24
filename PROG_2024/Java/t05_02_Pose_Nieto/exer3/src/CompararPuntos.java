import java.util.Comparator;

public class CompararPuntos implements Comparator<Piloto>{
    public int compare(Piloto ob1, Piloto ob2) {
        if (ob1.getPuntos() < ob2.getPuntos())
            return 1;
        else if (ob2.getPuntos() < ob1.getPuntos())
            return -1;
        return 0;
    }
}
