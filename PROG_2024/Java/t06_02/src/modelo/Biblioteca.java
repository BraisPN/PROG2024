package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modelo.libro.Exemplar;

public class Biblioteca implements Serializable {

    private int id;
    private String nome;
    private String direccion;
    private String cidade;
    private String provincia;
    private ArrayList<Exemplar> exemplares;

    /**
     * Construtor de biblioteca
     * @param nome
     * @param direccion
     * @param cidade
     * @param provincia
     */
    public Biblioteca(int id, String nome, String direccion, String cidade, String provincia) {
        this.id = id;
        this.direccion = direccion;
        this.cidade = cidade;
        this.provincia = provincia;
        this.exemplares = new ArrayList<>();
    }

    /**
     * Engade un exemplar a biblioteca
     * @param exemplar
     */
    public void engadirExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
        exemplar.asignarABiblioteca(this);
    }


    /**
     * Comproba se na biblioteca hai un exemplar cun determinado ID
     * @param id
     * @return
     */
    public boolean existeIdExemplar(int id){
        for (Exemplar e : this.exemplares) {
            if(e.getId() == id) return true;
        }
        return false;
    }

    /**
     * Devolve o exemplar por ID se é que existe
     * @param id
     * @return
     */
    public Optional<Exemplar> getExemplar(int id){
        for (Exemplar e : this.exemplares) {
            if(e.getId() == id) return Optional.of(e);
        }
        return Optional.empty();
    }

    /**
     * Devolve unha lista cos exemplares libres
     * @return
     */
    public List<Exemplar> getExemplaresLibres() {
        ArrayList<Exemplar> libres = new ArrayList<>();
        for (Exemplar e : this.exemplares) {
            if (!e.estaOcupado())
                libres.add(e);
        }
        return libres;
    }

    @Override
    public String toString() {
        return this.id + " " + this.nome + ", " + this.direccion + ";" + this.cidade + " (" + this.provincia + ")";
    }

    public int getId() {
        return id;
    }

}
