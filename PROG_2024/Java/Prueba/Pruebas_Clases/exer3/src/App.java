public class App {
    public static void main(String[] args) throws Exception {
        Rectangulo r1 = new Rectangulo(7.5, 3);
        Rectangulo r2 = new Rectangulo(10, 5);

        System.out.println("Rectangulo 1 - Area: "+r1.getArea()+" cm2 , Perímetro: "+r1.getPerimetro()+" cm");
        System.out.println("Rectangulo 2 - Area: "+r2.getArea()+" cm2 , Perímetro: "+r2.getPerimetro()+" cm");

    }
}
