package Model;

import Model.Exceptions.ExcepcionPrezoNegativo;
import Model.Exceptions.ExcepcionStockNegativo;
import Utils.TipoSaxofon;

public class Trombon extends Instrumento{
    private boolean transpositor;
    public Trombon(double prezo, int stock, String descripcion, String marca, String modelo, TipoSaxofon tipo) throws ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        super(prezo, stock, descripcion, marca, modelo);
        setTranspositor(transpositor);
    }
    public boolean isTranspositor() {
        return transpositor;
    }
    public void setTranspositor(boolean transpositor) {
        this.transpositor = transpositor;
    }

    public String getTranspositor(boolean transpositor){
        return transpositor ? "Si" : "No";
    }
    
    @Override
    public String toString() {
        return "Trombón. " + getMarca() + ": " + getModelo() + " - Transpositor: " + getTranspositor(transpositor)  + ". " + super.toString();
    }
}
