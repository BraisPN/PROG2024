package modelo.libro;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Biblioteca;
import modelo.Prestamo;
import modelo.usuarios.Lector;

public class Exemplar implements Serializable {

    private Libro libro;
    private boolean asignadoBiblioteca;
    private Biblioteca biblioteca;
    private int id;
    private ArrayList<Prestamo> prestamos;

    /**
     * Construtor de libro
     * Poñemolo así para que so se poida chamar dende dentro do paquete
     * @param libro
     */
    Exemplar(Libro libro, int id) {
        this.libro = libro;
        this.id = id;
        this.asignadoBiblioteca = false;
        this.biblioteca = null;
        this.prestamos = new ArrayList<>();
    }

    /**
     * Engade un prestamo ao exemplar
     * 
     * @param prestamo
     */
    public void addPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    /**
     * Asgina o libro a unha biblioteca
     * 
     * @param biblioteca
     */
    public void asignarABiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.asignadoBiblioteca = true;
    }

    /**
     * Esta o libro asginado a unha biblioteca
     * 
     * @return
     */
    public boolean estaAsignadoBiblioteca() {
        return this.asignadoBiblioteca;
    }

    /**
     * Esta ocupado o libro
     * 
     * @return
     */
    public boolean estaOcupado() {
        for (Prestamo p : this.prestamos) {
            if (!p.devolto())
                return true;
        }
        return false;
    }

    /**
     * Esta o libro ocupado por un determinado lector
     * 
     * @param user
     * @return
     */
    public boolean estaOcupadoPor(Lector user) {
        for (Prestamo p : this.prestamos) {
            if (!p.devolto()) {
                if (p.getUsuario().equals(user))
                    return true;
                return false;
            }

        }
        return false;
    }

    @Override
    public String toString() {
        return this.libro + ". ID Exemplar: " + this.getId();
    }

    public int getId() {
        String idNovo = this.libro.getIsbn() + this.id;
        int isbnInt = Integer.valueOf(idNovo);
        return isbnInt;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

}
