public class EmailInvalidoException extends Exception {
    /**
     * Construtor con mensaxe personalizada.
     * @param message Mensaxe de erro.
     */
    public EmailInvalidoException(String message) {
        super(message);
    }
}
