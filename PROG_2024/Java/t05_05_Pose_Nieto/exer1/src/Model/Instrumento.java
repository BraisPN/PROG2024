package Model;

import Model.Exceptions.ExcepcionPrezoNegativo;
import Model.Exceptions.ExcepcionStockNegativo;

public abstract class Instrumento extends Producto {
    private String marca;
    private String modelo;

    public Instrumento(double prezo, int stock, String descripcion, String marca, String modelo)
            throws ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        super(prezo, stock, descripcion);
        setMarca(marca);
        setModelo(modelo);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
