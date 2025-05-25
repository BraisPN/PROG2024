package modelo.libro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import modelo.Lingua;
import modelo.excepcions.ISBNIncorrectoException;

public class Libro implements Comparable<Libro>, Serializable {

    private String titulo;
    private ArrayList<String> autores;
    private String editorial;
    private String isbn;
    private Lingua lingua;
    private ArrayList<Exemplar> exemplares;
    private int idSeguinteExemplar;

    /**
     * Creamos un libro
     * 
     * @param titulo
     * @param editorial
     * @param isbn
     * @param lingua
     * @param numeroExemplares
     * @throws ISBNIncorrectoException
     */
    public Libro(String titulo, String editorial, String isbn, Lingua lingua, int numeroExemplares)
            throws ISBNIncorrectoException {
        if (!Libro.comprobarISBN(isbn))
            throw new ISBNIncorrectoException();
        this.titulo = titulo;
        this.editorial = editorial;
        this.autores = new ArrayList<>();
        this.isbn = isbn;
        this.lingua = lingua;
        this.exemplares = new ArrayList<>();
        this.idSeguinteExemplar = 0;
        this.crearExemplares(numeroExemplares);
    }

    /**
     * Engadimos un autor ao libro
     * 
     * @param autor
     */
    public void addAutor(String autor) {
        this.autores.add(autor);
    }

    /**
     * Crea os exemplares
     * 
     * @param numeroExemplares
     */
    private void crearExemplares(int numeroExemplares) {
        for (int i = 0; i < numeroExemplares; i++) {
            this.crearExemplar();
        }
    }

    /**
     * Crea un novo exemplar
     */
    public void crearExemplar() {
        // para coller o Id do exemplar, collemos o número de exemplares e sumamos 1
        this.exemplares.add(new Exemplar(this, this.idSeguinteExemplar++));
    }

    /**
     * Devolve os exemplares libres do libro
     * 
     * @return
     */
    public List<Exemplar> getExemplaresLibres() {
        ArrayList<Exemplar> libres = new ArrayList<>();
        for (Exemplar e : this.exemplares) {
            if (!e.estaAsignadoBiblioteca()) {
                libres.add(e);
            }
        }
        return libres;
    }

    /**
     * Indica se o libro contén un exemplar cun determinado libro
     * 
     * @param id
     * @return
     */
    public boolean containsExemplar(int id) {
        for (Exemplar e : this.exemplares) {
            if (id == e.getId())
                return true;
        }
        return false;
    }

    /**
     * Comproba se o libro ten exemplares libres
     * 
     * @return
     */
    public boolean tenExemplaresLibres() {
        if (this.getExemplaresLibres().size() == 0)
            return false;
        return true;
    }

    /**
     * Devolve un exemplar cun id se é que existe para ese libro
     * 
     * @param id
     * @return
     */
    public Optional<Exemplar> getExemplar(int id) {
        for (Exemplar e : this.exemplares) {
            if (id == e.getId())
                return Optional.of(e);
        }
        return Optional.empty();
    }

    /**
     * Comproba se o libro ten un determinado autor
     * 
     * @param autorBusca
     * @return
     */
    public boolean contenAutor(String autorBusca) {
        Pattern pattern = Pattern.compile(autorBusca, Pattern.CASE_INSENSITIVE);
        if (this.autores.stream().filter(autor -> pattern.matcher(autor).find()).count() > 0)
            return true;
        else
            return false;
    }

    /**
     * Comproba se un ISBN10 é correcto
     * 
     * @param isbn
     * @return
     */
    public static boolean comprobarISBN(String isbn) {
        // Comprobamos que a lonxitude sexa 10
        if (isbn.length() != 10) {
            return false;
        }
        // Comprobamos que tódolos caracteres sexan números
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);
            if (c < '0' || c > '9')
                return false;
        }

        /** Ata aquí podiase ter feito con expresións regulares */

        // Sumamos todos os díxitos agás o último que é o díxito de control
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            char c = isbn.charAt(i);
            int numero = Integer.parseInt(new String(new char[] { c }));
            suma = suma + (numero * (i + 1));
        }

        // Calculamos o resto da suma
        int resto = suma % 11;

        // Se o resto é 10 o díxito de control e X
        if (resto == 10 && isbn.charAt(9) == 'X') {
            return true;
        }
        // Comprobamos que etea ben o díxito de control
        int restoInt = (int) (isbn.charAt(9) - '0');
        if (restoInt == resto) {
            return true;
        }

        // O díxito de control non é correcto
        return false;

    }

    @Override
    public String toString() {
        String c = this.isbn + ", " + this.titulo + " de ";
        for (String autor : this.autores)
            c = c + autor + "; ";
        c = c.substring(0, c.length() - 1);
        return c + this.lingua + " (" + this.editorial + ")";
    }

    @Override
    public int compareTo(Libro l) {
        return this.titulo.compareTo(l.getTitulo());
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public Lingua getLingua() {
        return lingua;
    }

}
