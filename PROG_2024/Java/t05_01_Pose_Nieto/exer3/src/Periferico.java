import java.util.ArrayList;

public abstract class Periferico extends Produto{
    private ArrayList<Conector> conectores = new ArrayList<Conector>();

    public Periferico(String marca, String modelo, double prezo) {
        super(marca, modelo, prezo);
    }

    public void addConector(Conector conector){
        conectores.add(conector);
    }

    protected String getConectores() {
        String listaConectores = "";
        for(Conector c: conectores){
            listaConectores += c.name() + " ";
        }
        
        return listaConectores;
    }

    
    
}
