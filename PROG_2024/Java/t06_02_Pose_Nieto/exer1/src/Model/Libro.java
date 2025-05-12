package Model;

import java.util.ArrayList;

import Model.Utils.LinguaLibro;

public class Libro {
    private String titulo;
    private ArrayList<String> autores = new ArrayList<>();
    private String editorial;
    private String isbn;
    private LinguaLibro lingua;

    public Libro(String titulo, ArrayList<String> autores, String editorial, String isbn, LinguaLibro lingua) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.isbn = isbn;
        this.lingua = lingua;
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LinguaLibro getLingua() {
        return lingua;
    }

    public void setLingua(LinguaLibro lingua) {
        this.lingua = lingua;
    }

}
