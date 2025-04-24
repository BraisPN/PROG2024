package Model;

import Model.Exceptions.ExcepcionPrezoNegativo;
import Model.Exceptions.ExcepcionStockNegativo;
import Utils.TipoSaxofon;

public class Frauta extends Instrumento {
    private boolean peSi;

    public Frauta(double prezo, int stock, String descripcion, String marca, String modelo, TipoSaxofon tipo) throws ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        super(prezo, stock, descripcion, marca, modelo);
        setPeSi(peSi);
    }

    public boolean isPeSi() {
        return peSi;
    }

    public void setPeSi(boolean peSi) {
        this.peSi = peSi;
    }

    public String getPeSI(boolean peSi){
        return peSi ? "Si" : "No";
    }

    @Override
    public String toString() {
        return "Frauta. " + getMarca() + ": " + getModelo() + " - Pé de Si: " + getPeSI(peSi) + ". " + super.toString();
    }
}
