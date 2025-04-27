package Model;

import Model.Exceptions.ExcepcionPrezoNegativo;
import Model.Exceptions.ExcepcionStockNegativo;
import Utils.TipoEstoxo;

public class Estoxo extends Complemento {
    private TipoEstoxo tipo;
    private String marca;

    public Estoxo(double prezo, int stock, String descripcion, TipoEstoxo tipo, String marca)
            throws ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        super(prezo, stock, descripcion);
        setTipo(tipo);
        setMarca(marca);
    }

    public TipoEstoxo getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstoxo tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "ID: " + getIdProducto() + " -  Estoxo. " + getTipo() + " - " + getMarca() + ". " + super.toString();
    }
}
