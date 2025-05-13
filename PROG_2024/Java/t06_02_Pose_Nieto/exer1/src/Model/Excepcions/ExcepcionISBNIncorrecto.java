package Model.Excepcions;

public class ExcepcionISBNIncorrecto extends Exception {

    public ExcepcionISBNIncorrecto(String message) {
        super(message);
    }

    public static boolean comprobarISBN(String isbn) {
        if (!isbn.matches("^(\\d{9}[\\dX])$")) {
            return false;
        }
        return true;
    }
}