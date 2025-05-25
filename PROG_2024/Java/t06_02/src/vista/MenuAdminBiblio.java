package vista;

import controlador.RedeBibliotecas;
import modelo.excepcions.ExemplarNonEncontrado;
import modelo.excepcions.ExemplarOcupadoException;
import modelo.excepcions.ExemplarOcupadoPorOutroException;
import modelo.excepcions.LectorConLibroPrestadoException;
import modelo.excepcions.LectorSancionadoException;
import modelo.excepcions.UsuarioNonEncontradoException;
import modelo.libro.Exemplar;
import modelo.usuarios.AdministadorBiblioteca;

public class MenuAdminBiblio extends Menu {

    // Almacenamos o usuario
    private AdministadorBiblioteca usuario;

    public MenuAdminBiblio(AdministadorBiblioteca usuario) {
        this.usuario = usuario;
    }

    public void mostrar() {

        this.printMessage("Benvido " + this.usuario.getUsername());

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Administrador Xeral");
            this.printMessage("\ta) Ver Exemplares");
            this.printMessage("\tb) Realizar Préstamo");
            this.printMessage("\tc) Realizar Devolucion");
            this.printMessage("\ts) Sair");

            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {

                // Ver Exemplares
                case "a" -> {
                    // Mostramos os exemplares
                    for(Exemplar e: this.usuario.getBiblioteca().getExemplaresLibres())
                        System.out.println(e);

                }

                // b) Realizar Préstamo
                case "b" -> {
                    try {
                        // Pedimos os datos
                        String dni = this.getString("Introduce o DNI do usuario: ");
                        int id = this.getInt("Introduce o id do exemplar: ");

                        // Realizamos o prestamo
                        RedeBibliotecas.getInstance().realizarPrestamo(usuario.getBiblioteca(), dni, id);
                    } catch (UsuarioNonEncontradoException e) {
                        this.printMessage("Usuario non atopado");
                    } catch (ExemplarNonEncontrado e) {
                        this.printMessage("Exemplar non atopado");
                    } catch (ExemplarOcupadoException e) {
                        this.printMessage("Exemplar xa ocupado");
                    } catch (LectorConLibroPrestadoException e) {
                        this.printMessage("O lector xa ten un libro prestado");
                    } catch (LectorSancionadoException e) {
                        this.printMessage("O lector está sancionado");
                    }

                }


                // c) Devolver Préstamo
                case "c" -> {
                    try {
                        // Pedimos os datos
                        String dni = this.getString("Introduce o DNI do usuario: ");
                        int id = this.getInt("Introduce o id do exemplar: ");

                        // Realizamos a devolución
                        RedeBibliotecas.getInstance().realizarDevolucion(usuario.getBiblioteca(), dni, id);
                    } catch (UsuarioNonEncontradoException e) {
                        this.printMessage("Usuario non atopado");
                    } catch (ExemplarNonEncontrado e) {
                        this.printMessage("Exemplar non atopado");
                    } catch (ExemplarOcupadoPorOutroException e) {
                        this.printMessage("O usuario non ten prestado ese libro");
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
