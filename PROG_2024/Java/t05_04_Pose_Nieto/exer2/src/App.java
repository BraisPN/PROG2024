import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Email> listaEmails = new ArrayList<>();
        ArrayList<EmailSanClemente> listaSanClemente = new ArrayList<>();

        String[] correos = {
                "maria.gomez@iessanclemente.net",
                "juan.perez@gmail.com",
                "laura.fernandez@iessanclemente.net",
                "laura.fernandeziessanclemente.net",
                "carlos.rodriguez@yahoo.com",
                "ana.martinez@iessanclemente.net",
                "pedro.lopez@hotmail.com",
                "sofia.rivas@iessanclemente.net",
                "miguel.vazquez@outlook.com",
                "paula.castro@iessanclemente.net",
                "david.sanchez@protonmail.com",
                "david.sanchez@protonmail"
        };

        for (String correo : correos) {
            try {
                Email email = new Email(correo);
                listaEmails.add(email);

                /*
                 * Este try dentro de outro esta para que se hay algun email que non e correcto
                 * xa non diga que tampouco e correo do iessanclemente.
                 */
                try {
                    EmailSanClemente emailSC = new EmailSanClemente(correo);
                    listaSanClemente.add(emailSC);
                } catch (EmailInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            } catch (EmailInvalidoException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("\nEmails:");
        for (Email e : listaEmails) {
            System.out.println(e);
        }

        System.out.println("\nEmails do IES San Clemente:");
        for (EmailSanClemente e : listaSanClemente) {
            System.out.println(e);
        }
    }
}
