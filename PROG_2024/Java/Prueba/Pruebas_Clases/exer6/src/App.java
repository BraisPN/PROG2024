public class App {
    public static void main(String[] args) throws Exception {

        Portatil p1 = new Portatil("iMac", "1234", Cor.VERDE);

        System.out.println(p1.getModelo() +", "+ p1.getNS() + ", "+p1.getCor());
        
        p1.setCor(Cor.NEGRO);
        
        System.out.println(p1.getModelo() +", "+ p1.getNS() + ", "+p1.getCor());

    
    }

}
