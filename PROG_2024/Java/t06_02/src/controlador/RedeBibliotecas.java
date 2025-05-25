package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import io.LectorCsv;
import io.RedeIO;
import modelo.Biblioteca;
import modelo.Lingua;
import modelo.Prestamo;
import modelo.excepcions.BibliotecaNonEncontradaException;
import modelo.excepcions.DNIExistenteException;
import modelo.excepcions.DniInvalidoException;
import modelo.excepcions.EmailInvalidoException;
import modelo.excepcions.ExemplarAsignadoException;
import modelo.excepcions.ExemplarNonEncontrado;
import modelo.excepcions.ExemplarOcupadoException;
import modelo.excepcions.ExemplarOcupadoPorOutroException;
import modelo.excepcions.ISBNIncorrectoException;
import modelo.excepcions.LectorConLibroPrestadoException;
import modelo.excepcions.LectorSancionadoException;
import modelo.excepcions.LibroExistenteException;
import modelo.excepcions.LibroNonEncontradoException;
import modelo.excepcions.UsernameExistenteException;
import modelo.excepcions.UsuarioNonEncontradoException;
import modelo.libro.Exemplar;
import modelo.libro.Libro;
import modelo.usuarios.AdministadorBiblioteca;
import modelo.usuarios.AdministradorXeral;
import modelo.usuarios.Usuario;
import modelo.usuarios.Lector;

public class RedeBibliotecas implements Serializable {
    // Patrón singleton
    private static RedeBibliotecas INSTANCE;

    private Hashtable<String, Usuario> usuarios;
    private Hashtable<String, Lector> usuariosLectores;
    private Hashtable<Integer, Biblioteca> bibliotecas;
    private Hashtable<String, Libro> libros;

    // Necesitamos gardar o id de biblioteca dende aquí, porque os atributos
    // estáticos non se gardan
    private int seguinteIdBiblioteca;

    private RedeBibliotecas() {
        this.usuarios = new Hashtable<>();
        this.bibliotecas = new Hashtable<>();
        this.libros = new Hashtable<>();
        this.usuariosLectores = new Hashtable<>();
        this.seguinteIdBiblioteca = 0;
    }

    private int getSeguinteIdBiblioteca() {
        return this.seguinteIdBiblioteca++;
    }

    /**
     * Devolve un usuario se coincide nome de usuario e contrasinal
     * 
     * @param username
     * @param password
     * @return
     */
    public Optional<Usuario> login(String username, String password) {

        if (this.usuarios.containsKey(username)) {
            Usuario user = this.usuarios.get(username);
            if (user.comprobarUsuario(username, password))
                return Optional.of(user);
        }
        return Optional.empty();
    }

    /**
     * Engade unha biblioteca
     * 
     * @param nome
     * @param direccion
     * @param cidade
     * @param provincia
     */
    public void addBiblioteca(String nome, String direccion, String cidade, String provincia) {
        Biblioteca biblio = new Biblioteca(this.getSeguinteIdBiblioteca(), nome, direccion, cidade, provincia);
        this.bibliotecas.put(biblio.getId(), biblio);
        this.gardar();
    }

    /**
     * Devolve unha lista con tódalas bibliotecas
     * 
     * @return
     */
    public List<Biblioteca> getBibliotecas() {
        return new ArrayList<>(this.bibliotecas.values());
    }

    /**
     * Engade un libro
     * 
     * @param titulo
     * @param editorial
     * @param isbn
     * @param lingua
     * @param numeroExemplares
     * @param autores
     * @throws ISBNIncorrectoException
     * @throws LibroExistenteException
     */
    public void addLibro(String titulo, String editorial, String isbn, Lingua lingua, int numeroExemplares,
            List<String> autores)
            throws ISBNIncorrectoException, LibroExistenteException {
        Libro novoLibro = new Libro(titulo, editorial, isbn, lingua, numeroExemplares);

        // Comprobamos se xa está o libro metido
        if (this.libros.containsKey(isbn))
            throw new LibroExistenteException();

        for (String autor : autores)
            novoLibro.addAutor(autor);

        this.libros.put(novoLibro.getIsbn(), novoLibro);
        this.gardar();
    }

    public void addLibroFromCsv(String uriCsv) {

        List<Libro> datos = LectorCsv.leerCsv(uriCsv);
        for (Libro l : datos) {
            if (!this.libros.containsKey(l.getIsbn()))
                this.libros.put(l.getIsbn(), l);
        }
        this.gardar();
    }

    /**
     * Devolve unha lista de libros
     * 
     * @return
     */
    public List<Libro> getLibros() {
        return new ArrayList<>(this.libros.values());
    }

    /**
     * Devolve os exemplares libres dun libro
     * 
     * @param isbn
     * @return
     * @throws LibroNonEncontradoException
     */
    public List<Exemplar> getExemplaresLibres(String isbn) throws LibroNonEncontradoException {
        if (!this.libros.containsKey(isbn))
            throw new LibroNonEncontradoException();

        // Collemos o libro
        Libro l = this.libros.get(isbn);

        // Devolvemos os exemplares libres
        return l.getExemplaresLibres();

    }

    /**
     * Asgina un exemplar a unha biblioteca
     * 
     * @param isbn
     * @param idExemplar
     * @param idBiblioteca
     * @throws LibroNonEncontradoException
     * @throws ExemplarNonEncontrado
     * @throws BibliotecaNonEncontradaException
     * @throws ExemplarAsignadoException
     */
    public void asignarExemplarBiblioteca(String isbn, int idExemplar, int idBiblioteca)
            throws LibroNonEncontradoException, ExemplarNonEncontrado, BibliotecaNonEncontradaException,
            ExemplarAsignadoException {

        // Collemos tódolos obxectos
        if (!this.libros.containsKey(isbn))
            throw new LibroNonEncontradoException();

        // Collemos o libro
        Libro libro = this.libros.get(isbn);
        if (!libro.containsExemplar(idExemplar))
            throw new ExemplarNonEncontrado();

        Exemplar exemplar = libro.getExemplar(idExemplar).get();

        if (exemplar.estaAsignadoBiblioteca())
            throw new ExemplarAsignadoException();

        if (!this.bibliotecas.containsKey(idBiblioteca))
            throw new BibliotecaNonEncontradaException();

        Biblioteca biblio = this.bibliotecas.get(idBiblioteca);

        // Agora podemos facela asignación
        biblio.engadirExemplar(exemplar);
        this.gardar();

    }

    /**
     * Crea un administrador de bibliotecas
     * 
     * @param username
     * @param password
     * @param idBiblioteca
     * @throws BibliotecaNonEncontradaException
     * @throws UsernameExistenteException
     */
    public void crearAdminBiblioteca(String username, String password, int idBiblioteca)
            throws BibliotecaNonEncontradaException, UsernameExistenteException {
        if (!this.bibliotecas.containsKey(idBiblioteca))
            throw new BibliotecaNonEncontradaException();

        if (this.usuarios.containsKey(username))
            throw new UsernameExistenteException();

        Biblioteca biblio = this.bibliotecas.get(idBiblioteca);
        AdministadorBiblioteca admin = new AdministadorBiblioteca(username, password, biblio);
        this.usuarios.put(admin.getUsername(), admin);
        this.gardar();
    }

    /**
     * Realiza un préstamos dun exemplar
     * 
     * @param biblio
     * @param dni
     * @param idExemplar
     * @throws UsuarioNonEncontradoException
     * @throws ExemplarNonEncontrado
     * @throws ExemplarOcupadoException
     * @throws LectorConLibroPrestadoException
     * @throws LectorSancionadoException
     */
    public void realizarPrestamo(Biblioteca biblio, String dni, int idExemplar)
            throws UsuarioNonEncontradoException, ExemplarNonEncontrado, ExemplarOcupadoException,
            LectorConLibroPrestadoException, LectorSancionadoException {
        if (!this.usuariosLectores.containsKey(dni))
            throw new UsuarioNonEncontradoException();

        Lector lector = usuariosLectores.get(dni);

        if (!biblio.existeIdExemplar(idExemplar))
            throw new ExemplarNonEncontrado();

        Exemplar exemplar = biblio.getExemplar(idExemplar).get();

        if (exemplar.estaOcupado())
            throw new ExemplarOcupadoException();

        // Comprobamos se o usuario ten libros agora mesmo prestados
        if (lector.tenLibroPrestado())
            throw new LectorConLibroPrestadoException();

        // Comprobamos se o lector está sancionado
        if (lector.estaSancionado())
            throw new LectorSancionadoException();

        // Podemos facelo prestamos
        new Prestamo(exemplar, lector);
        this.gardar();

    }

    /**
     * Realiza a devolución dun exemplar
     * 
     * @param biblio
     * @param dni
     * @param idExemplar
     * @throws UsuarioNonEncontradoException
     * @throws ExemplarNonEncontrado
     * @throws ExemplarOcupadoPorOutroException
     */
    public void realizarDevolucion(Biblioteca biblio, String dni, int idExemplar)
            throws UsuarioNonEncontradoException, ExemplarNonEncontrado, ExemplarOcupadoPorOutroException {

        if (!this.usuariosLectores.containsKey(dni))
            throw new UsuarioNonEncontradoException();

        Lector lector = usuariosLectores.get(dni);

        if (!biblio.existeIdExemplar(idExemplar))
            throw new ExemplarNonEncontrado();

        Exemplar exemplar = biblio.getExemplar(idExemplar).get();

        if (!exemplar.estaOcupadoPor(lector))
            throw new ExemplarOcupadoPorOutroException();

        // Collemos o prestamo do usuario e facemos a devolucion
        Prestamo prestamo = lector.getPrestamoActual().get();
        prestamo.devolver();
        this.gardar();
    }

    /**
     * Crea un usuario lector
     * 
     * @param nome
     * @param apelidos
     * @param dni
     * @param email
     * @param username
     * @param password
     * @throws UsernameExistenteException
     * @throws DniInvalidoException
     * @throws EmailInvalidoException
     * @throws DNIExistenteException
     */
    public void crearUsuarioLector(String nome, String apelidos, String dni, String email, String username,
            String password)
            throws UsernameExistenteException, DniInvalidoException, EmailInvalidoException, DNIExistenteException {
        if (this.usuarios.containsKey(username))
            throw new UsernameExistenteException();

        Lector lector = new Lector(username, password, nome, apelidos, dni, email);

        if (this.usuariosLectores.containsKey(dni))
            throw new DNIExistenteException();

        this.usuarios.put(username, lector);
        this.usuariosLectores.put(dni, lector);
        this.gardar();

    }

    /**
     * Fai unha busca por título
     * 
     * @param titulo
     * @return
     */
    public List<Libro> buscaPorTitulo(String titulo) {
        Pattern pattern = Pattern.compile(titulo, Pattern.CASE_INSENSITIVE);
        return this.libros.values().stream()
                .filter(l -> pattern.matcher(l.getTitulo()).find())
                .filter(l -> l.tenExemplaresLibres())
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Fai unha busca por autor
     * 
     * @param autor
     * @return
     */
    public List<Libro> buscaPorAutor(String autor) {
        return this.libros.values().stream()
                .filter(l -> l.contenAutor(autor))
                .filter(l -> l.tenExemplaresLibres())
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Garda os datos da bibloteca
     */
    public void gardar() {
        RedeIO.gardar(INSTANCE);
    }

    public static RedeBibliotecas getInstance() {
        // Se inda non se accedeu, inicializase
        if (INSTANCE == null) {

            // Intentamos cargar
            Optional<RedeBibliotecas> lectura = RedeIO.cargar();

            // Dependendo de se hai ficheiro ou non, gardamos o que lemos ou creamos o
            // obxecto de cero
            if (lectura.isEmpty()) {
                INSTANCE = new RedeBibliotecas();
                // Engadimos o administrador xeral
                Biblioteca b = new Biblioteca(0, "a", "a", "a", "a");
                INSTANCE.bibliotecas.put(b.getId(), b);
                AdministradorXeral adminXeral = new AdministradorXeral("admin", "abc123.");
                AdministadorBiblioteca adminBiblio = new AdministadorBiblioteca("adminb", "abc", b);
                INSTANCE.usuarios.put(adminBiblio.getUsername(), adminBiblio);
                INSTANCE.usuarios.put(adminXeral.getUsername(), adminXeral);
                INSTANCE.gardar();
            } else
                INSTANCE = lectura.get();

        }
        return INSTANCE;
    }

    // Esto permite que non se clone o obxecto
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
