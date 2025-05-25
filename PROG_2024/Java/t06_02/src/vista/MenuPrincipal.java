package vista;

import java.util.Optional;

import controlador.RedeBibliotecas;
import modelo.excepcions.DNIExistenteException;
import modelo.excepcions.DniInvalidoException;
import modelo.excepcions.EmailInvalidoException;
import modelo.excepcions.UsernameExistenteException;
import modelo.usuarios.AdministadorBiblioteca;
import modelo.usuarios.AdministradorXeral;
import modelo.usuarios.TipoUsuario;
import modelo.usuarios.Usuario;
import modelo.usuarios.Lector;

public class MenuPrincipal extends Menu {

    public void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Principal");
            this.printMessage("\ta) Iniciar sesión");
            this.printMessage("\tb) Rexistrarse");
            this.printMessage("\ts) Sair");

            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {

                // Iniciar Sesion
                case "a" -> {
                    String username = this.getString("Introduza un nome de usuario: ");
                    String password = this.getString("Introduza o contrasinal: ");

                    Optional<Usuario> usuario = RedeBibliotecas.getInstance().login(username, password);
                    if (usuario.isPresent()) {
                        if (usuario.get().getTipo().equals(TipoUsuario.ADMIN_XERAL)) {
                            new MenuAdminXeral((AdministradorXeral)usuario.get()).run();
                        } else if (usuario.get().getTipo().equals(TipoUsuario.ADMIN_BIBLITOECA)) {
                            new MenuAdminBiblio((AdministadorBiblioteca)usuario.get()).run();;
                        } else {
                            new MenuLector((Lector) usuario.get()).run();
                        }
                    }
                    else {
                        this.printMessage("Non se puido iniciar sesión.");
                    }
                }

                // Rexistrarse
                case "b" -> {
                    try {
                        String nome = this.getString("Introduce o teu nome: ");
                        String apelidos = this.getString("Introduce os teus apelidos: ");
                        String dni = this.getString("Introduce o teu dni: ");
                        String email = this.getString("Introduce o teu correo electrónico: ");
                        String username = this.getString("Introduce o teu nome de usuario: ");
                        String password = this.getString("Introduce o teu contrasinal: ");
                        RedeBibliotecas.getInstance().crearUsuarioLector(nome, apelidos, dni, email, username, password);
                    } catch (UsernameExistenteException e) {
                        this.printMessage("O nome de usuario xa existe");
                    } catch (DniInvalidoException e) {
                        this.printMessage("O dni é inválido");
                    } catch (EmailInvalidoException e) {
                        this.printMessage("O email é inválido");
                    } catch (DNIExistenteException e) {
                        this.printMessage("O dni xa existe no sistema");
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
