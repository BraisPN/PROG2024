public class EmailSanClemente extends Email {

    public EmailSanClemente(String email) throws EmailInvalidoException {
        super(email);
        if (!comprobarEmail(email)) {
            throw new EmailInvalidoException(getMessageError(email));
        }
    }

    @Override
    public boolean comprobarEmail(String email) {
        return email.matches("^[\\w.-]+@iessanclemente\\.net$");
    }

    @Override
    public String getMessageError(String email) {
        return "Esta cadea non é un correo San Clemente: " + email;
    }
}
