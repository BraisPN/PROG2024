import java.util.ArrayList;

public abstract class Periferico extends Produto{
    protected ArrayList<Conector> conectores;

    public Periferico(String marca, String modelo, double prezo) {
        super(marca, modelo, prezo);
    }

    public void addConector(Conector conector){
        conectores.add(conector);
    }

    public ArrayList<Conector> getConectores() {
        return conectores;
    }

    
    
}
