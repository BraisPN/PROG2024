package Model;

import Model.Exceptions.ExcepcionPrezoNegativo;
import Model.Exceptions.ExcepcionStockNegativo;

public class Trombon extends Instrumento {
    private boolean transpositor;

    public Trombon(double prezo, int stock, String descripcion, String marca, String modelo, boolean transpositor)
            throws ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        super(prezo, stock, descripcion, marca, modelo);
        this.transpositor = transpositor;
    }

    public boolean isTranspositor() {
        return transpositor;
    }

    public void setTranspositor(boolean transpositor) {
        this.transpositor = transpositor;
    }

    public String getTranspositor() {
        return transpositor ? "Si" : "Non";
    }

    @Override
    public String toString() {
        return "ID: " + getIdProducto() + " -  Trombón. " + getMarca() + ": " + getModelo() + " - Transpositor: "
                + getTranspositor() + ". " + super.toString();
    }
}
