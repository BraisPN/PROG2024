package modelo.usuarios;

import java.util.ArrayList;
import java.util.Optional;

import modelo.Prestamo;
import modelo.excepcions.DniInvalidoException;
import modelo.excepcions.EmailInvalidoException;

public class Lector extends Usuario {

    // Maximo de devolucions tardias que se poden ter no último ano
    private static final int maximoDevoltosTarde = 1;

    
    private String nome;
    private String apelidos;
    private String dni;
    private String email;
    private ArrayList<Prestamo> prestamos;

    /**
     * Crea o usuario
     * @param username
     * @param password
     * @param nome
     * @param apelidos
     * @param dni
     * @param email
     * @throws DniInvalidoException
     * @throws EmailInvalidoException
     */
    public Lector(String username, String password, String nome, String apelidos, String dni, String email)
            throws DniInvalidoException, EmailInvalidoException {
        super(username, password);

        if (!Lector.comprobarDni(dni))
            throw new DniInvalidoException();
        if (!Lector.comprobarEmail(email))
            throw new EmailInvalidoException();

        this.nome = nome;
        this.apelidos = apelidos;
        this.dni = dni;
        this.email = email;

        this.prestamos = new ArrayList<>();
    }

    /**
     * Indica se ten un libro prestado
     * @return
     */
    public boolean tenLibroPrestado() {
        for(Prestamo p: this.prestamos) {
            if (!p.devolto()) return true;
        }
        return false;
    }

    /**
     * Indica se o usuario está sancionado
     * @return
     */
    public boolean estaSancionado() {
        int devoltosTarde = 0;
        for(Prestamo p: this.prestamos) {
            if(p.eDoUltimoAno()) {
                if(p.devoltoTarde()) devoltosTarde++;
            }
        }

        if(devoltosTarde > Lector.maximoDevoltosTarde) return true;
        return false;

    }

    /**
     * Devolve o prestamo actual se é que ten
     * @return
     */
    public Optional<Prestamo> getPrestamoActual() {
        for(Prestamo p: this.prestamos) {
            if(!p.devolto()) return Optional.of(p); 
        }
        return Optional.empty();
    }

    /**
     * Devolve a data de dovulución actual do libro prestado se é que hai
     * @return
     */
    public Optional<String> getDataDevolucionActual() {
        Optional<Prestamo> p = this.getPrestamoActual();
        if(p.isEmpty()) return Optional.empty();
        return Optional.of(p.get().getDataLimiteDevolucion());
    }

    /**
     * Engade un novo préstamo
     * @param prestamo
     */
    public void addPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    /**
     * Comproba se un DNI é válido
     * @param dni
     * @return
     */
    public static boolean comprobarDni(String dni) {
        String dniRegex = "^\\d{8}[A-HJ-NP-TV-Z]$";
        if (!dni.matches(dniRegex)) return false;
        
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letraCalculada = letras.charAt(numero % 23);
        return dni.charAt(8) == letraCalculada;
    }

    /**
     * Comproba se un email é válido
     * @param email
     * @return
     */
    public static boolean comprobarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public boolean equals(Object obj) {
        Lector usuario = (Lector) obj;
        // para que dous usuarios lectores sexan iguais teñen que ter o mesmo DNI
        if(usuario.dni.equals(this.dni)) return true;
        return false;
    }

    public String getNome() {
        return nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.LECTOR;
    }

    

}
