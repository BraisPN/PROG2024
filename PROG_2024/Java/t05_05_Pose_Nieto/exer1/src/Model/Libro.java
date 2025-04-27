package Model;

import Model.Exceptions.ExcepcionISBNIncorrecto;
import Model.Exceptions.ExcepcionPrezoNegativo;
import Model.Exceptions.ExcepcionStockNegativo;

public class Libro extends Complemento {
    private String titulo;
    private String autor;
    private String isbn;

    public Libro(double prezo, int stock, String descripcion, String titulo, String autor, String isbn)
            throws ExcepcionISBNIncorrecto, ExcepcionPrezoNegativo, ExcepcionStockNegativo {
        super(prezo, stock, descripcion);
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws ExcepcionISBNIncorrecto {
        if (!ExcepcionISBNIncorrecto.comprobarISBN(isbn)) {
            throw new ExcepcionISBNIncorrecto("O ISBN é incorrecto, recorda que deben ser 10 díxitos");
        }
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "ID: " + getIdProducto() + " -  Libro. " + getTitulo() + ": " + getAutor() + " - ISBN: " + getIsbn()
                + ". " + super.toString();
    }
}
