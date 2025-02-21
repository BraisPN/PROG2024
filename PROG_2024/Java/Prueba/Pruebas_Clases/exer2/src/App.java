public class App {
    public static void main(String[] args) throws Exception {
        Coche c1 = new Coche("Seat", "Ibiza", "Vermello");
        Coche c2 = new Coche("Seat", "León", "Negro", 3);
    
        System.err.println(c1.getMarca() + " " + c1.getModelo() + ": " + c1.getCor()+" "+c1.getPasaxeiros());
        System.err.println(c2.getMarca() + " " + c2.getModelo() + ": " + c2.getCor()+" "+c2.getPasaxeiros());

    }
}
