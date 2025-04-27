package Model;

import Model.Exceptions.ExcepcionPrezoNegativo;
import Model.Exceptions.ExcepcionStockNegativo;

public class Complemento extends Producto {

    public Complemento(double prezo, int stock, String descripcion)
            throws ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        super(prezo, stock, descripcion);
    }

}
