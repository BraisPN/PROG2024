package Model;

import Model.Exceptions.ExcepcionPrezoNegativo;
import Model.Exceptions.ExcepcionStockNegativo;

public abstract class Producto {
    private static int contIdProducto = 0;
    private static double IVE = 0.21;

    private int idProducto;
    private double prezo;
    private double prezoConIVE;
    private int stock;
    private String descripcion;

    public Producto(double prezo, int stock, String descripcion) throws ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        setPrezo(prezo);
        setPrezoConIVE(prezo);
        setStock(stock);
        setDescripcion(descripcion);
        contIdProducto++;
        this.idProducto = contIdProducto;
    }

    public static double getIVE() {
        return IVE;
    }

    public static void setIVE(double iVE) {
        IVE = iVE;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) throws ExcepcionPrezoNegativo {
        if (prezo <= 0) {
            throw new ExcepcionPrezoNegativo("O prezo debe ser maior a 0");
        }
        this.prezo = prezo;
    }

    public double getPrezoConIVE() {
        return prezoConIVE;
    }

    public void setPrezoConIVE(double prezo) {
        this.prezoConIVE = prezo * (1 + IVE);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws ExcepcionStockNegativo {
        if (stock < 0) {
            throw new ExcepcionStockNegativo("O stock non pode ser menor a 0");
        }
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Prezo con IVE: " + getPrezoConIVE() + " €; Prezo sen IVE: " + getPrezo() + " €; Stock: " + getStock()
                + " unidades; Descripción: " + getDescripcion() + ".";
    }

    public static int getContIdProducto() {
        return contIdProducto;
    }
}
