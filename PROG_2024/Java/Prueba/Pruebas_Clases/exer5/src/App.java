public class App {
    public static void main(String[] args) throws Exception {     
        
        // Creamos os rectangulos (metemos todo en cm)
        Alumno manuel = new Alumno("Manuel", "Varela");
        Alumno jhon = new Alumno("Jhon", "Doe");

        // Metemos as notas medias de manuel
        manuel.setNota1(7);
        manuel.setNota2(4);

        String mensaxe = "";

        // Imprimimos os datos de manuel
        mensaxe = manuel.getApelidos() + ", " + manuel.getNome() + " con exp. " +
            manuel.getExpediente() + " con nota " + manuel.getMedia();
        System.out.println(mensaxe);

        // Imprimimos se manuel está aprobado ou non
        if (manuel.aprobado()) {
            System.out.println("Aprobado");
        }
        else {
            System.out.println("Suspenso");
        }

        // Poeñmos outra nota de manuel e imprimimos
        manuel.setNota3(9);
        if (manuel.aprobado()) {
            System.out.println("Aprobado");
        }
        else {
            System.out.println("Suspenso");
        }

        // Imprimimos os datos de manuel
        mensaxe = jhon.getApelidos() + ", " + jhon.getNome() + " con exp. " +
            jhon.getExpediente() + " con nota " + jhon.getMedia();
        System.out.println(mensaxe);
    }

}