import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Figura> figuras = new ArrayList<Figura>();
        figuras.add(new Rectangulo(5,6));
        figuras.add(new Circulo(7));
        
        for(Figura f: figuras){
            System.out.println("Área do " + f.toString() + " " +  f.calcularArea());
        }
    }
}
