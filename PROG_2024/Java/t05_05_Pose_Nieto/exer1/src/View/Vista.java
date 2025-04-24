package View;

public class Vista {

    public void inicio() {
        System.out.println("**************************");
        System.out.println("**************************");
        System.out.println("*** BENVIDO A MUSI.COM ***");
        System.out.println("**************************");
        System.out.println("**************************");
        System.out.println("\nDesea iniciar sesión (s/n)");
    }

    public void inicioSesion() {
        System.out.println("\nUsuario -> ");
        System.out.println("Contrasinal ->");
    }

    public void menuAdministrador() {
        System.out.println("1) Engadir produto");
        System.out.println("2) Ver produtos");
        System.out.println("3) Engadir stock");
        System.out.println("4) Eliminar stock");

        // Engadir produto (submenú para escoller tipo)
        // Ver produtos (submenú):
        // Engadir stock (por identificador)
        // Eliminar stock (por identificador)
    }

    public void menuProductosAdmin() {
        System.out.println("1) Tódolos produtos");
        System.out.println("2) Tódolos instrumentos");
        System.out.println("3) Tódalas frautas");
        System.out.println("4) Tódolos saxofóns");
        System.out.println("5) Tódolos trombóns");
        System.out.println("6) Tódolos complementos");
        System.out.println("7) Tódolos libros");
        System.out.println("8) Tódolos estoxos");
        System.out.println("9) Información dun produto concreto (por identificador)");
    }

    public void menuCliente() {
        System.out.println("1) Ver produtos");
        System.out.println("2) Comprar unha unidade");

        // Ver produtos (submenú)
        // Comprar unha unidade (por identificador, sen almacenar compras, só modificar stock)
    }

    public void menuProductosCliente() {
        System.out.println("1) Tódolos produtos");
        System.out.println("2) Tódolos instrumentos");
        System.out.println("3) Tódalas frautas");
        System.out.println("4) Tódolos saxofóns");
        System.out.println("5) Tódolos trombóns");
        System.out.println("6) Tódolos complementos");
        System.out.println("7) Tódolos libros");
        System.out.println("8) Tódolos estoxos");
    }
}
