package Model;

import java.util.ArrayList;

import Model.Excepcions.ExcepcionISBNIncorrecto;
import Model.Excepcions.ExcepcionLinguaLibro;
import Model.Utils.LinguaLibro;

public class Libro {
    private String titulo;
    private ArrayList<String> autores = new ArrayList<>();
    private String editorial;
    private String isbn;
    private LinguaLibro lingua;

    public Libro(String titulo, ArrayList<String> autores, String editorial, String isbn, int lingua)
            throws ExcepcionLinguaLibro, ExcepcionISBNIncorrecto {
        setTitulo(titulo);
        setAutores(autores);
        setEditorial(editorial);
        setIsbn(isbn);
        setLingua(lingua);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        String textoAutores = "";
        boolean primeiro = true;
        for (String a : autores) {
            if (!primeiro) {
                textoAutores += "; ";
            }
            textoAutores += a;
            primeiro = false;
        }
        return textoAutores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws ExcepcionISBNIncorrecto{
        if (!ExcepcionISBNIncorrecto.comprobarISBN(isbn)) {
            throw new ExcepcionISBNIncorrecto("Error: ISBN Incorrecto");
        }
        this.isbn = isbn;
    }

    public LinguaLibro getLingua() {
        return lingua;
    }

    public void setLingua(int lingua) throws ExcepcionLinguaLibro {
        if (!(lingua <= 3 && lingua >= 0)) {
            throw new ExcepcionLinguaLibro("Error: Non se puido establecer a lingua");
        }
        if (lingua == 1) {
            this.lingua = LinguaLibro.CASTELAN;
        } else if (lingua == 2) {
            this.lingua = LinguaLibro.GALEGO;
        } else {
            this.lingua = LinguaLibro.INGLES;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Libro l = (Libro) obj;
        if (this.getIsbn().equals(l.getIsbn())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getIsbn() + ", " + getTitulo() + " de " + getAutores() + " en" + getLingua() + " (" + getEditorial() + ")";
    }
}
