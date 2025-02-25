public class App {
    public static void main(String[] args) throws Exception {
        Cadrado c1 = new Cadrado(9.3, Unidades.KM);
        Cadrado c2 = new Cadrado(1.5);
        System.out.println();
        System.out.println("Perimetro de c1: "+ c1.getPerimetro(Unidades.DM)+" dm");
        System.out.println("Perimetro de c2: "+ c2.getPerimetro(Unidades.DM)+" dm");
        System.out.println();
        System.out.println("Área de c1: "+ c1.getArea(Unidades.CM)+ " cm2");
        System.out.println("Área de c2: "+ c2.getArea(Unidades.CM)+ " cm2");
        System.out.println();
    }
}
