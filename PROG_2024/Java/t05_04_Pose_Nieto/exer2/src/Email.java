import java.util.regex.*;

public class Email {
    private String email;

    public Email(String email) throws EmailInvalidoException {
        setEmail(email);
    }

    public boolean comprobarEmail(String email) {
        Pattern pattern = Pattern.compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getDominio() {
        Pattern pattern = Pattern.compile("@(.+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find() ? matcher.group(1) : "";
    }

    public String getConta() {
        Pattern pattern = Pattern.compile("^(.+)@");
        Matcher matcher = pattern.matcher(email);
        return matcher.find() ? matcher.group(1) : "";
    }

    public String getMessageError(String email) {
        return "Esta cadea non é un correo: " + email;
    }

    public void setEmail(String email) throws EmailInvalidoException {
        if (!comprobarEmail(email)) {
            throw new EmailInvalidoException(getMessageError(email));
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return getDominio() + ": " + getConta();
    }

    public String getEmail() {
        return email;
    }
}
