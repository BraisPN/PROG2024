package vista;

import java.util.ArrayList;
import java.util.List;

import controlador.RedeBibliotecas;
import modelo.Biblioteca;
import modelo.Lingua;
import modelo.excepcions.BibliotecaNonEncontradaException;
import modelo.excepcions.ExemplarAsignadoException;
import modelo.excepcions.ExemplarNonEncontrado;
import modelo.excepcions.ISBNIncorrectoException;
import modelo.excepcions.LibroExistenteException;
import modelo.excepcions.LibroNonEncontradoException;
import modelo.excepcions.UsernameExistenteException;
import modelo.libro.Exemplar;
import modelo.libro.Libro;
import modelo.usuarios.AdministradorXeral;

public class MenuAdminXeral extends Menu {

    // Almacenamos o usuario
    private AdministradorXeral usuario;

    public MenuAdminXeral(AdministradorXeral usuario) {
        this.usuario = usuario;
    }

    public void mostrar() {

        this.printMessage("Benvido " + this.usuario.getUsername());

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Administrador Xeral");
            this.printMessage("\ta) Dar de alta biblioteca");
            this.printMessage("\tb) Mostrar bibliotecas");
            this.printMessage("\tc) Engadir libro");
            this.printMessage("\td) Engadir libro mediante CSV");
            this.printMessage("\te) Mostrar libros");
            this.printMessage("\tf) Asignar Exemplares");
            this.printMessage("\tg) Crear Administrador Biblioteca");
            this.printMessage("\ts) Sair");

            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {

                // Dar de alta biblioteca
                case "a" -> {
                    // pedimos os datos da biblioteca
                    String nome = this.getString("Introduza o nome da bilioteca: ");
                    String direccion = this.getString("Introduza a direccion: ");
                    String cidade = this.getString("Introduza a cidade: ");
                    String provincia = this.getString("Introduza a provincia: ");

                    // Engadimos a biblioteca
                    RedeBibliotecas.getInstance().addBiblioteca(nome, direccion, cidade, provincia);
                }

                // Mostrar bibliotecas
                case "b" -> {
                    // pedimos os datos da biblioteca
                    List<Biblioteca> bibliotecas = RedeBibliotecas.getInstance().getBibliotecas();

                    // Imprimimos as bibliotecas
                    for (Biblioteca b : bibliotecas)
                        System.out.println(b);
                }

                // Engadir Libro
                case "c" -> {
                    // pedimos os datos do libro
                    String titulo = this.getString("Introduza o título do libro: ");
                    String editorial = this.getString("Introduza a editorial do libro: ");
                    String isbn = this.getString("Introduza o isbn do libro: ");

                    this.printMessage("Selecciona unha lingua (Por defecto é galego):");
                    this.printMessage("\te) Español");
                    this.printMessage("\ti) Ingles");
                    this.printMessage("\tg) Galego");
                    String lingua = this.getString("\t>");
                    Lingua linguaEnu = switch (lingua) {
                        case "e" -> Lingua.CASTELAN;
                        case "i" -> Lingua.INGLES;
                        default -> Lingua.GALEGO;
                    };

                    int exemplares = this.getInt("Indica o número de exemplares: ");

                    ArrayList<String> autores = new ArrayList<>();
                    boolean maisAutores = true;
                    do {
                        String autor = this.getString("Indica o nome dun autor: ");
                        autores.add(autor);
                        this.printMessage("Queres introducir máis autores (Por defecto non):");
                        this.printMessage("\ts) Si");
                        this.printMessage("\tn) Non");
                        String mais = this.getString("\t>");
                        switch (mais) {
                            case "s" -> maisAutores = true;
                            case "n" -> maisAutores = false;
                            default -> maisAutores = false;
                        }
                        ;
                    } while (maisAutores);

                    try {
                        // Engadimos o libro
                        RedeBibliotecas.getInstance().addLibro(titulo, editorial, isbn, linguaEnu, exemplares, autores);
                    } catch (ISBNIncorrectoException e) {
                        this.printMessage("ISBN incorrecto");
                    } catch (LibroExistenteException e) {
                        this.printMessage("O libro xa existe");
                    }
                }

                // Engadir libro mediante CSV
                case "d" -> {
                    RedeBibliotecas.getInstance().addLibroFromCsv("data.csv");
                }

                // Mostrar libros
                case "e" -> {
                    // pedimos os datos da biblioteca
                    List<Libro> libros = RedeBibliotecas.getInstance().getLibros();

                    // Imprimimos as bibliotecas
                    for (Libro l : libros)
                        System.out.println(l);
                }

                // Asignar exemplares
                case "f" -> {
                    try {
                        // Pedimos un ISBN
                        String isbn = this.getString("Introduce un ISBN: ");
                        List<Exemplar> exemplares = RedeBibliotecas.getInstance().getExemplaresLibres(isbn);
                        for (Exemplar e : exemplares)
                            System.out.println(e);
                        int idExe = this.getInt("Indica o id do exemplar: ");
                        int idBiblio = this.getInt("Indica o id da biblioteca: ");

                        // Asginamos o exemplar a biblioteca
                        RedeBibliotecas.getInstance().asignarExemplarBiblioteca(isbn, idExe, idBiblio);

                    } catch (LibroNonEncontradoException e) {
                        this.printMessage("O libro con ese ISBN non existe");
                    } catch (ExemplarNonEncontrado e) {
                        this.printMessage("Exemplar non atopado");
                    } catch (BibliotecaNonEncontradaException e) {
                        this.printMessage("Biblioteca non atopada");
                    } catch (ExemplarAsignadoException e1) {
                        this.printMessage("Exemplar xa asginado a unha biblioteca");
                    }
                }

                // Crear Administrador Biblioteca
                case "g" -> {
                    try {
                        // pedimos os datos
                        String usename = this.getString("Indique o username: ");
                        String password = this.getString("Indique o contrasinal: ");
                        int idBiblio = this.getInt("Indique o id da biblioteca: ");

                        // Creamos o administrador
                        RedeBibliotecas.getInstance().crearAdminBiblioteca(usename, password, idBiblio);
                    } catch (BibliotecaNonEncontradaException e) {
                        this.printMessage("Biblioteca non atopada");
                    } catch (UsernameExistenteException e) {
                        this.printMessage("Nome de usuario xa existente");
                    }

                }

                // Sair
                case "s" -> {
                    this.printMessage("Saíndo do programa");
                    menuActivo = false;
                }

                // Opcion por defecto
                default -> this.printMessage("Elixe unha opcion correcta");
            }
        }
    }

}
