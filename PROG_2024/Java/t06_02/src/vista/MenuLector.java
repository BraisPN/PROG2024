package vista;

import java.util.List;
import java.util.Optional;

import controlador.RedeBibliotecas;
import modelo.libro.Libro;
import modelo.usuarios.Lector;

public class MenuLector extends Menu {

    // Alamcenamos o usuario
    private Lector usuario;

    public MenuLector(Lector usuario) {
        this.usuario = usuario;
    }

    public void mostrar() {
        this.printMessage("Benvido " + this.usuario.getUsername());

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Administrador Xeral");
            this.printMessage("\ta) Buscar por titulo");
            this.printMessage("\tb) Buscar por autor");
            this.printMessage("\tc) Ver data devolución préstamo en curso");
            this.printMessage("\ts) Sair");

            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {

                // Buscar por titulo
                case "a" -> {
                    String titulo = this.getString("Indica un titulo: ");
                    List<Libro> libros = RedeBibliotecas.getInstance().buscaPorTitulo(titulo);
                    this.printList(libros);
                }

                // Buscar por autor
                case "b" -> {
                    String titulo = this.getString("Indica un autor: ");
                    List<Libro> libros = RedeBibliotecas.getInstance().buscaPorAutor(titulo);
                    this.printList(libros);
                }

                // Ver data devolución préstamo en curso"
                case "c" -> {
                    Optional<String> data = this.usuario.getDataDevolucionActual();
                    if (data.isPresent())
                        this.printMessage(data.get());
                    else
                        this.printMessage("Non hai libros prestados actualmente");;
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
