package Model;

import Model.Exceptions.ExcepcionPrezoNegativo;
import Model.Exceptions.ExcepcionStockNegativo;
import Utils.TipoSaxofon;

public class Saxofon extends Instrumento {
    private TipoSaxofon tipo;

    public Saxofon(double prezo, int stock, String descripcion, String marca, String modelo, TipoSaxofon tipo)
            throws ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        super(prezo, stock, descripcion, marca, modelo);
        setTipo(tipo);
    }

    public TipoSaxofon getTipo() {
        return tipo;
    }

    public void setTipo(TipoSaxofon tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ID: " + getIdProducto() + " -  Saxofón. " + getMarca() + ": " + getModelo() + " - Tipo: " + getTipo()
                + ". " + super.toString();
    }
}
