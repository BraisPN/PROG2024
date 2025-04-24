package Controller;


import Model.Musi;
import View.Vista;

public class Controlador {
    private static Vista vista;
    private static Musi tenda;

    public Controlador(Vista vista, Musi tenda){
        this.vista = vista;
        this.tenda = tenda;
    }
}
