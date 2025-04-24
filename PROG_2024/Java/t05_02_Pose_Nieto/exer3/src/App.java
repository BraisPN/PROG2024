import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
        ArrayList<Tenista> tenistas = new ArrayList<Tenista>();
        ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
        ArrayList<PilotoF1> pilotosF1 = new ArrayList<PilotoF1>();
        ArrayList<PilotoMotoGP> pilotosMotoGP = new ArrayList<PilotoMotoGP>();

        Tenista alcaraz = new Tenista("Carlos Jonás Alcaraz", "Carlos Alcaraz", "23/05/2003", 3);
        deportistas.add(alcaraz);
        tenistas.add(alcaraz);
        Tenista novak = new Tenista("Novak Djokovic", "Djokovic", "22/05/1987", 2);
        deportistas.add(novak);
        tenistas.add(novak);

        PilotoF1 alonso = new PilotoF1("Fernando Alonso Díaz", "Fernando Alonso", "29/07/1981", "Aston Martin", 33, 26,
                22);
        deportistas.add(alonso);
        pilotos.add(alonso);
        pilotosF1.add(alonso);

        PilotoF1 max = new PilotoF1("Max Emilian Verstappen", "Verstappen", "30/09/1997", "Red Bull Racing", 62, 33,
                40);
        deportistas.add(max);
        pilotos.add(max);
        pilotosF1.add(max);

        PilotoMotoGP marquez = new PilotoMotoGP("Marc Márquez Alentà", "Marc Márquez", "17/02/1993", "Grenesi Racing",
                102);
        deportistas.add(marquez);
        pilotos.add(marquez);
        pilotosMotoGP.add(marquez);

        PilotoMotoGP bagnaia = new PilotoMotoGP("Francesco Bagnaia", "Bagnaia", "14/01/1997", "Ducati Lenovo Team",
                461);
        deportistas.add(bagnaia);
        pilotos.add(bagnaia);
        pilotosMotoGP.add(bagnaia);

        Collections.sort(deportistas);
        for (Deportista elemento : deportistas) {
            System.out.println(elemento);
        }
        System.out.println("-----------");
        
        CompararPuntos comparador = new CompararPuntos();
        Collections.sort(pilotos, comparador);
        for (Piloto elemento : pilotos) {
            System.out.println(elemento);
        }
        System.out.println("-----------");

        Collections.sort(tenistas, new Comparator<Tenista>() {
            public int compare(Tenista ob1, Tenista ob2) {
                return ob1.getPosicionRanking() - (ob2.getPosicionRanking());
            }
        });
        for (Tenista elemento : tenistas) {
            System.out.println(elemento);
        }
        System.out.println("-----------");

        Collections.sort(pilotosF1, comparador);
        for (PilotoF1 elemento : pilotosF1) {
            System.out.println(elemento);
        }
        System.out.println("-----------");

        Collections.sort(pilotosMotoGP, new Comparator<PilotoMotoGP>() {
            public int compare(PilotoMotoGP ob1, PilotoMotoGP ob2) {
                if (ob1.getPuntos() < ob2.getPuntos())
                    return 1;
                else if (ob2.getPuntos() < ob1.getPuntos())
                    return -1;
                return 0;
            }
        });
        Collections.reverse(pilotosMotoGP);
        for (PilotoMotoGP elemento : pilotosMotoGP) {
            System.out.println(elemento);
        }

    }
}
